
Binding 

Spring data binding mechanism allows user input to be dynamically bound to the beans. In other words 	it allows for setting property values into a target object. The class DataBinder provides this 	functionality. BeanWrapper has similar functionality , but DataBinder additionally supports field 	validation, field formatting and binding result analysis.

BeanWrapper is a low-level class. DataBinder works on higher level. Both DataBinder and BeanWrapper 	use PropertyEditors to parse and format property values. We should prefer to use DataBinder instead 	of BeanWrapper. BeanWrapper is in fact used by DataBinder itself.

	Student object binded to DataBinderExample's student Attribute 
	
Validator


	
	student object validated using StudentValidator (implements Validator interface) before binding it to DataBinderExample
	

PropertyEditor
 
In Spring, when we inject value as string, internally Spring uses built-in PropertyEditors to change that string to actual object. We can also create custom PropertyEditor that will create required object using injected values.
Spring provides PropertyEditorSupport to create custom PropertyEditor. We need to extend PropertyEditorSupport and need to override setAsText method to create required object from string.
The CustomEditorConfigurer has a collection property customEditors that accepts custom PropertyEditors.
 The getAsText() method is called when serializing an object to a String, while setAsText() is used to convert a String to another object.

	StudentTypeEditor serializes and deserializes properties of StudentType which is injected in Student. properties will always be set with uppercase string values regardless of input 