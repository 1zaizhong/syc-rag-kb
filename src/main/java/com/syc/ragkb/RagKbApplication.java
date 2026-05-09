package com.syc.ragkb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/28 下午6:26
 * @description
 **/
@SpringBootApplication
@EnableAsync        // 开启异步，支持索引任务异步执行
@EnableRetry        // 开启重试，支持 Embedding 调用失败重试
public class RagKbApplication {
    public static void main(String[] args) {
        SpringApplication.run(RagKbApplication.class, args);
    }
}
