package com.kovalevskyi.academy.bootcamp.tooling.apps.cli.commands;

import java.util.concurrent.Callable;
import me.tongfei.progressbar.DelegatingProgressBarConsumer;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;

@Command(name = "build",
    description = "Compiles an assignment in the current working dir and builds a jar.")
public class BuildCommand implements Callable<Integer> {
  Logger logger = LoggerFactory.getLogger(BuildCommand.class);

  @Override
  public Integer call() {
    logger.info("Compiling library project.");
    ProgressBar progressBar = createProgressBarBuilder("Compiling library project").setInitialMax(1).build();

    progressBar.step();

    return CommandLine.ExitCode.OK;
  }


  /**
   * Creates a progress bar builder with the default settings for progress bars in the mining pipeline set.
   *
   * @param taskName the name of the progress bar
   */
  private ProgressBarBuilder createProgressBarBuilder(String taskName) {
    return new ProgressBarBuilder()
      .setTaskName(taskName)
      .setStyle(ProgressBarStyle.ASCII)
      .setConsumer(new DelegatingProgressBarConsumer(System.out::println));
  }
}
