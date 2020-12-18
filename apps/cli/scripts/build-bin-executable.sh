#!/bin/bash

if [ $# -lt 2 ]
then
    echo "Usage:"
    echo "./build-bin-executable.sh <artefactId> <version>"
    exit 1
fi

artefactId="$1"
version="$2"

OUT_FILE="target/talos"
JAR_FILE="target/${artefactId}-${version}.jar"

if [ -f "${JAR_FILE}" ]; then
  rm -f "${OUT_FILE}"

  cat > "$OUT_FILE" << EOF
#!/bin/bash

MYSELF=\`which "\$0" 2>/dev/null\`
[ \$? -gt 0 -a -f "\$0" ] && MYSELF="./\$0"
java=java
if test -n "\$JAVA_HOME"; then
    java="\$JAVA_HOME/bin/java"
fi
exec "\$java" \$java_args -jar \$MYSELF "\$@"
exit 1

EOF

  cat "$JAR_FILE" >> "$OUT_FILE"
  chmod +x "$OUT_FILE"

  mkdir -p "$HOME/.local/bin"
  cp -f "$OUT_FILE" "$HOME/.local/bin/"
else
  printf "'%s' Not Found" "$JAR_FILE"
  exit 1
fi
