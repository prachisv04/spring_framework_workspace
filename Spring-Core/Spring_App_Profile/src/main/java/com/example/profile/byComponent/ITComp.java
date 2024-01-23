package com.example.profile.byComponent;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("it")
@Profile("it")
@Scope("prototype")
public class ITComp {

	ITComp(){
		System.out.println("IT BEAN");
	}
	
}
