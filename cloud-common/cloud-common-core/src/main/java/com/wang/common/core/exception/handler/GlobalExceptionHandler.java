package com.wang.common.core.exception.handler;

import com.wang.common.core.exception.BizBaseCode;
import com.wang.common.core.exception.BizException;
import com.wang.common.core.exception.DataNotFoundException;
import com.wang.common.core.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验异常拦截
     * @param request 请求
     * @param exception 异常
     * @return 校验结果封装
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R exceptionHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream().findFirst().map(error ->
                R.failed(BizBaseCode.SYSTEM_VALID_FAILED, error.getField(), error.getDefaultMessage())
        ).orElse(R.success(null));
    }

    /**
     * 业务异常拦截
     * @param request 请求
     * @param exception 异常
     * @return 业务异常结果封装
     */
    @ExceptionHandler(value= BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exceptionHandler(HttpServletRequest request, BizException exception) {
        log.error("系统发生业务异常", exception.getCause());
        return R.failed(exception.getBizBaseCode(), exception.getParams());
    }

    /**
     * 数据未找到异常拦截
     * @param request 请求
     * @param exception 异常
     * @return 异常结果封装
     */
    @ExceptionHandler(value= DataNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exceptionHandler(HttpServletRequest request, DataNotFoundException exception) {
        log.error("数据未找到", exception.getCause());
        return R.failed(BizBaseCode.SYSTEM_DATA_NOT_FOUND);
    }

    /**
     * Exception异常拦截(最后防线)
     * @param request 请求
     * @param exception 异常
     * @return 未知异常结果封装
     */
    @ExceptionHandler(value= Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error("系统发生未知异常", exception);
        return R.failed(BizBaseCode.SYSTEM_FAILED);
    }

}
