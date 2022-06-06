package com.dhiraj.design_patterns.singleton.breaking.serialization;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

	public static SerializableSingleton singleton = null;

	private SerializableSingleton() {

	}

	public static SerializableSingleton getInstance() {
		if (singleton == null)
			singleton = new SerializableSingleton();
		return singleton;
	}

}
