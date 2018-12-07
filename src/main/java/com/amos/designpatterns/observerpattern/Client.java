package com.amos.designpatterns.observerpattern;

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
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver();
        concreteSubject.addObserver(concreteObserver);
        concreteSubject.haveLunch();
        concreteSubject.sleeping();
    }

}
