package com.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LoadSpringContext {

	//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static Resource r=new ClassPathResource("applicationContext.xml", LoadSpringContext.class);  
    @SuppressWarnings("deprecation")
	private static BeanFactory factory=new XmlBeanFactory(r);  
	
    public static BeanFactory getSpringFactory(){    	
    	return factory;
    }
    
   public static void main(String a[]) {
	System.out.println(factory);
} 
    
    
}
