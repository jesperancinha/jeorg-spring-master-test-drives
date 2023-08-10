package org.jesperancinha.smtd.planets.dto;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Builder;
import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

@Data
public class Planet implements
        ApplicationContextAware,
        BeanNameAware,
        BeanFactoryAware,
        InitializingBean,
        DisposableBean,
        ApplicationEventPublisherAware,
        BeanClassLoaderAware,
        LoadTimeWeaverAware,
        MessageSourceAware,
        NotificationPublisherAware,
        ResourceLoaderAware {
    String name;

    String scientificName;

    Double area;

    String message;

    public Planet() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet constructor")
                .newLine()
                .reset();
    }

    @Builder
    public Planet(String name, String scientificName, Double area) {
        this();
        this.name = name;
        this.scientificName = scientificName;
        this.area = area;
    }

    @PostConstruct
    public void postConstruct() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet#postConstruct")
                .newLine()
                .reset();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("BeanFactoryAware#setBeanFactory")
                .newLine()
                .reset();
    }

    @Override
    public void setBeanName(String beanName) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("BeanNameAware#setBeanName")
                .newLine()
                .reset();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("ApplicationContextAware#setApplicationContext")
                .newLine()
                .reset();
    }

    @Override
    public void destroy() throws Exception {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("DisposableBean#destroy")
                .newLine()
                .reset();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("InitializingBean#afterPropertiesSet")
                .newLine()
                .reset();
    }

    @PreDestroy
    public void preDestroy() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet#preDestroy")
                .newLine()
                .reset();
    }

    private void initMethod() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet#initMethod")
                .newLine()
                .reset();
    }

    private void destroyMethod() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet#destroyMethod")
                .newLine()
                .reset();

    }

    @Autowired
    public void setSomething() {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("Planet#setSomething")
                .newLine()
                .reset();
        this.message = "something";
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("ApplicationEventPublisherAware#setApplicationEventPublisher")
                .newLine()
                .reset();
        this.message = "something";
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("BeanClassLoaderAware#setBeanClassLoader")
                .newLine()
                .reset();
        this.message = "something";

    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("LoadTimeWeaverAware#setLoadTimeWeaver")
                .newLine()
                .reset();
        this.message = "something";
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("MessageSourceAware#setMessageSource")
                .newLine()
                .reset();
        this.message = "something";
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("ResourceLoaderAware#setResourceLoader")
                .newLine()
                .reset();
        this.message = "something";
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        ConsolerizerComposer.outSpace()
                .none()
                .magenta("Planet")
                .blue("called:")
                .cyan("NotificationPublisherAware#setNotificationPublisher")
                .newLine()
                .reset();
        this.message = "something";
    }
}
