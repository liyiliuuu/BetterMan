package com.amos.designpatterns.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
public abstract class EmployeeHandler {
    public static final int MANAGER_LEVEL_REQUEST = 1;
    public static final int DEPUTY_MANAGER_LEVEL_REQUEST = 2;
    public static final int PROJECT_MANAGER_LEVEL_REQUEST = 3;
    public static final int PROJECT_MEMBER_LEVEL_REQUEST = 4;
    public static final int DEPARTMENT_MEMBER_LEVEL_REQUEST = 5;

    //能处理的级别
    private int level = 0;

    private EmployeeHandler nextHandler;

    public EmployeeHandler(int level) {
        this.level = level;
    }

    public final void HandlerMessage(CandidateRequest request) {

        if (request.getLevel() == this.level) {
            this.extractCandidates(request);

        } else {
            if (this.nextHandler != null) {
                this.nextHandler.HandlerMessage(request);
            } else {
                log.error("员工：" + request.getUserSerial() + "找不到对应的职级，请检查数据");
            }
        }
    }

    //设置下一个处理者是谁
    public void setNext(EmployeeHandler handler) {
        this.nextHandler = handler;
    }

    protected abstract void extractCandidates(CandidateRequest request);

}
