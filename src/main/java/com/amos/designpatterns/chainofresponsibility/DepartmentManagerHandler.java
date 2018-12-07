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
public class DepartmentManagerHandler extends EmployeeHandler {

    public DepartmentManagerHandler(int level) {
        super(EmployeeHandler.MANAGER_LEVEL_REQUEST);
    }

    @Override
    protected void extractCandidates(CandidateRequest request) {

    }

}
