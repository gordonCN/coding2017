package com.codersing.ood.designpattern.builder;

import java.util.ArrayList;
import java.util.List;


public class Node{
	private String tagName;
	private List<Node> childern = new ArrayList<Node>();
	private List<Node> sibling = new ArrayList<Node>();
//	private List<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
	private List<Attribute> attributes = new ArrayList<>();
	
	
	private static class Attribute{
		String name;
		String value;
		
		public Attribute(String name,String value){
			this.name = name;
			this.value = value;
		}
		
	}
	
	
	public void setAttribute(String name,String value){
		Attribute att = findAttribute(name);
		if (null != att){
			att.value = value;
			return ;
		}
		attributes.add(new Attribute(name,value));
	}
	
	private Attribute findAttribute(String name){
		for(Attribute attr : attributes){
			if(attr.name.equals(name))
				return attr;
		}
		
		return null;
	}


	public Node(String name){
		
		this.tagName=name;
		
	}
	

	public void addChildern(Node node){
		this.childern.add(node);
	}
	
	public void addSibling(Node node){
		this.sibling.add(node);
	}
	
	public String toXML(){
		return toXML(this);
	}
	
	private String toXML(Node node){
		StringBuilder buffer = new StringBuilder();
		buffer.append("<").append(node.tagName);
		
		if(node.attributes.size() > 0){
			for(int i= 0;i<node.attributes.size();i++){
				Attribute att = node.attributes.get(i);
				buffer.append(" ").append(toXML(att));
			}
		}
		
		if(node.childern.size() > 0){
			buffer.append("> \r\n");
			
			for(Node childnode : node.childern ){
				buffer.append(toXML(childnode));
			}
		}else{
			buffer.append(" /> \r\n");
			return buffer.toString();
		}
		
		
	
		buffer.append("</").append(node.tagName).append("> \r\n");
		
		if(node.sibling.size() > 0){
			for(Node sibnode : node.sibling ){
				buffer.append(toXML(sibnode));
				
			}
			
		}
		
		return buffer.toString();
	}
	
	private String toXML(Attribute attr){
		return attr.name + "=\"" +attr.value + "\"";
	}
	
	
	
}
