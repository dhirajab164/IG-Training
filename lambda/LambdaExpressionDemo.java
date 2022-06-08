package com.dhiraj.lambda;

interface Sayable {
	public String say();
}

interface Greetable {
	public String say(String name);
}

interface Wishable {
	public String wish(String greetings, String name);
}

interface Addable {
	public long add(int a, int b);
}

public class LambdaExpressionDemo {
	public static void main(String[] args) {

		// no-arg
		Sayable s = () -> "Hello world";
		System.out.println(s.say());

		// single-arg
		Greetable g = (name) -> "Hello " + name;
		System.out.println(g.say("John"));

		// multiple-args
		Wishable w = (greet, to) -> greet + to;
		System.out.println(w.wish("Hello", " John"));

		// with return
		Wishable ws = (greet, to) -> {
			String wish = greet + to + ", How are ya?";
			return wish;
		};
		System.out.println(ws.wish("Hello", " John"));

		// multiple-args
		Addable adder = (a, b) -> a + b;
		System.out.println(adder.add(11, 12));
	}
}
