package com.wang.provider.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangdong [w11201413@163.com]
 * @date 2021/2/14
 */
@Data
@ConfigurationProperties(prefix = "wang")
public class TestProperties {

    private String countNum;

}
