package org.jesperancinha.smtd.planets.configuration;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class PlanetFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolerizerComposer.outSpace()
                .none()
                .blue("called:")
                .cyan("PlanetFactoryPostProcessor#postProcessBeanFactory")
                .green("BeanFactoryPostProcessor")
                .newLine()
                .reset();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
