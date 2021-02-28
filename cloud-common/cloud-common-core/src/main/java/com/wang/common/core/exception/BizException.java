package com.wang.common.core.exception;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * 自定义业务异常
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Getter
public class BizException extends RuntimeException {

    private final BizBaseCode bizBaseCode;

    private final Object[] params;

    private Throwable cause;

    public BizException(BizBaseCode bizBaseCode, Object ... params) {
        super(StrUtil.format(bizBaseCode.getMsg(), params));
        this.bizBaseCode = bizBaseCode;
        this.params = params;
    }

    public BizException(BizBaseCode bizBaseCode, Throwable cause, Object ... params) {
        super(StrUtil.format(bizBaseCode.getMsg(), params), cause);
        this.bizBaseCode = bizBaseCode;
        this.params = params;
        this.cause = cause;
    }

    public static BizException ex(BizBaseCode bizBaseCode, Object ... params) {
        return new BizException(bizBaseCode, params);
    }

    public static BizException ex(BizBaseCode bizBaseCode, Throwable cause, Object ... params) {
        return new BizException(bizBaseCode, cause, params);
    }

}
