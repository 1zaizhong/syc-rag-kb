package com.syc.ragkb.config;


import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午2:14
 * @description Minio 配置类
 **/
@Configuration
@Slf4j
public class MinioConfig {
    @Value("${minio.endpoint}")
    private  String endpoint;

    @Value("${minio.access-key:}")
    private  String accessKey;

    @Value("${minio.secret-key}")
    private  String secretKey;

    @Bean
    public MinioClient minioClient() {
        log.info("Minio 配置初始化 ,endpoint ={}",endpoint);
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
