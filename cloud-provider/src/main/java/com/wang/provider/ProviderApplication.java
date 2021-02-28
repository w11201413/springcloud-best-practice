package com.wang.provider;

import com.wang.provider.properties.TestProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 主启动类
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@EnableConfigurationProperties(value = TestProperties.class)
@SpringBootApplication
public class ProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
