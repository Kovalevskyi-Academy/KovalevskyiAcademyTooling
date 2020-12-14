#!/bin/bash -x

# This command regenerates the docs after editing.

mvn clean package --projects :docs --batch-mode -Pbuild-docs