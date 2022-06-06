package com.dhiraj.design_patterns.singleton.lazy;

class SessionFactory {

	private static SessionFactory sessionFactory = null;

	private SessionFactory() {
	}

	public static SessionFactory getInstance() {
		if (sessionFactory == null) {
			sessionFactory = new SessionFactory();
		}
		return sessionFactory;
	}
}

public class SingletonClassLazyInitDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactory.getInstance();
		SessionFactory sessionFactory1 = SessionFactory.getInstance();

		System.out.println(sessionFactory);
		System.out.println(sessionFactory1);

		System.out.println(sessionFactory.equals(sessionFactory1) ? "Singleton" : "Not Singelton");
	}
}
