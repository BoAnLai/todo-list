package com.boan.todo_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private MissionRepo missionRepo;

	@Autowired
	private MissionService missionService;

	public MyCommandLineRunner(MissionRepo missionRepo) {
		this.missionRepo = missionRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("===");

		System.out.println("commandlinerunner completeed");
	}

}
