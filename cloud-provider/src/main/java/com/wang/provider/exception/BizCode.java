package com.wang.provider.exception;

import com.wang.common.core.exception.BizCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务异常
 * 服务码: 2
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Getter
@AllArgsConstructor
public class BizCode implements BizCodeInterface {



    /**
     * 异常码
     */
    private final Integer code;

    /**
     * 异常描述, 可以使用{}作为占位符, 参数通过BizException补入
     */
    private final String msg;

}
