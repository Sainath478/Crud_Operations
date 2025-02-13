package com.classes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pro_id;
	private String name;
	private String manager_name;
	private String leader_name;
	
	public Projects() {
	}

	@Override
	public String toString() {
		return "Projects [pro_id=" + pro_id + ", name=" + name + ", manager_name=" + manager_name + ", leader_name="
				+ leader_name + "]";
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getLeader_name() {
		return leader_name;
	}

	public void setLeader_name(String leader_name) {
		this.leader_name = leader_name;
	}

	public Projects(int pro_id, String name, String manager_name, String leader_name) {
		super();
		this.pro_id = pro_id;
		this.name = name;
		this.manager_name = manager_name;
		this.leader_name = leader_name;
	}

}
