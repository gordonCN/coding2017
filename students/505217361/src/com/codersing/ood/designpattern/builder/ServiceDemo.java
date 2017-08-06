package com.codersing.ood.designpattern.builder;

public class ServiceDemo {
	
	public static void main(String[] args) {
		
	//	UserB u = new UserB.Builder("a", "man").age(12).build();
		
		
		ServiceDemo sd = new ServiceDemo();
		sd.testNode();
	}
	
	
	public   void testNode() {
		String str =  new TagBuilder("a")
				.attribute("a1", "aa")
				.childern("b").attribute("b1", "bb").attribute("b2", "bbb")
				.childern("d").attribute("d1", "d")
				.parentAddSibling("c").attribute("c1", "cc")
				.childern("e").attribute("e1", "e")
				.toXML();
		System.out.println(str);
	}
	
	public   void testToXML() {
		
		TagBuilder builder = new TagBuilder("order");
		
	/*	String xml = builder.addChild("line-items")
			.addChild("line-item").setAttribute("pid", "P3677").setAttribute("qty", "3")
			.addSibling("line-item").setAttribute("pid", "P9877").setAttribute("qty", "10")
			.toXML();*/
		
		String expected = "<order>"
				+ "<line-items>"
				+ "<line-item pid=\"P3677\" qty=\"3\"/>"
				+ "<line-item pid=\"P9877\" qty=\"10\"/>"
				+ "</line-items>"
				+ "</order>";
		
	//	System.out.println(xml);
	//	assertEquals(expected, xml);
	}
}
