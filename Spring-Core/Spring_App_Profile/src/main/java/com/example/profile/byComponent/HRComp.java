package com.example.profile.byComponent;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hr")
public class HRComp {

	HRComp(){
		System.out.println("HR BEAN");
	}
	
}
