package com.classes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stu_id;
	private String stu_name;
	private String stu_city;
	private int standered;
	
	public Students() {
	}

	public Students(int stu_id, String stu_name, String stu_city, int standered) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_city = stu_city;
		this.standered = standered;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_city() {
		return stu_city;
	}

	public void setStu_city(String stu_city) {
		this.stu_city = stu_city;
	}

	public int getStandered() {
		return standered;
	}

	public void setStandered(int standered) {
		this.standered = standered;
	}

	@Override
	public String toString() {
		return "Students [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_city=" + stu_city + ", standered="
				+ standered + "]";
	}
	

}
