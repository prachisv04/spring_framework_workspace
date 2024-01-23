different ways to load resources or files (e.g. text files, XML files, properties files, or image files) into the Spring application context. Spring ResourceLoader provides a unified getResource() method to retrieve an external resource by the resource path.

The Spring Resource is a general interface for representing an external resource. Spring provides the following 6 implementations for the Resource interface.

UrlResource
ClassPathResource
FileSystemResource
ServletContextResource
InputStreamResource
ByteArrayResource

2. Loading a Resource using ResourceLoader
	The ResourceLoader is used for loading resources from classpath or file system resources. It has two methods:
	//Expose the ClassLoader used by this ResourceLoader.
		
		ClassLoader getClassLoader()
	
//Return a Resource handle for the specified resource location.
		
		Resource getResource(String location)
	
The getResource() method will decide which Resource implementation to instantiate according to the 	resource path. To get the reference of ResourceLoader, implement the ResourceLoaderAware interface.
	

3. Loading a Resource using ApplicationContext
	In Spring, all application contexts implement the ResourceLoader interface. Therefore, all application 	contexts may be used to obtain Resource instances.
	To get the reference of ApplicationContext, implement the ApplicationContextAware interface.

4. Building Paths for Loading Resources
	
4.1. Load a Resource from Application Root Directory
	To load files from the application’s root directory folder, use the below template:
	
	Resource banner = resourceLoader.getResource("file:data.txt");
	
4.2. Load a Resource from Class Path
	To load a file from the classpath, use the below template:
	
	Resource banner = resourceLoader.getResource("classpath:classpathdata.txt");
	
4.3. Load a Resource from the Filesystem
	To load files from the filesystem outside the application folder, use the absolute path of the file:
	
	Resource banner = resourceLoader.getResource("file:c:/temp/filesystemdata.txt");
	
4.4. Load Resource from URL
	To load files from any URL, use the below template:
	
	Resource banner = resourceLoader.getResource("//howtodoinjava.com/readme.txt");
	
	
If we try to get classpath file from UrlResource then it will throw exception MalformedURLException - unknown protocol : classpath