package com.amos.designpatterns.observerpattern;
import java.util.Observable;

/**
 * * Licensed to CMDT,Inc. under the terms of the CMDT
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date           Author               Version        Comments
 * 2018/12/7        Li Yiliu                1.0          Initial Version
 *
 * <p>
 *
 */

public class ConcreteSubject extends Observable implements Subject {

    @Override
    public void haveLunch() {
        System.out.println("我要吃午饭了");
        super.setChanged();
        super.notifyObservers("报告吃饭");
    }

    @Override
    public void sleeping() {
        System.out.println("我要睡觉了");
        super.setChanged();
        this.notifyObservers("报告睡觉");
    }
}
