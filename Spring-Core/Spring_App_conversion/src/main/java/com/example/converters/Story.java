package com.example.converters;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component("story")
public class Story {
	
	private static int id;
	private String data;
	private int likes;
	private String[] reply;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String[] getReply() {
		return reply;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Story.id = id;
	}
	public void setReply(String[] reply) {
		this.reply = reply;
	}
	public Story( String data, int likes, String[] reply) {
		super();
		setId(getId() + 1);
		this.data = data;
		this.likes = likes;
		this.reply = reply;
	}
	
	Story(){
		setId(getId() + 1);
	}
	@Override
	public String toString() {
		return "Story {\n\tid=" + id + ",\n\tdata=" + data + ",\n\tlikes=" + likes + ",\n\treply=" + Arrays.toString(reply) + "\n}";
	}
	
	

}
