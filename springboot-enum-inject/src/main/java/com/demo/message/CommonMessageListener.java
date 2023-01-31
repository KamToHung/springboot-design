package com.demo.message;


import com.demo.enums.EnumTopic;

public class CommonMessageListener extends AbstractMessageListener {

    private final EnumTopic topic;

    public CommonMessageListener(EnumTopic topic) {
        this.topic = topic;
    }

    @Override
    public EnumTopic topic() {
        return this.topic;
    }

}

