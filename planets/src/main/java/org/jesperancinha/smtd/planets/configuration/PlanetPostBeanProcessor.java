package org.jesperancinha.smtd.planets.configuration;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PlanetPostBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("planet".equals(beanName)) {
            ConsolerizerComposer.outSpace()
                    .none()
                    .blue("called:")
                    .cyan("PlanetPostBeanProcessor#postProcessBeforeInitialization")
                    .green("BeanPostProcessor")
                    .newLine()
                    .reset();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if ("planet".equals(beanName)) {
            ConsolerizerComposer.outSpace()
                    .none()
                    .blue("called:")
                    .cyan("PlanetPostBeanProcessor#postProcessAfterInitialization")
                    .green("BeanPostProcessor")
                    .newLine()
                    .reset();
        }
        return bean;
    }

}
