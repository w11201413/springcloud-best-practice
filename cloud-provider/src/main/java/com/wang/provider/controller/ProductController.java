package com.wang.provider.controller;

import com.wang.common.core.result.R;
import com.wang.provider.properties.TestProperties;
import com.wang.provider.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final TestProperties testProperties;

    @GetMapping
    public R findAll() {
        return R.success(productService.findAll());
    }

}
