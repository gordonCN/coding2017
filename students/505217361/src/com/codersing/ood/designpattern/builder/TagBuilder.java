package com.codersing.ood.designpattern.builder;

import java.util.ArrayList;
import java.util.List;



public class TagBuilder {
	private Node rootNode;
	private Node currentNode;
	private Node parentNode;
	
	
	
	public TagBuilder(String name){
		
		rootNode = new Node(name);
		currentNode = rootNode;
		parentNode = null;
		
		
	}
	
	public TagBuilder childern(String name){
		
		parentNode = currentNode;
		
		currentNode = new Node(name);
		
		parentNode.addChildern(currentNode);
		
		return this;
	}
	
	public TagBuilder addSibling(String siblingTagName){
		currentNode = new Node(siblingTagName);
		parentNode.addChildern(currentNode);
		return this;
	}
	public TagBuilder parentAddSibling(String siblingTagName){
		
		currentNode = new Node(siblingTagName);
		
		parentNode.addSibling(currentNode);
		return this;
	}
	
	public TagBuilder attribute(String name,String value){
		this.currentNode.setAttribute(name, value);
		return this;
	}
	
	public String toXML(){
		
		return this.rootNode.toXML();
	}
	
}
