#! /bin/bash

pid_file="./pid"

java -jar ./build/libs/spring-stream-kafka-0.0.1-SNAPSHOT.jar &

pid=$!
echo ${pid} > ${pid_file}

#sleep 3
#
#wait $(cat ${pid_file})

STATUS=$?
echo "${STATUS}"

echo `/bin/ps -p ${pid}`

if [[ -f "$pid_file" ]]; then
    proc=$(cat ${pid_file});
    echo "$proc"
    if /bin/ps -p $proc 1>&2 > /dev/null;
    then
        echo "!!!!!!!"
    fi
fi

#if [[ 0 -lt ${STATUS} ]]; then
#  echo "OK"
#else
#  echo "NG"
#fi
