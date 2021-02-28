create table if not exists product
(
    id int auto_increment comment '主键'
    primary key,
    name varchar(255) not null comment '产品名',
    amount int default 0 not null comment '数量',
    create_user varchar(255) not null comment '创建人',
    create_time timestamp not null comment '创建时间',
    update_user varchar(255) null comment '更新人',
    update_time timestamp null comment '更新时间',
    del_flg tinyint(1) default 0 not null comment '逻辑删除'
);