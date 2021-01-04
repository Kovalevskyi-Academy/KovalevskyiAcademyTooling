package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

@Command(name = "submit",
    description = "Submits solutions.")
public class SubmitCommand implements Callable<Integer> {
  @Option(names = {"-l", "--list"},
      description = "List all your assignment submissions.",
      defaultValue = "false")
  private boolean list;

  @Override
  public Integer call() throws Exception {
    return null;
  }
}
