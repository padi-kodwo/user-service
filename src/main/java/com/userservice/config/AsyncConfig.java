package com.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);
  private final String SESSION_ID = AsyncConfig.class.getName().toUpperCase();

  @Override
  public Executor getAsyncExecutor() {
    logger.info("[" + SESSION_ID + "] about to get async executor.");

    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setMaxPoolSize(20);
    threadPoolTaskExecutor.setCorePoolSize(5);
    threadPoolTaskExecutor.setQueueCapacity(2000);
    threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
    threadPoolTaskExecutor.setThreadNamePrefix("Analytics-Service-");
    threadPoolTaskExecutor.initialize();

    logger.info("[" + SESSION_ID + "] done setting up async.");

    return threadPoolTaskExecutor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }
}
