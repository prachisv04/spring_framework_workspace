package com.example.expressions;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import io.micrometer.common.util.StringUtils;

class Simple{
	public List<Boolean> booleanList = new ArrayList<Boolean>();
}
public class ExpressionTests {
	
	private SpelParserConfiguration config ;
	private ExpressionParser parser;
	private StandardEvaluationContext context;
	
	ExpressionTests(){
		/*
	 * @param compilerMode the compiler mode that parsers using this configuration object should use
	 * @param compilerClassLoader the ClassLoader to use as the basis for expression compilation
	 * @param autoGrowNullReferences if null references should automatically grow
	 * @param autoGrowCollections if collections should automatically grow
	 * @param maximumAutoGrowSize the maximum size that the collection can auto grow

		 */
		 config=new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,null,true,true,5);
		 setParser(new SpelExpressionParser(config));
		 setContext(new StandardEvaluationContext());
	}
	

	public ExpressionParser getParser() {
		return parser;
	}

	public void setParser(ExpressionParser parser) {
		this.parser = parser;
	}

	public StandardEvaluationContext getContext() {
		return context;
	}

	public void setContext(StandardEvaluationContext context) {
		this.context = context;
	}

	public void testConversion() {
		Simple simple = new Simple();
		simple.booleanList.add(true);
		
		parser.parseExpression("booleanList[0]").setValue(context, simple,"false");
		//string value "false" is internally converted to boolean value false
		
		System.out.println("value in list is :"+ simple.booleanList.get(0));
	}
	
	public void autoGrow(){
		Simple simple =new Simple();
		
		System.out.println("Before : size of list is:"+simple.booleanList.size());
		Boolean exp = (Boolean) parser.parseExpression("booleanList[3]").getValue(simple);
		System.out.println("After : size of list is:"+simple.booleanList.size());
		
		// size of booleanList grows automatically every time we ask for index that is greater than actual size( as configured in parser - setting autogrow true) 
	}
	
	public void getValFromContextBean() {
		AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(AppConfig.class);
		PlaceOfBirth birth = cont.getBean("birth",PlaceOfBirth.class);
		//accessing bean property with expression
		System.out.println(" value="+ parser.parseExpression("country").getValue(context,birth) );
		
		//set variable
		context.setVariable("birthobj", birth);
		//check instanceof
		System.out.println("object birth belongs to class PlaceOfBirth:-"+parser.parseExpression("#birthobj instanceof T(com.example.expressions.PlaceOfBirth)").getValue(context,PlaceOfBirth.class,Boolean.class));
	}
	
	public void checkLiterals() {
		System.out.println("String literal : "+ parser.parseExpression("'message'").getValue());
		System.out.println("Integer literal : "+parser.parseExpression("0xffd").getValue());
		System.out.println("Boolean literal : "+parser.parseExpression("true").getValue());
		System.out.println("Null : "+ parser.parseExpression("null").getValue());	
		
		
	}
	
	public void checkInline() {
		List numbers = (List)parser.parseExpression("{1,2,3,4}").getValue();
		System.out.println("List:-"+numbers);
		Map map = (Map) parser.parseExpression("{ one:'1' , two:'2' , three:'3' , four:'4' }").getValue();
		System.out.println("Map:-"+map);
	}
	
	public void checkMethodCalls() {
		String substr =parser.parseExpression("'ProudIndian'.substring(5,'ProudIndian'.length())").getValue(String.class);
		System.out.println("Substring:-"+substr);
	
	}
	
	public void methodAsVariable() throws NoSuchMethodException, SecurityException {
		
		context.setVariable("rev", this.getClass().getDeclaredMethod("reverseString", String.class));
		
		String backwards = parser.parseExpression("#rev('naidnI')").getValue(context,String.class);
		
		System.out.println( "String in reverse:-"+ backwards);
	}
	public static String reverseString(String input) {
		StringBuilder backwards = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			backwards.append(input.charAt(input.length() - 1 - i));
		}
		return backwards.toString();
	}
	
	public void CollectionSelection() {
		List<Inventor> inventors = new ArrayList<>();
		
		Inventor i1 = new Inventor("Avyaya","Russia");
		Inventor i2 = new Inventor("Ram","Indian");
		Inventor i3 = new Inventor("Rawan","Lankan");
		Inventor i4 = new Inventor("Laxman","Indian");
		
		inventors.add(i1);
		inventors.add(i2);
		inventors.add(i3);
		inventors.add(i4);
		
		context.setVariable("inventors", inventors);
		// get inventors with indian as nationality
		List<Inventor> indians = (List<Inventor>) parser.parseExpression("#inventors.?[nationality=='Indian']").getValue(context);
		
		indians.forEach(System.out::println);
	}
	
	public void CollectionProjection() {
		List<Inventor> inventors = new ArrayList<>();
		
		Inventor i1 = new Inventor("Avyaya","Russia");
		Inventor i2 = new Inventor("Ram","Indian");
		Inventor i3 = new Inventor("Rawan","Lankan");
		Inventor i4 = new Inventor("Laxman","Indian");
		
		inventors.add(i1);
		inventors.add(i2);
		inventors.add(i3);
		inventors.add(i4);
		
		context.setVariable("inventors", inventors);
		// get inventors with indian as nationality
		List<String> indians = (List<String>) parser.parseExpression("#inventors.![name]").getValue(context);
		
		indians.forEach(System.out::println);
	}
}
