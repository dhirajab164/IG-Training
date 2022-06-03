package com.dhiraj.design_patterns.singleton.eager;

class SessionFactory {

	private static final SessionFactory sessionFactory = new SessionFactory();

	private SessionFactory() {
	}

	public static SessionFactory getInstance() {
		return sessionFactory;
	}
}

public class SingletonClassEagerInitDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactory.getInstance();
		SessionFactory sessionFactory1 = SessionFactory.getInstance();

		System.out.println(sessionFactory);
		System.out.println(sessionFactory1);

		System.out.println(sessionFactory.equals(sessionFactory1) ? "Singleton" : "Not Singelton");

	}
}
