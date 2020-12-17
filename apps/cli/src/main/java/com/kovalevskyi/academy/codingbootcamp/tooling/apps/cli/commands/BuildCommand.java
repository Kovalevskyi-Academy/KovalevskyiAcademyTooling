package com.kovalevskyi.academy.codingbootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;

@Command(name = "build",
    description = "Compiles the entire project and builds a jar.")
public class BuildCommand implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    return null;
  }
}
