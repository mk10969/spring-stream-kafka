//package org.uma.cloud.springkafkastream;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.kstream.Grouped;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Materialized;
//import org.apache.kafka.streams.kstream.TimeWindows;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Supplier;
//
//@Configuration
//@EnableScheduling
//public class WordCountProcessorApplication {
//
//    @Bean
//    @Scheduled(fixedDelay = 1000)
//    public Supplier<String> source() {
//        return () -> RandomStringUtils.randomAlphabetic(20);
//    }
//
////    @Bean
////    public Function<KStream<Object, String>, KStream<?, WordCount>> process() {
////        return input -> input
////                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
////                .map((key, value) -> new KeyValue<>(value, value))
////                .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
////                .windowedBy(TimeWindows.of(Duration.ofSeconds(60)))
////                .count(Materialized.as("WordCounts-1"))
////                .toStream()
////                .map((key, value) -> new KeyValue<>(null,
////                        new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
////    }
//
//    @Bean
//    public Consumer<String> sink() {
//        return s -> System.out.println("FOOBAR -- " + s);
//    }
//
//
//    static class WordCount {
//
//        private String word;
//
//        private long count;
//
//        private Date start;
//
//        private Date end;
//
//        WordCount(String word, long count, Date start, Date end) {
//            this.word = word;
//            this.count = count;
//            this.start = start;
//            this.end = end;
//        }
//    }
//
//
//}
