package com.diouf.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix="com.diouf.web")
public class CustumProperties {
	String apiUrl;

}
