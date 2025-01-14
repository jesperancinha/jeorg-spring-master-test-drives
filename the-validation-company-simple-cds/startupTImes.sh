#!/usr/bin/env sh
#!/bin/bash
start_time=$(date +%s%3N)
docker run --rm the-validation-company-traditional:latest
end_time=$(date +%s%3N)
runtime=$((end_time - start_time))
echo "Container the-validation-company-traditional runtime: $runtime ms"


start_time=$(date +%s%3N)
docker run --rm the-validation-company:latest
end_time=$(date +%s%3N)
runtime=$((end_time - start_time))
echo "Container the-validation-company runtime: $runtime ms"