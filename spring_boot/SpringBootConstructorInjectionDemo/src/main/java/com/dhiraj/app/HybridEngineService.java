package com.dhiraj.app;

import org.springframework.stereotype.Service;

@Service
public class HybridEngineService implements IEngine {

	@Override
	public void run() {
		System.out.println("Hybrid Engine is Running.");
	}

}
