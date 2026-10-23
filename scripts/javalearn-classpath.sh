#!/usr/bin/env bash
# Shared classpath helpers for JavaLearn (vendored + downloaded test deps).
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEPS_DIR="${JAVA_LEARN_DEPS_DIR:-$REPO_ROOT/.deps}"

junit_classpath() {
  echo "${DEPS_DIR}/junit-4.12.jar:${DEPS_DIR}/hamcrest-core-1.3.jar"
}

fastjson_classpath() {
  echo "${REPO_ROOT}/lib/fastjson-1.2.47.jar"
}

spring_classpath() {
  find "${REPO_ROOT}/Spring/lib" -name '*.jar' | tr '\n' ':' | sed 's/:$//'
}
