package com.wang.common.core.result;

import cn.hutool.core.util.StrUtil;
import com.wang.common.core.exception.BizCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 统一结果封装
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class R<T> {

    private Integer code;

    private String msg;

    private T data;

    public R(Integer code, String msg) {
        this(code, msg, null);
    }

    public static<T> R<T> success(T data) {
        return new R<>(0, "success", data);
    }

    public static<T> R<T> failed(BizCodeInterface bizCode, Object ... params) {
        return new R<>(bizCode.getCode(), StrUtil.format(bizCode.getMsg(), params));
    }
}
