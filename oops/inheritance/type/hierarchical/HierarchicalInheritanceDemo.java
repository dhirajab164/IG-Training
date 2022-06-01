package com.dhiraj.oops.inheritance.type.hierarchical;

class Animal {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog extends Animal {
	void bark() {
		System.out.println("barking...");
	}
}

class Cat extends Animal {
	void meow() {
		System.out.println("meowing...");
	}
}

public class HierarchicalInheritanceDemo {
	public static void main(String args[]) {
		Cat cat = new Cat();
		cat.meow();
		cat.eat();

		Dog dog = new Dog();
		dog.bark();
		dog.eat();

	}
}
