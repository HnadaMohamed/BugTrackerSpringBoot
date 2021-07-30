/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BugTrackerApplicationContext implements ApplicationContextAware{

	private static ApplicationContext CONTEXT;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		CONTEXT= applicationContext;
		
	}
	
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);		
	}

}
