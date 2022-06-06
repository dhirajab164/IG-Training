package com.dhiraj.design_patterns.singleton.breaking.reflection.solution.exception;

import java.lang.reflect.Constructor;

public class SingletonClassPreventReflectionBreakingUsingExceptionDemo {
	public static void main(String[] args) {

		SingletonThrowingException singleton = SingletonThrowingException.getInstance();
		SingletonThrowingException singleton1 = null;

		try {
			Constructor<SingletonThrowingException> ctor = SingletonThrowingException.class.getDeclaredConstructor();
			ctor.setAccessible(true);
			singleton1 = ctor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(singleton);
		System.out.println(singleton1);

	}
}

/**
 * 
 * console output ->
 * 
 * java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAcces
sorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstruc
torAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at com.dhiraj.design_patterns.singleton.breaking.reflection.solution.exception.
SingletonClassPreventReflectionBreakingUsingExceptionDemo.main(SingletonClassPre
ventReflectionBreakingUsingExceptionDemo.java:14)
Caused by: java.lang.RuntimeException: Not Allowed
	at com.dhiraj.design_patterns.singleton.breaking.reflection.solution.exception.
SingletonThrowingException.<init>(SingletonThrowingException.java:10)
	... 5 more
	
com.dhiraj.design_patterns.singleton.breaking.reflection.solution.exception.SingletonThrowingException@70dea4e
null

 **/
