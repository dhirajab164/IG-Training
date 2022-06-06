package com.dhiraj.design_patterns.singleton.breaking.serialization.solution;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493911167952238423L;

	public static SerializableSingleton singleton = null;

	private SerializableSingleton() {

	}

	public static SerializableSingleton getInstance() {
		if (singleton == null)
			singleton = new SerializableSingleton();
		return singleton;
	}

	protected Object readResolve() {
		return singleton;
	}

}
