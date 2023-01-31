package com.demo.message;

import com.demo.enums.EnumTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@Component
public class MessageListenerPostProcessor implements BeanDefinitionRegistryPostProcessor, SmartInitializingSingleton {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        this.beanFactory = configurableListableBeanFactory;
    }


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("postProcessBeanDefinitionRegistry");
        for (EnumTopic topic : EnumTopic.values()) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CommonMessageListener.class);
            beanDefinitionBuilder.addConstructorArgValue(topic);
            registry.registerBeanDefinition(topic.getTopic() + "-listener", beanDefinitionBuilder.getRawBeanDefinition());
        }
    }

    @Override
    public void afterSingletonsInstantiated() {
        Map<EnumTopic, HandlerMessageListener> messageListenerMap = beanFactory.getBeanProvider(HandlerMessageListener.class).stream()
                .collect(Collectors.toMap(HandlerMessageListener::topic, Function.identity()));
        MessageListenerManager.putMessageListener(messageListenerMap);
        log.info("messageListenerMap: {}", messageListenerMap);
    }

}
