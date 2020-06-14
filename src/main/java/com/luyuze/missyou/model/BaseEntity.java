package com.luyuze.missyou.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public abstract class BaseEntity {

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
