package com.wang.provider.service.impl;

import com.wang.provider.pojo.entity.Product;
import com.wang.provider.repository.ProductRepository;
import com.wang.provider.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 产品业务实现
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
