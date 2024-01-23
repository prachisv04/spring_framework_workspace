package com.example.events;

import org.springframework.context.ApplicationEvent;

public class BlockedListEvent extends ApplicationEvent{

	private String address;
	private String content;
	
	public BlockedListEvent(Object source , String address , String content) {
		super(source);
		this.address = address;
		this.content = content;
		System.out.println(address+" "+content);
	}

}
