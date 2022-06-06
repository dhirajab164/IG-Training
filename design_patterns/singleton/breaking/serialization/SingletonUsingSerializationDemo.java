package com.dhiraj.design_patterns.singleton.breaking.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonUsingSerializationDemo {
	public static void main(String[] args) {
		SerializableSingleton singleton = SerializableSingleton.getInstance();
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
			out.writeObject(singleton);
			out.close();

			ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
			SerializableSingleton serializableSingleton = (SerializableSingleton) in.readObject();
			in.close();

			System.out.println(singleton);
			System.out.println(serializableSingleton);
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
