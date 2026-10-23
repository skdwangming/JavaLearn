#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
# shellcheck source=scripts/javalearn-classpath.sh
source "${REPO_ROOT}/scripts/javalearn-classpath.sh"

OUT="${JAVA_LEARN_BUILD_DIR:-/tmp/javalearn-verify}"
rm -rf "$OUT"
mkdir -p "$OUT"

echo "==> Java toolchain"
java -version
javac -version

echo "==> fastjson demo (main)"
FASTJSON_CP="$(fastjson_classpath)"
javac -encoding UTF-8 -cp "$FASTJSON_CP" -d "$OUT" "${REPO_ROOT}/JSON转换/fastjson/Demo.java"
java -cp "${OUT}:${FASTJSON_CP}" fastjson.Demo

echo "==> JUnit smoke (MapDemo)"
JUNIT_CP="$(junit_classpath)"
javac -encoding UTF-8 -cp "$JUNIT_CP" -d "$OUT" "${REPO_ROOT}/Collection/Map/MapDemo.java"
java -cp "${OUT}:${JUNIT_CP}" org.junit.runner.JUnitCore MapDemo

echo "==> Spring JDK dynamic proxy demo"
SPRING_CP="$(spring_classpath)"
javac -encoding UTF-8 -d "$OUT" "${REPO_ROOT}/Spring/动态代理/JDKProxy/"*.java
java -cp "${OUT}:${SPRING_CP}" JDKProxy.TestJDKProxy

echo "All JavaLearn verification checks passed."
