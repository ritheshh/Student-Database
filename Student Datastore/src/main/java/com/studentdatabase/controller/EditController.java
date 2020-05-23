package com.studentdatabase.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentdatabase.bean.Student;
import com.studentdatabase.dao.DatastoreDao;
import com.studentdatabase.services.JsonMessages;
import com.studentdatabase.services.JsonServices;

@RequestMapping("/edit")
public class EditController {

	@RequestMapping
	public String edit() {
		
		return "edit";
	}
	
	@RequestMapping(value = "/studentdatabase", method = RequestMethod.POST)
	public @ResponseBody Object editdata(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JsonServices service = new JsonServices();
		DatastoreDao dao = new DatastoreDao();
		int rollNo = service.extractSingleJsonElement(service.parseJsonToString(req), "rollNo").asInt();
		if(!dao.checkEntityExists(rollNo)) {
			map.put("Action", JsonMessages.ERROR_ROLL_NO_NOT_FOUND);
			return map; 
		}
		map.put("Student", dao.querySingleEntity(rollNo));
		map.put("Action", JsonMessages.SUCCESS_ACTION);
		return map;
	}
		
	@RequestMapping(value = "/studentdatabase", method = RequestMethod.PUT)
	public @ResponseBody Object editStudent(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JsonServices service = new JsonServices();
		Student student = service.parseJsonStudentEntry(req);
		DatastoreDao dao = new DatastoreDao(); 
		dao.putEntity(student);
		map.put("Action", JsonMessages.SUCCESS_ACTION);
		map.put("url", "/index.html");
		return map;	
	}
}
