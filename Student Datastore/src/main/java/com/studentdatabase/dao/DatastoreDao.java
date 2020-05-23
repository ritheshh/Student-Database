package com.studentdatabase.dao;

import java.util.Date;
import java.util.TreeMap;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.studentdatabase.bean.Student;

public class DatastoreDao {

	DatastoreService datastore;
	private static final String ENTITY_KIND = "Student";

	public DatastoreDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public void putEntity(Student student) {
		Entity entity = new Entity(ENTITY_KIND, student.getRollno());
		entity.setProperty("Name", student.getName());
		entity.setProperty("Address", student.getAddress());
		entity.setProperty("Department", student.getDepartment());
		entity.setProperty("RollNo", student.getRollno());
		entity.setProperty("Phone", student.getPhone());
		entity.setProperty("DOB", student.getDob());
		datastore.put(entity);
	}

	public boolean deleteEntity(int rollNo) {

		if (checkEntityExists(rollNo)) {
			datastore.delete(createKey(rollNo));
			return true;
		}
		return false;
	}

	public boolean checkEntityExists(int rollNo) {
		Key key = createKey(rollNo);
		Query query = new Query(ENTITY_KIND, key);
		PreparedQuery pq = datastore.prepare(query);
		if (pq.asSingleEntity() == null) {
			return false;
		}
		return true;
	}
	
	public Student querySingleEntity(int rollNo) {
		Key key = createKey(rollNo);
		Query query = new Query(ENTITY_KIND, key);
		PreparedQuery pq = datastore.prepare(query);
		return entityToStudent(pq.asSingleEntity());
	}
	
	
	public TreeMap<Integer, Student> queryAllEntities() {
		Query query = new Query(ENTITY_KIND);
		PreparedQuery pq = datastore.prepare(query);
		TreeMap<Integer, Student> studentMap = new TreeMap<Integer, Student>();
		for(Entity entity : pq.asIterable()) {
			studentMap.put((int)entity.getKey().getId(), entityToStudent(entity));
		}
		
		return studentMap;
	}
	
	public Student entityToStudent(Entity entity) {
		Student student = new Student();
		student.setName((String)entity.getProperty("Name"));
		student.setRollNo((int) ((long) entity.getProperty("RollNo")));
		student.setDob((Date)entity.getProperty("DOB"));
		student.setAddress((String)entity.getProperty("Address"));
		student.setPhone((long)entity.getProperty("Phone"));
		student.setDepartment((String)entity.getProperty("Department"));
		return student;
	}

	public Key createKey(int rollNo) {
		return KeyFactory.createKey(ENTITY_KIND, rollNo);
	}
}
