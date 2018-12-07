package com.amos.designpatterns.chainofresponsibility;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * * Licensed to CMDT,Inc. under the terms of the CMDT
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date           Author               Version        Comments
 * 2018/7/3       zhengjun.jing                 1.0            Initial Version
 */
@Data
@NoArgsConstructor
public class User  {

    private long id;

    private String serial;

    private Date createTime;

    private String createBy;

    private Date modifyTime;

    private String modifyBy;

    private int isDelete;

    private String name;

    private String phone;

    private String employeeId;

    private String identityCard;

    private String departmentSerial;

    private String position;

    private String location;

    private int isAdmin;

    private String password;

    private String isTemporaryPassword;

}
