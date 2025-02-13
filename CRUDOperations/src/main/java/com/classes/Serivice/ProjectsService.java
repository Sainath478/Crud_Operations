package com.classes.Serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classes.Dao.ProjectsDao;
import com.classes.entities.Projects;

@Service
public class ProjectsService {

	@Autowired
	ProjectsDao pdao;

	public Projects insertData(Projects p) {
		Projects p1 = pdao.insertData(p);
		return p1;
		

	}

	public Projects updateData(Projects p, int pro_id) {
		Projects p1 = pdao.updateData(p, pro_id);
		return p1;
		

	}

	public int deleteData(int pro_id) {
		int p = pdao.deleteData(pro_id);
		return p;

	}

	public Projects getSingleRecord(int pro_id) {
		Projects p = pdao.getSingleRecord(pro_id);
		return p;

	}

	public List<Projects> getAllRecord() {
		List<Projects> p = pdao.getAllRecord();
		return p;

	}

}
