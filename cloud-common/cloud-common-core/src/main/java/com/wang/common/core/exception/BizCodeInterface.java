package com.wang.common.core.exception;

/**
 * 业务异常基本接口
 * 系统级异常: -1 未知异常
 * 基本格式: 100000
 * 首位: 1表示系统级异常编号; 2及以上表示其它服务编号
 * 次位: 由各服务自定，表示功能模块编号
 * 后三位: 表示具体异常码
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
public interface BizCodeInterface {

    /**
     * 异常码
     * @return Integer 异常码
     */
    Integer getCode();

    /**
     * 异常描述
     * @return String 异常信息
     */
    String getMsg();

}
