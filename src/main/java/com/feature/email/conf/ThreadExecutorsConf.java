package com.feature.email.conf;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@Log4j2
public class ThreadExecutorsConf {
    private static final int corePoolSize = 10;     // 核心线程数（默认线程数）
    private static final int maxPoolSize = 50;      // 最大线程数
    private static final int keepAliveTime = 100;   // 允许线程空闲时间（单位：默认为秒）
    private static final int queueCapacity = 1000;  // 缓冲队列数
    private static final String threadNamePrefix = "Executors-Thread-"; // 线程池名前缀

//
//    @Bean("threadPoolTaskExecutor")
//    public ThreadPoolTaskExecutor executor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(corePoolSize);
//        executor.setKeepAliveSeconds(keepAliveTime);
//        executor.setMaxPoolSize(maxPoolSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setThreadNamePrefix(threadNamePrefix);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); //设置拒绝策略
//        return executor;
//    }

    //第二种创建线程池
    @Bean("executorsService")
    public ExecutorService executorHandle() {
        //四种类型的线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();             //缓存线程池
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();     //单个线程池
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);     //固定大小的线程池
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  //延迟或定时的执行任务
        return cachedThreadPool;
    }
}
