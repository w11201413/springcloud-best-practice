package com.wang.common.core.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描自动装配
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Configuration
@ComponentScan({"com.wang.common.exception.handler"})
public class ScanAutoConfiguration {
}
