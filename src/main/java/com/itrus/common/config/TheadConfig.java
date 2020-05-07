package com.itrus.common.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
@EnableAsync
public class TheadConfig {

	/**
	 *核心线程数 --线程池基本大小
	 */
	@Value("${taskExecutor.coreSize:10}")
	private Integer coreSize;
	
	/**
	 *最大线程数
	 */
	@Value("${taskExecutor.maxSize:10}")
	private Integer maxSize;
	
	/**
	 *线程队列容量
	 */
	@Value("${taskExecutor.queueCapacity:10}")
	private Integer queueCapacity;
	
	/**
	 *线程活跃时间
	 */
	@Value("${taskExecutor.keepAliveSeconds:3000}")
	private Integer keepAliveSeconds;
	
	/**
	 *线程名称
	 */
	@Value("${taskExecutor.threadName:task-concurrent-work}")
	private String threadName;
	
	/**
	 *线程活跃时间
	 */
	@Value("${taskExecutor.waitForJobsToCompleteOnShutdown:true}")
	private Boolean waitForJobsToCompleteOnShutdown;
	
	@Bean("taskExecutor")
	public TaskExecutor getTaskExecutor() {
		
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(coreSize);
		taskExecutor.setMaxPoolSize(maxSize);
		taskExecutor.setQueueCapacity(queueCapacity);
		taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
		taskExecutor.setThreadNamePrefix(threadName);
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
		taskExecutor.initialize();
		return taskExecutor;
	}

}