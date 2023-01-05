package com.adobe.aem.guides.core.services;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Service Demo Example")
public @interface ServiceDemoConfigurations {

    @AttributeDefinition
    String courseName() default "AEM Training";

    @AttributeDefinition
    String courseDuration() default "1 month";

    @AttributeDefinition
    String courseContent() default "";
}
