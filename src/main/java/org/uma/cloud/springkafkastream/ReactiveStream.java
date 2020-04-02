package org.uma.cloud.springkafkastream;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class ReactiveStream {

    private AtomicBoolean semaphore = new AtomicBoolean(true);

    @Bean
    public Function<Flux<String>, Flux<String>> aggregate() {
        return inbound -> inbound.
                log()
                .window(Duration.ofSeconds(30), Duration.ofSeconds(5))
                .flatMap(w -> w.reduce("", (s1, s2) -> s1 + s2))
                .log();
    }

    //Following source and sinks are used for testing only.
    //Test source will send data to the same destination where the processor receives data
    //Test sink will consume data from the same destination where the processor produces data

    @Bean
    public Supplier<String> testSource() {
        return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";

    }

    @Bean
    public Consumer<String> testSink() {
        return payload -> log.info("Data received: " + payload);

    }

}