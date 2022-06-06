package com.dhiraj.design_patterns.singleton.breaking.cloning.solution;

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
		throw new CloneNotSupportedException();
		// return super.clone();
	}

}
