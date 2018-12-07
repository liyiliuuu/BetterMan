package com.amos.designpatterns.chainofresponsibility;

/**
 * * Licensed to CMDT,Inc. under the terms of the CMDT
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date           Author               Version        Comments
 * 2018/12/6        Li Yiliu                1.0          Initial Version
 */

import lombok.Data;

/**
 * 待考核人请求类
 */
@Data
public class CandidateRequest {

    private int level;

    private String userSerial;

    private String departmentSerial;

}
