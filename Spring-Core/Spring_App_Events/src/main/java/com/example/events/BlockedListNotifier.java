package com.example.events;

import org.springframework.context.ApplicationListener;

public class BlockedListNotifier implements ApplicationListener<BlockedListEvent>{

	private String notificationAddress;
	
	public String getNotificationAddress() {
		return notificationAddress;
	}

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	@Override
	public void onApplicationEvent(BlockedListEvent event) {
		
		
		
	}

}
