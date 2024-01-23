package com.example.formatter;

import org.springframework.format.support.FormattingConversionService;

import com.example.formatter.Story;

public class FormatterTests {
	public  void main() {
		
		FormattingConversionService service = new FormattingConversionService();
		StoryPrinter printer = new StoryPrinter();
		StoryParser parser = new StoryParser();
		service.addFormatterForFieldType(Story.class, printer, parser);
		
		TestPrinter(service);
		TestParser(service);
	}

	 private void TestPrinter(FormattingConversionService service) {
	
		 Story story = new Story("ramji.jpg",46,new String[] {"woahhh","jai shree ram","mere ghar ram aaye hai"});
		 String result = service.convert(story,String.class);
		 System.out.println(result);
	 }

	void TestParser(FormattingConversionService service) {
		
		String text="goldenGirl.png,123,Beauty!!!,OMG,Sweet";
		Story story = service.convert(text, Story.class);
		System.out.println(story.toString());	
		
	}

	
}
