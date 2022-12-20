package com.ss871104.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("limits-service")
public class Configuration {
	
	private int minimum;
	private int maximum;

}
