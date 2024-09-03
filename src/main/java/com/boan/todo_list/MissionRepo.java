package com.boan.todo_list;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MissionRepo extends CrudRepository<Mission, Integer> {

	List<Mission> findByHidden(boolean hidden);

	@Query("SELECT m FROM Mission m WHERE m.name LIKE %:keyword% OR m.description LIKE %:keyword%")
	List<Mission> searchByKeyword(@Param("keyword") String keyword);
}
