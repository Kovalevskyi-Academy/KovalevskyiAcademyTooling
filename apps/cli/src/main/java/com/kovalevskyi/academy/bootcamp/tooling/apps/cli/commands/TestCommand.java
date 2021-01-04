package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "test",
    description = "Runs tests.")
public class TestCommand implements Callable<Integer> {
  @Option(names = {"--list-suites"},
      description = "List available test suites.",
      defaultValue = "false")
  private boolean listTestSuites;

  @Option(names = {"--list-tests"},
      description = "List available tests.",
      defaultValue = "false")
  private boolean listTests;

  @Option(names = {"--no-stack-trace"},
      description = "Disable stack trace in test results output.",
      defaultValue = "true")
  private boolean noStackTrace;

  @Option(names = {"--only-failures"},
      description = "Run only tests that failed the last time they ran.",
      defaultValue = "false")
  private boolean onlyFailures;

  @Option(names = {"--fail-fast"},
      description = "Stop running tests on first failure.",
      defaultValue = "false")
  private boolean failFast;

  @Option(names = {"--next-failure"},
      description = "Repeatedly run a single failure at a time.",
      defaultValue = "false")
  private String nextFailure;

  @Option(names = {"-t", "--test"},
      description = "Run a specific test.")
  private String test;

  @Option(names = {"-ts", "--test-suite"},
      description = "Run a specific test suite.")
  private String testSuite;

  @Override
  public Integer call() {

    return CommandLine.ExitCode.OK;
  }
}
