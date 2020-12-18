# Project Talos

[![Docs](https://github.com/straybro/KovalevskyiAcademyTooling/workflows/Deploy%20documentation/badge.svg)](https://straybro.github.io/KovalevskyiAcademyTooling/)
[![Build CI](https://github.com/straybro/KovalevskyiAcademyTooling/workflows/Build%20CLI/badge.svg)](https://github.com/straybro/KovalevskyiAcademyTooling/actions?query=workflow%3A%22Build+CLI%22)
[![google-java-styleguide](https://img.shields.io/badge/style-guide-orange.svg)](https://google.github.io/styleguide/javaguide.html)

A CLI application to utilize working with assignments during **Kovalevskyi Academy Java Coding Bootcamp**.
See [docs](https://straybro.github.io/KovalevskyiAcademyTooling/) to learn more.

**NOTE: Talos has been only tested on Linux.**

## Requirements
Command line testing and submission requires Maven to be in your system's PATH environment variable.

## Installation
For both compilation from source and execution `OpenJDK` or any valid JDK is required. Apache Maven >= 3.5 is also required for building from the source.

You can clone the repository and execute `mvn clean package --projects :cli` in the root directory. Then `talos` binary executable will be created in the `target` directory.
An instance of `talos` is also copied in `$HOME/.local/bin/` directory. The `$HOME/.local/bin/` can be appended to the `PATH`.

## Usage
Note: for most of the commands, `-V` enables verbose and `--working-dir=<workingDirPath>` changes the current working dir.

- `talos config [<key>] [<value>]` - sets config value by provided key.
- `talos self-update` - updates itself to the latest stable version.
- `talos diagnose` - diagnoses the system to identify common errors.
- `talos fetch <assignment>` - fetches assignment files by the given name (for example w0d1) to the current working directory. Each assignment may consist of one or several problems.
- `talos build` - compiles an assignment in the current working dir and builds a jar.
- `talos sanity` - runs a number of sanity checks (coding styles and formatting, code smelling, restricted functionality, etc) to help catch pitfalls early.
- `talos test` - tests an assignment in the current working dir.
- `talos submit` - submits already implemented and tested solution of assignment problems.

## Assignment work flow
- Download the CLI jar.
- Head on over to you personal account on Kovalevskyi Academy website to get your personal access tokens.
- Config CLI with your personal access token.
- Fetch new assignment.
- Implement a solution of assignment problems.
- Build it locally.
- Test it locally.
- Submit a solution.
