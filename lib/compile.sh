#!/usr/bin/env bash

for i in `ls ../src/*.kt`
    do
    filename=$(basename "$i")
    filename="${filename%.*}"
    kotlinc -include-runtime "$i" -d "$filename.jar"
done
