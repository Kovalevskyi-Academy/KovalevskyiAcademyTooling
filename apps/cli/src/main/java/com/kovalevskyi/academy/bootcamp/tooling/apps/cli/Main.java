package com.kovalevskyi.academy.bootcamp.tooling.apps.cli;

import com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands.LauncherCommand;

public class Main {
  public static void main(String... args) {
    LauncherCommand.start(args);
  }
}
