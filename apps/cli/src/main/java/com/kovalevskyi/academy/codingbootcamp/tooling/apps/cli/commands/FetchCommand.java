package com.kovalevskyi.academy.codingbootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "fetch",
    description="Fetches an assignment with a given name.")
public class FetchCommand implements Callable<Integer> {
  @Parameters(paramLabel = "<assignment>",
      arity = "0..1",
      description = "The assignment name.")
  private String assignment;

  @Option(names = {"-l", "--list"},
      description = "List all available assignments to fetch.",
      defaultValue = "false")
  private boolean list;

  @Option(names = {"-f", "--force"},
      description = "Fetch assignment even if it has already been fetched and overwrite files "
          + "that already exist. Use this only if you really know what you are doing.",
      defaultValue = "false")
  private boolean force;

  @Override
  public Integer call() throws Exception {
    if(assignment == null && !list) {
      new CommandLine(this).usage(System.out);
    }


    return CommandLine.ExitCode.OK;
  }
}
