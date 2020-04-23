package com.river.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "river")
public class RiverAppProperties {
    private String email;
    private String googleAnalyticsId;
    private List<String> authors;
    private Map<String, String> exampleMap;

    public RiverAppProperties() {
    }

    public RiverAppProperties(String email, String googleAnalyticsId) {
        this.email = email;
        this.googleAnalyticsId = googleAnalyticsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleAnalyticsId() {
        return googleAnalyticsId;
    }

    public void setGoogleAnalyticsId(String googleAnalyticsId) {
        this.googleAnalyticsId = googleAnalyticsId;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Map<String, String> getExampleMap() {
        return exampleMap;
    }

    public void setExampleMap(Map<String, String> exampleMap) {
        this.exampleMap = exampleMap;
    }
}
