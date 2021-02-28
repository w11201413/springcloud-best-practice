package com.wang.provider.service;

import com.wang.provider.pojo.entity.Product;

import java.util.List;

/**
 * 产品业务处理
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
public interface ProductService {

    /**
     * 查询所有
     * @return List<Product> 所有产品
     */
    List<Product> findAll();

}
