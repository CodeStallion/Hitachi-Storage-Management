package com.hitachi.objects;

import java.util.Hashtable;

public class ParseElement {
	
	private String elementName;
	private Hashtable<String,String> attrib = new Hashtable<String,String>();
	
	public void setElement(String name){
		elementName = name;
	}
	
	public void setAttribute(String a,String v){
		attrib.put(a, v);
	}
	
	public String getElement() {
		return elementName;
	}
	
	public Hashtable<String,String> getAttribute(){
		return attrib;
	}
}
