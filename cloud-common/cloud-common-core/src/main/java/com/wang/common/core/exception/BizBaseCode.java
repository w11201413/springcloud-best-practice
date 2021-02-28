package com.wang.common.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统级异常信息
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Getter
@AllArgsConstructor
public enum BizBaseCode implements BizCodeInterface{

    SYSTEM_FAILED(-1, "未知异常"),
    SYSTEM_VALID_FAILED(10001, "校验：参数{}设置异常, {}"),
    SYSTEM_DATA_NOT_FOUND(10002, "数据不存在");

    /**
     * 异常码
     */
    private final Integer code;

    /**
     * 异常描述, 可以使用{}作为占位符, 参数通过BizException补入
     */
    private final String msg;

}
