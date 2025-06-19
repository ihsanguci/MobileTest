#!/bin/bash
set -e

TAG="@TC1"

echo "Cleaning..."
./gradlew clean

echo "Running test with tag: $TAG"
./gradlew test -Dcucumber.filter.tags=$TAG

echo "Test done."
