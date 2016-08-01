#!/usr/bin/env bash

export JAVA_HOME=/usr/bin/java
function light() {
    if [ -z "$2" ]
    then
        src="abcde";
    else
        src="cat $2";
        hello="你好"
    fi
}





