package com.dhiraj.app;

import org.springframework.stereotype.Service;

@Service
public class ElectricEngineService implements IEngine {

	@Override
	public void run() {
		System.out.println("Electric Engine is Running.");
	}

}
