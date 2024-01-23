@Resource Annotation :
	
The @Resource annotation is used to declare a reference to a resource. The @Resource annotation resolves dependency injection. We can use it in place of @Autowired annotation.

In case of field-based and method-based injection, the Spring container will inject the resource when the application is initialized. For class-based injection, resource is injected at runtime.

The elements of @Resource annotation are name, type, authenticationType, shareable, mappedName and description.

If @Resource annotation is not using name attribute, Spring accesses other beans for matching them by type.

The @Resource can be used on a
	
	a. Field   	/-- Employee has a address
	
	b. Method		/-- Department has employee and address

The @Resource can be used by
	
	a. name attribute		/-- Employee has a address and Department has employee and address
	
	b. type attribute.		/-- 
	(  When more than one beans are eligible to be injected, use type attribute and specify the class type to be injected.
		eg. when their are multiple implementation of interface )
			

@Resource vs @Autowired

1. The @Resource is supported only for fields and bean property setter methods with a single argument whereas @Autowired applies to fields, constructors, and multi-argument methods.
2. In case when multiple beans are eligible to be injected, we should prefer using @Resource over combination of @Autowired and @Qualifier.
3. When using @Resource annotation at method level, the method can have only one argument. The @Autowired annotation can be used at argument level, so it supports more than one arguments.
4. In case of annotation-driven injection by name, we should prefer JSR-250 @Resource annotation over Spring @Autowired.




