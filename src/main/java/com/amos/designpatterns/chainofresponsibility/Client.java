package com.amos.designpatterns.chainofresponsibility;

/**
 * Licensed to CMDT,Inc. under the terms of the CMDT
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date           Author               Version        Comments
 * 2018/12/7        Li Yiliu                1.0          Initial Version
 *
 * <p>
 */
public class Client {

    public void getCandidateListChain(User user, int level) {
        CandidateRequest request = new CandidateRequest();
        request.setLevel(level);
        request.setUserSerial(user.getSerial());
        request.setDepartmentSerial(user.getDepartmentSerial());

        //生成责任链
        DepartmentManagerHandler departmentManagerHandler = new DepartmentManagerHandler(EmployeeHandler.MANAGER_LEVEL_REQUEST);
        DepartmentDeputyManagerHandler departmentDeputyManagerHandler = new DepartmentDeputyManagerHandler(EmployeeHandler.DEPUTY_MANAGER_LEVEL_REQUEST);
        ProjectManagerHandler projectManagerHandler = new ProjectManagerHandler(EmployeeHandler.PROJECT_MANAGER_LEVEL_REQUEST);
        ProjectMemberHandler projectMemberHandler = new ProjectMemberHandler(EmployeeHandler.PROJECT_MEMBER_LEVEL_REQUEST);
        DepartmentMemberHandler departmentMemberHandler = new DepartmentMemberHandler(EmployeeHandler.DEPARTMENT_MEMBER_LEVEL_REQUEST);
        departmentManagerHandler.setNext(departmentDeputyManagerHandler);
        departmentDeputyManagerHandler.setNext(projectManagerHandler);
        projectManagerHandler.setNext(projectMemberHandler);
        projectMemberHandler.setNext(departmentMemberHandler);

        departmentManagerHandler.HandlerMessage(request);

    }
}
