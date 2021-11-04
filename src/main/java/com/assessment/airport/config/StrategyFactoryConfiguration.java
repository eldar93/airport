package com.assessment.airport.config;

import com.assessment.airport.strategy.SelectionStrategyFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyFactoryConfiguration {

    @Autowired
    private BeanFactory beanFactory;

    public ServiceLocatorFactoryBean myFactoryLocator() {
        final ServiceLocatorFactoryBean locator = new ServiceLocatorFactoryBean();
        locator.setServiceLocatorInterface(SelectionStrategyFactory.class);
        locator.setBeanFactory(beanFactory);
        return locator;
    }

    @Bean
    public SelectionStrategyFactory strategyFactory() {
        final ServiceLocatorFactoryBean locator = myFactoryLocator();
        locator.afterPropertiesSet();
        return (SelectionStrategyFactory) locator.getObject();
    }
}
