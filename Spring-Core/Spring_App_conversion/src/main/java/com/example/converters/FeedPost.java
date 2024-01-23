package com.example.converters;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component("post")
public class FeedPost {

	private static int id;
	private String data;
	private int likes;
	private String[] comments;
	private String caption;
	
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
	public FeedPost(String data, int likes, String[] comments, String caption) {
		super();
		setId(getId() + 1);
		this.data = data;
		this.likes = likes;
		this.comments = comments;
		this.caption = caption;
	}
	FeedPost(){
		setId(getId() + 1);
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		FeedPost.id = id;
	}
	public String[] getComments() {
		return comments;
	}
	public void setComments(String[] comments) {
		this.comments = comments;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String toString() {
		
		return "FeedPost {\n\tid="+id+",\n\tdata=" + data + ",\n\tlikes=" + likes + ",\n\tcomments={"+ Arrays.toString(comments) + "},\n\tcaption="
				+ caption + "\n}";
	}
	
	
	
}

