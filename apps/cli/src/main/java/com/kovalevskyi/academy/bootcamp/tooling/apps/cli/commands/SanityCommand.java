package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;

@Command(name = "sanity",
    description = "Runs a number of sanity checks to help catch pitfalls early.")
public class SanityCommand implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    return null;
  }
}
