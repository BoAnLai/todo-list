package com.boan.todo_list;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "missions")
public class Mission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "completed")
	private boolean completed;

	@Column(name = "created_time")
	private ZonedDateTime createdTime;

	@Column(name = "last_completed_time")
	private ZonedDateTime lastCompletedTime;

	@Column(name = "hidden")
	private boolean hidden;

	public Mission() {
	};

	public Mission(String name, String description) {
		this.name = name;
		this.description = description;
		this.completed = false;
		this.createdTime = ZonedDateTime.now();
		this.hidden = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public ZonedDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(ZonedDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public ZonedDateTime getLastCompletedTime() {
		return lastCompletedTime;
	}

	public void setLastCompletedTime(ZonedDateTime lastCompletedTime) {
		this.lastCompletedTime = lastCompletedTime;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + ", completed=" + completed
				+ ", createdTime=" + createdTime + ", lastCompletedTime=" + lastCompletedTime + ", hidden=" + hidden
				+ "]";
	}
}
