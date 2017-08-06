package com.codersing.ood.designpattern.builder;

public class User {
	private String name;
	private String sex;
	private int age;
	
	public User(String name){
		this(name,null,-1);
	}
	public User(String name,String sex){
		this(name,sex,-1);
	}
	public User(String name,String sex,int age){
		this.name  = name;
		this.sex = sex;
		this.age  = age;
	}
	
	
}
