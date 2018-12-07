package com.amos.minimalism.finance.model;


import java.sql.Timestamp;

/**
 * 债务实体对象
 */
public class Debt {

    private Long id; //主键id

    private String creditor; //债权人

    private String debtType; //债务形式,分期0r 到期一次性还款

    private Timestamp startTime; //债务开始时间

    private Integer frequency; //还款频次

    private Integer totalAmount; // 债务总额

    private Integer paidAmount; // 已还款金额

    private Integer paidNumber; // 已还款期数

    private Integer remainingAmount; // 剩余待还金额

    private Integer reaminingNumber; // 剩余还款期数

    private Timestamp nextPaidTime; //下次还款日期



}
