package com.wang.provider.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 产品实体类
 * @author wangdong [w11201413@163.com]
 * @date 2021/02/11
 */
@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
@Where(clause = "del_flg = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 产品名 */
    private String name;

    /** 产品数量 */
    private Integer amount;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "del_flg")
    private Boolean delFlg;
}
