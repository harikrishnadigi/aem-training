package com.adobe.aem.guides.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = ServiceDemo.class, immediate = true)
@Designate(ocd = ServiceDemoConfigurations.class)
public class ServiceDemoImpl implements ServiceDemo{


    private ServiceDemoConfigurations configurations;

    @Activate
    private void activate(ServiceDemoConfigurations config) {
        configurations = config;
    }

    @Override
    public String getCourseName() {
        return configurations.courseName();
    }

    @Override
    public String getCourseDuration() {
        return configurations.courseDuration();
    }

    @Override
    public String getCourseContent() {
        return configurations.courseContent();
    }
}
