package com.dhiraj.lambda;

public class LambdaCreatingThreadDemo {
	public static void main(String[] args) {

		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				try {
					Thread.sleep(500);
					System.out.print(i + " ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
