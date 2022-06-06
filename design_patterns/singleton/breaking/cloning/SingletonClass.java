package com.dhiraj.design_patterns.singleton.breaking.cloning;

public class SingletonClass implements Cloneable {

	private static SingletonClass singleton = null;

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		if (singleton == null) {
			singleton = new SingletonClass();
		}
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
