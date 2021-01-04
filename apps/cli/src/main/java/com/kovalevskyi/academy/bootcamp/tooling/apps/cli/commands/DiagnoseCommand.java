package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;

@Command(name = "diagnose",
    description = "Diagnoses the system to identify common errors.")
public class DiagnoseCommand implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    return null;
  }
}
