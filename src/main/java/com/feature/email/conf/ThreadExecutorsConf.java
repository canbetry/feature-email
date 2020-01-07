package com.feature.email.conf;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * 线程池配置
 *
 * @description: ThreadExecutorsConf <br>
 * @date: 2020/1/7 11:04 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Configuration
@Log4j2
public class ThreadExecutorsConf {
    /**
     * 核心线程数（默认线程数）
     */
    private static final int corePoolSize = 10;
    /**
     * 最大线程数
     */
    private static final int maxPoolSize = 50;
    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    private static final int keepAliveTime = 100;
    /**
     * 缓冲队列数
     */
    private static final int queueCapacity = 1000;
    /**
     * 线程池名前缀
     */
    private static final String threadNamePrefix = "Executors-Thread-";

    /**
     * 方式一
     *
     * @return
     */
    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    /**
     * 方式二
     *
     * @return
     */
//    @Bean("executorsService")
//    public ExecutorService executorHandle() {
    //四种类型的线程池
    //缓存线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    //单个线程池
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    //固定大小的线程池
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    //延迟或定时的执行任务
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        return cachedThreadPool;
//    }
}
