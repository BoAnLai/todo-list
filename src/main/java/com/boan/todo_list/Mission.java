package com.boan.todo_list;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "missions")
@EntityListeners(AuditingEntityListener.class)
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
	private LocalDateTime createdTime;

	@Column(name = "last_completed_time")
	private LocalDateTime lastCompletedTime;

	@Column(name = "hidden")
	private boolean hidden;

	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Column(name = "last_modified_by")
	@LastModifiedBy
	private String lastModifiedBy;

	public Mission() {
	};

	public Mission(String name, String description) {
		this.name = name;
		this.description = description;
		this.completed = false;
		this.createdTime = LocalDateTime.now();
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

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getLastCompletedTime() {
		return lastCompletedTime;
	}

	public void setLastCompletedTime(LocalDateTime lastCompletedTime) {
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
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + "]";
	}
}
