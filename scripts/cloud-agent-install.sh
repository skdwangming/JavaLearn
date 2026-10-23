#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEPS_DIR="${JAVA_LEARN_DEPS_DIR:-$REPO_ROOT/.deps}"
mkdir -p "$DEPS_DIR"

download_if_missing() {
  local url="$1"
  local dest="$2"
  if [[ -f "$dest" ]]; then
    return 0
  fi
  curl -fsSL -o "$dest" "$url"
}

# Repository vendors JUnit as extracted directories; fetch real JARs for the test runner.
download_if_missing \
  "https://repo1.maven.org/maven2/junit/junit/4.12/junit-4.12.jar" \
  "${DEPS_DIR}/junit-4.12.jar"
download_if_missing \
  "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" \
  "${DEPS_DIR}/hamcrest-core-1.3.jar"

chmod +x "${REPO_ROOT}/scripts/verify-dev-environment.sh" \
  "${REPO_ROOT}/scripts/javalearn-classpath.sh"

bash "${REPO_ROOT}/scripts/verify-dev-environment.sh"
