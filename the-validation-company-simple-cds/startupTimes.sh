#!/usr/bin/env sh
start_time=$(date +%s%3N)
docker run --rm the-validation-company-current-jdk:latest
end_time=$(date +%s%3N)
runtime=$((end_time - start_time))
echo "Container the-validation-company-current-jdk runtime: $runtime ms"


start_time=$(date +%s%3N)
docker run --rm the-validation-company-traditional-jre:latest
end_time=$(date +%s%3N)
runtime=$((end_time - start_time))
echo "Container the-validation-company-traditional-jre runtime: $runtime ms"


start_time=$(date +%s%3N)
docker run --rm the-validation-company:latest
end_time=$(date +%s%3N)
runtime=$((end_time - start_time))
echo "Container the-validation-company runtime: $runtime ms"