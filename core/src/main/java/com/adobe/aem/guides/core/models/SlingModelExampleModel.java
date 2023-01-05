package com.adobe.aem.guides.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlingModelExampleModel {

    @ValueMapValue
    private String mainLabel;

    @ValueMapValue(name = "sling:resourceType")
    private String resourceType;

    @ChildResource
    private List<LinkModel> links = new ArrayList<>();

    @ScriptVariable
    private Page currentPage;

    public String getMainLabel() {
        return mainLabel;
    }

    public String getResourceType() {
        return resourceType;
    }

    public List<LinkModel> getLinks() {
        return links;
    }

    public String getCurrentPageTitle() {
        return Objects.nonNull(currentPage) ? currentPage.getPageTitle() : StringUtils.EMPTY;
    }
}
