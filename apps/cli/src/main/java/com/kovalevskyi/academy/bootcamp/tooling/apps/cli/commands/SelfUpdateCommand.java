package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "self-update",
    aliases = {"selfupdate"},
    description = "Updates Talos itself to the latest version.")
public class SelfUpdateCommand implements Callable<Integer> {
  @Option(names = {"-r", "--rollback"},
      description = "Rollback to the last version you had installed.",
      defaultValue = "false")
  private boolean rollback;

  @Option(names = {"--clean-backups"},
      description =  {"Delete old backups during an update.",
          "This makes the current version of Talos the only backup available after the update."},
      defaultValue = "false")
  private boolean cleanBackups;

  @Override
  public Integer call() throws Exception {
    return null;
  }
}
