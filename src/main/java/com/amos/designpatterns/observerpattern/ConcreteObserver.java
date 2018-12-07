package com.amos.designpatterns.observerpattern;

import java.util.Observable;
import java.util.Observer;

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

public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察到目标活动..." + arg.toString());
    }
}
