package com.dhiraj.design_patterns.singleton.breaking.reflection.solution.enum_instance;

public class SingletonClassPreventReflectionBreakingUsingEnumDemo {
	public static void main(String[] args) {
		SingletonWithEnum singleton = SingletonWithEnum.INSTANCE;
		SingletonWithEnum singleton1 = SingletonWithEnum.INSTANCE;

		System.out.println(singleton);
		System.out.println(singleton1);

		System.out.println(singleton.equals(singleton1) ? "Singleton" : "Not Singleton");
	}
}
