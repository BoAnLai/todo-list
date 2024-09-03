package com.boan.todo_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	MissionService missionService;

	@GetMapping("/api/missions")
	public List<Mission> getMissions() {
		return missionService.findByHidden(false);
	}

	@GetMapping("/api/missions/all")
	public List<Mission> getAllMissions() {
		return missionService.findAll();
	}

	@PostMapping("/api/missions")
	public Mission createMission(@RequestBody Mission mission) {
		return missionService.create(mission.getName(), mission.getDescription());
	}

	@PostMapping("/api/missions/{id}")
	public Mission updateMission(@RequestBody Mission mission) {
		return missionService.update(mission.getId(), mission.getName(), mission.getDescription());
	}

	@PostMapping("/api/missions/{id}/checked")
	public Mission checkMission(@PathVariable int id) {
		return missionService.checkCompleted(id);
	}

	@DeleteMapping("/api/missions/{id}/delete")
	public Mission hideMission(@PathVariable int id) {
		return missionService.hideMission(id);
	}

}
