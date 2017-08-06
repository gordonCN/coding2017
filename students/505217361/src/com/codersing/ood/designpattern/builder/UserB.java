package com.codersing.ood.designpattern.builder;

public class UserB {
	private String name;
	private String sex;
	private int age;
	private String address;
	
	public String getAddress(){
		return address;
	}
	
	public String getName() {
		return name;
	}


	public String getSex() {
		return sex;
	}


	public int getAge() {
		return age;
	}


	private UserB(Builder builder){
		this.name = builder.name;
		this.sex = builder.sex;
		this.age = builder.age;
		this.address = builder.address;
	}
	
	//注意用静态类,使用域为 public
	
	public static class Builder{
		private String name; //必选
		private String sex;  // 必选
		private int age;   // 可选
		private String address; 
		
		
		public Builder(String name,String sex){			
			this.name = name ;
			this.sex = sex;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
		}
		
		public Builder address(String address){
			this.address = address;
			return this;
		}
		
		
		public UserB build(){
			return new UserB(this);
		}
	}
	
}
