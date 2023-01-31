package com.demo.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AbstractMessageListener implements HandlerMessageListener {

    @Override
    public void onMessage(String message) {
        // TODO 这里可以加个策略模式，通过topic来判断是哪个topic的消息，然后做相应的处理
        log.info("topic: {}, message: {}", topic().getTopic(), message);
    }


}
