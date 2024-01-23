package com.example.aspectj;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class LoggerAspect {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	private static String FILENAME = "logging_"+dtf.format(LocalDateTime.now())+".txt";
	private static File file ;
	private static FileWriter fileWriter ;
	
	LoggerAspect() throws IOException{
		file = new File(FILENAME);
		file.createNewFile();
		file.setWritable(true);
		fileWriter = new FileWriter(file,true);
		fileWriter.write(" ------------------------------------------------------------------------------------------ \n");
		fileWriter.write("\t"+LocalDateTime.now()+"  \n");
		fileWriter.close();
		System.out.println("check \""+FILENAME+"\" for logs");
	}

	
	 @Before(value = "execution(* *.*(..))")
	 public void BeforeMethod(JoinPoint joinPoint) {
     	try {
			fileWriter = new FileWriter(file,true);
			fileWriter.write("Method Execution Started : "+joinPoint.getSignature()+"\n");
			fileWriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	 
	 @AfterReturning(value = "execution(* *.*(..))",returning="list")
	 public void AfterReturning(JoinPoint joinPoint) {
		 try {
				fileWriter = new FileWriter(file,true);
				fileWriter.write("Method Executed Successfully : "+joinPoint.getSignature().getName()+"\n");
				fileWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 @AfterThrowing(value = "execution(* *.*(..))",throwing="ex")
	 public void AfterThrowing(JoinPoint joinPoint,StudentNotFound ex) {
		 try {
				fileWriter = new FileWriter(file,true);
				fileWriter.write("Method Ended with exception : "+joinPoint.getSignature().getName()+"\n");
				fileWriter.write("\t\t"+ex.getLocalizedMessage()+"\n");
				fileWriter.write(ex.getCause()+"\n");
				fileWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	 }
	
	@After(value = "execution(* *.*(..))")
	public void AfterMethod(JoinPoint joinPoint) {
		try {
			fileWriter = new FileWriter(file,true);
			fileWriter.write("Method Ended  "+joinPoint.getSignature().getName()+"\n");
			fileWriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Around("getMethod() || setMethod()")
	public void forEntities(ProceedingJoinPoint jp) {
		try {	
			fileWriter = new FileWriter(file,true);
			fileWriter.write("Around Method Ended  "+jp.getSignature().getName()+"\n");
			jp.proceed();
			fileWriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Pointcut("execution( * get*()  )")
	public void getMethod() {}
	
	@Pointcut("execution( * set*(..)  )")
	public void setMethod() {}
	
}
