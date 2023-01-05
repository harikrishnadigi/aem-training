package com.adobe.aem.guides.core.models;

import com.day.cq.commons.Externalizer;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String linkPath;

    @ValueMapValue
    private String target;

    @ValueMapValue
    private Boolean external;

    @SlingObject
    private ResourceResolver resourceResolver;

    @OSGiService
    private Externalizer externalizer;

    @PostConstruct
    protected void init() {
        if(Objects.nonNull(resourceResolver) && Objects.nonNull(externalizer)) {
            linkPath = externalizer.authorLink(resourceResolver, linkPath);
        }
    }

    public String getLabel() {
        return label;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public String getTarget() {
        return target;
    }

    public Boolean getExternal() {
        return external;
    }
}
