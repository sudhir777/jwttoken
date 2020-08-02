package com.javatechie.jwt.api.rest.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestClientConfig {
	public RestClientConfig(final RestTemplateBuilder builder,final ClientPropeties props)
	{
		
	}

}
