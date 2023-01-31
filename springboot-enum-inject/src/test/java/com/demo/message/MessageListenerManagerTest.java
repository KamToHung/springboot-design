package com.demo.message;

import com.demo.enums.EnumTopic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MessageListenerManagerTest {

    @Test
    void getMessageListener() {
        HandlerMessageListener messageListener = MessageListenerManager.getMessageListener(EnumTopic.USER);
        assertEquals("user-topic", messageListener.topic().getTopic());
    }

}