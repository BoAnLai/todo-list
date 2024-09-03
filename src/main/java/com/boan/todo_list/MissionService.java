package com.boan.todo_list;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionService {

	@Autowired
	MissionRepo missionRepo;

	public List<Mission> findAll() {
		return (List<Mission>) missionRepo.findAll();
	};

	public List<Mission> findByHidden(boolean hidden) {
		return missionRepo.findByHidden(hidden);
	};

	public List<Mission> searchByKeyword(String keyword) {
		return missionRepo.searchByKeyword(keyword);
	};

	public Mission create(String name, String description) {
		Mission mission = new Mission(name, description);
		missionRepo.save(mission);

		return mission;
	}

	public Mission update(int id, String name, String description) {

		Optional<Mission> optional = missionRepo.findById(id);
		Mission mission = optional.get();

		mission.setName(name);
		mission.setDescription(description);
		missionRepo.save(mission);

		return mission;
	};

	public Mission checkCompleted(int id) {

		Optional<Mission> optional = missionRepo.findById(id);
		Mission mission = optional.get();

		mission.setCompleted(!mission.isCompleted());
		if (mission.isCompleted()) {
			mission.setLastCompletedTime(ZonedDateTime.now());
		}

		missionRepo.save(mission);

		return mission;
	};

	public Mission hideMission(int id) {
		Optional<Mission> optional = missionRepo.findById(id);
		Mission mission = optional.get();

		mission.setHidden(true);
		missionRepo.save(mission);

		return mission;
	}

}
