#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/kg/*.java tests/TestAlgorithms.java
java -cp out kg.tests.TestAlgorithms
