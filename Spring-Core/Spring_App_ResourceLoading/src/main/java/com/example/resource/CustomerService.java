package com.example.resource;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component(value="cust")
public class CustomerService implements ResourceLoaderAware {

	ResourceLoader resourceLoader;
	
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		
		this.resourceLoader = resourceLoader;
		
	}
	
	public Resource getResource(String location){
		return resourceLoader.getResource(location);
	}
	

}
