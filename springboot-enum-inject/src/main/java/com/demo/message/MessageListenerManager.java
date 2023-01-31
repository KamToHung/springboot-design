package com.demo.message;


import com.demo.enums.EnumTopic;

import java.util.HashMap;
import java.util.Map;

public class MessageListenerManager {

    private static Map<EnumTopic, HandlerMessageListener> messageListenerMap;

    public static void putMessageListener(Map<EnumTopic, HandlerMessageListener> messageListenerMap) {
        if (MessageListenerManager.messageListenerMap == null) {
            MessageListenerManager.messageListenerMap = new HashMap<>();
        }
        MessageListenerManager.messageListenerMap.putAll(messageListenerMap);
    }

    public static HandlerMessageListener getMessageListener(EnumTopic topic) {
        return messageListenerMap.get(topic);
    }

}
