package com.dhiraj.app;

import org.springframework.stereotype.Service;

@Service
public class IcEngineService implements IEngine {

	@Override
	public void run() {
		System.out.println("IC Engine is Running.");
	}

}
