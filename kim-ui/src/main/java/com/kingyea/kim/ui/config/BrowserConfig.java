package com.kingyea.kim.ui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "browser")
@PropertySource("classpath:/application.yaml")
public class BrowserConfig {
    private Map<String,String> webUrlMap = new HashMap<>();

    public Map<String, String> getWebUrlMap() {
        return webUrlMap;
    }

    public void setWebUrlMap(Map<String, String> mapProps) {
        this.webUrlMap = mapProps;
    }

    @Override
    public String toString() {
        return "BrowserConfig{" +
                "webUrlMap=" + webUrlMap +
                '}';
    }
}
