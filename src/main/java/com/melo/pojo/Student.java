package com.melo.pojo;

public class Student {

	private String name;

	private Course course;

	private String brief;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void initMethod() {
		System.out.println("初始化方法");
	}
	public void destroyMethod() {
		System.out.println("销毁方法");
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", course=" + course +
				", brief='" + brief + '\'' +
				'}';
	}
}
