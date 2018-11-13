package com.ccicnavi.bims.system.configuration;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApolloCache {

    private static final Logger logger = LoggerFactory.getLogger(ApolloCache.class);

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {
            logger.info("changedKey:{},changedValue:{}",changedKey,changeEvent.getChange(changedKey));
        }
    }
}
