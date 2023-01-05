package com.adobe.aem.guides.core.models;

import com.adobe.aem.guides.core.services.ServiceDemo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceExampleModel {

    @ValueMapValue
    private String myTitle;

    @OSGiService
    private ServiceDemo serviceDemo;

    public String getMyTitle() {
        return myTitle;
    }

    public ServiceDemo getServiceDemo() {
        return serviceDemo;
    }
}
