package com.dhiraj.design_patterns.singleton.breaking.cloning.solution;

public class SingletonClassCloningDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonClass singleton = SingletonClass.getInstance();
		SingletonClass singleton1 = (SingletonClass) singleton.clone();

		System.out.println(singleton);
		System.out.println(singleton1);

	}
}
