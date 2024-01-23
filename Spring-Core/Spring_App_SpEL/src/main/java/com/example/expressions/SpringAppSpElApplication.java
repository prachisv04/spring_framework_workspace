package com.example.expressions;

public class SpringAppSpElApplication {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		ExpressionTests test = new ExpressionTests();
		//test.testConversion();
		//test.autoGrow();
		//test.getValFromContextBean();
		//test.checkLiterals();
		
//		test.checkInline();
//		test.checkMethodCalls();
		
//		test.methodAsVariable();
//		test.CollectionSelection();
		test.CollectionProjection();
	}

}
