package com.demo.message;

import com.demo.enums.EnumTopic;


public interface HandlerMessageListener extends MessageListener{

    EnumTopic topic();

}
