package com.feature.email.conf;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class TaskConfig {

    private static int defaultCorePoolSize = 5;

    /**
     * TODO 定时任务
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void execTaskJob() {
        //TODO  每天定时查询数据库，看有没有当天的邮件，
        // 如果有，发送邮件告知收件人，并添加到发件列表中
        // 状态为未发送，如果是邮箱则为已发送
    }
}
