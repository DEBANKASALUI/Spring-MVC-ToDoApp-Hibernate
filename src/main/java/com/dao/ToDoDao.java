package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entity.ToDo;

@Component
public class ToDoDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(ToDo toDo) {	
		Integer i=(Integer)this.hibernateTemplate.save(toDo);
		System.out.println(i+" ToDo added successfully!!");
		return i;	
	}

	public List<ToDo> getAllToDos() {
		List<ToDo> todos = this.hibernateTemplate.loadAll(ToDo.class);
		return todos;
	}
}
