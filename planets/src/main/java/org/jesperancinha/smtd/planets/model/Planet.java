package org.jesperancinha.smtd.planets.model;


import lombok.Builder;
import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class Planet implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
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
}
