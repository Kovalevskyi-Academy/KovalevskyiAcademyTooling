# Project Pygmalion

[![Docs](https://github.com/Kovalevskyi-Academy/KovalevskyiAcademyTooling/workflows/Deploy%20documentation/badge.svg)](https://kovalevskyi-academy.github.io/KovalevskyiAcademyTooling/)
[![Build CI](https://github.com/Kovalevskyi-Academy/KovalevskyiAcademyTooling/workflows/Build%20Portal/badge.svg)](https://github.com/Kovalevskyi-Academy/KovalevskyiAcademyTooling/actions?query=workflow%3A%22Build+Portal%22)
[![google-java-styleguide](https://img.shields.io/badge/style-guide-orange.svg)](https://google.github.io/styleguide/javaguide.html)

A web application where students submit their implemented solution of assignment problems during **Kovalevskyi Academy Coding Bootcamp**.
See [docs](https://kovalevskyi-academy.github.io/KovalevskyiAcademyTooling/) to learn more.

## Installation
For both compilation from source and execution `OpenJDK` or any valid JDK is required. Apache Maven >= 3.5 is also required for building from the source.

You can clone the repository and execute `mvn clean package -am --projects :portal` in the root directory.
To start the webserver execute `java -jar "./portal-web/target/portal-web-1.0-SNAPSHOT.jar"` 

