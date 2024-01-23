package com.example.converters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.GenericConversionService;


public class ConverterTests {

public  void main() {
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	GenericConversionService service = new GenericConversionService();
	service.addConverterFactory(new PostToStoryFactory());
	service.addConverterFactory(new StoryToPostFactory());
	fromPostToStory(service,context);
	
	}

	void fromPostToStory(GenericConversionService service , AnnotationConfigApplicationContext context ){
		FeedPost post = context.getBean("post",FeedPost.class);
		post.setData("GoldenGirl.png");
		post.setCaption("Honey Your soul is Golden");
		post.setComments(new String[] { "sweet like honey" , "beauty!!!" });
		post.setLikes(234);
		
		System.out.println("--------------------------------------------------------");
		System.out.println(post);
		System.out.println("--------------------------------------------------------");
		
		Story story = service.convert(post,Story.class);
		
		System.out.println("------------post to story-------------------------------");
		System.out.println(story);
		System.out.println("--------------------------------------------------------");
		
	}
	void fromStoryToPost(GenericConversionService service , AnnotationConfigApplicationContext context ) {
		
		Story st = context.getBean("story",Story.class);
		st.setData("inFourLayout.jpg");
		st.setLikes(56);
		st.setReply(new String[] {"Mast Distey!!" ,"Kas Tond Kelay :):)","kay hota aaj?" });
		
		System.out.println("--------------------------------------------------------");
		System.out.println(st);
		System.out.println("--------------------------------------------------------");
		
		FeedPost ps = service.convert(st,FeedPost.class);
		System.out.println("------------Story to Post-------------------------------");
		System.out.println(ps);
		System.out.println("--------------------------------------------------------");
		
	
	}
}
