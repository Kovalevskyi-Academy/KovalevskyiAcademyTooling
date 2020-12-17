package com.kovalevskyi.academy.codingbootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

@Command(name = "config",
    description = "Sets config options.")
public class ConfigCommand implements Callable<Integer> {
  @Parameters(paramLabel = "<setting-key>",
      index = "0", arity = "0..1",
      description="Setting key")
  private String key;

  @Parameters(paramLabel = "<setting-value>",
      index = "1", arity = "0..1",
      description="Setting value")
  private String value;

  @Option(names = {"-l", "--list"},
      description = "List all.",
      defaultValue = "false")
  private boolean list;

  @Option(names = {"-e", "--edit"},
      description = "Open editor.",
      defaultValue = "false")
  private boolean editor;

  @Option(names = {"--unset"},
      description = "Unset the given setting-key.",
      defaultValue = "false")
  private boolean unset;

  @Override
  public Integer call() throws Exception {
    if(key == null && !list && !editor) {
      new CommandLine(this).usage(System.out);
    }

    return CommandLine.ExitCode.OK;
  }
}
