package com.boan.todo_list;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class MissionAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
//		String currentUser = "currentUser";
		String ipAddress = UserContext.getIpAddress();
		return Optional.of(ipAddress);
	}

}
