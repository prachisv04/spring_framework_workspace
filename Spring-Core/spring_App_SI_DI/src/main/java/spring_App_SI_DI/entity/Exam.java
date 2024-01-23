package spring_App_SI_DI.entity;

import java.beans.ConstructorProperties;

public class Exam {

	private String examId;
	private Student student;
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", student=" + student + "]";
	}
	
	
	public Exam() {
		super();
	}
	public Exam(String examId, Student student) {
		super();
		this.examId = examId;
		this.student = student;
	}
	
	
	
	
}
