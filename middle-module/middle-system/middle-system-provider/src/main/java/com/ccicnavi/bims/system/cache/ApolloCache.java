package com.ccicnavi.bims.system.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties(prefix = "dubbo.application")
public class ApolloCache {

    private String name;

    @Value("${dubbo.registry.register}")
    public void setName(String name) {
        this.name = name;
    }
}
