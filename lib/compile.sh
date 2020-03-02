#!/usr/bin/env bash

# shellcheck disable=SC2045
for i in $(ls ../src/*.kt)
    do
    filename=$(basename "$i")
    filename="${filename%.*}"
    kotlinc -include-runtime "$i" -d "$filename.jar"
done