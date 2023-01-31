package com.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * topic枚举
 */
@Getter
@AllArgsConstructor
public enum EnumTopic {

    USER("user-topic", "用户"),

    ORDER("order-topic", "订单"),

    GIFTS("gifts-topic", "礼物"),
    ;

    private final String topic;

    private final String desc;


}
