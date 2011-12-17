/*
 * This class performs the XML Parsing using SAXP protocol. 
 * 
 */

package com.hitachi.util;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import com.hitachi.objects.ParseElement;


//import com.hitachi.objects.PDEV;

import java.util.*;
import java.io.*;

public class XmlParser extends DefaultHandler{

	/**
	 * @param args
	 */
	static Vector<ParseElement> objs;

	public XmlParser() {
		// TODO Auto-generated constructor stub
		objs = new Vector();
	}
	
	public void startDocument() throws SAXException {
    	System.out.println("Parsing Starts");
    }
    
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)throws SAXException{
    	
    	ParseElement tmp = new ParseElement();
    	if (atts != null){
    		int len = atts.getLength();
    		for(int i=0;i<len;i++){
    			String a = atts.getQName(i);
    			String val = (String)atts.getValue(a);
    			tmp.setElement(localName);
    			tmp.setAttribute(a, val);
    		}
     	}
    	objs.add(tmp);
    }
    
    public void endDocument() throws SAXException {
    	Iterator iter = objs.iterator();
    	try {
        	FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			
        	while (iter.hasNext()) {
	            ParseElement tmp = (ParseElement) iter.next();
	            out.write("\n" + tmp.getElement() +":\n");
	            if(!tmp.getAttribute().isEmpty()){
	            	Enumeration e = tmp.getAttribute().keys();
	            	while(e.hasMoreElements()){
	            		String tag = (String) e.nextElement();
	            		String a = (String)tmp.getAttribute().get(tag);
	            		out.write("\t" + tag + "=" +a+"\n");
	            	}
	            }
	            
        	}
        out.close();
        System.out.println("Done!!!");
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
    }
	
	private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

	public static Vector<ParseElement> run(String file) throws Exception {
		
		Vector p;
		String filename = file;
        if (filename == null) {
            System.out.println("Error: Input filename");
        }
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new XmlParser());
        System.out.println(convertToFileURL(filename));
        xmlReader.parse(convertToFileURL(filename));
        return objs;
	}

}
