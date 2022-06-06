package com.dhiraj.design_patterns.singleton.breaking.reflection;

import java.lang.reflect.Constructor;

import com.dhiraj.design_patterns.singleton.breaking.Singleton;

public class SingletonClassBreakingUsingReflection {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		Singleton singleton1 = null;

		try {
			Constructor<Singleton> ctor = Singleton.class.getDeclaredConstructor();
			ctor.setAccessible(true);
			singleton1 = ctor.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(singleton);
		System.out.println(singleton1);
		System.out.println(singleton.equals(singleton1) ? "Singleton" : "Not Singleton");
	}
}
