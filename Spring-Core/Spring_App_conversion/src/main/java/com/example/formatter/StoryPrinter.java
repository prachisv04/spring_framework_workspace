package com.example.formatter;

import java.util.Arrays;
import java.util.Locale;
import com.example.formatter.*;

import org.springframework.format.Printer;

public class StoryPrinter implements Printer{

	@Override
	public String print(Object object, Locale locale) {
		Story story = (Story) object;
		return  "{" +
				"\n\tId="+ Story.getId()+
				"\n\tData="+story.getData()+
				"\n\t"+Arrays.toString(story.getReply())+" replies on your stories"+
				"\n\t"+story.getLikes()+" people liked your story"+
				"\n}";
	}

}
