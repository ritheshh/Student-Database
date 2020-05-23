package com.studentdatabase.controller;

import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentdatabase.bean.Student;
import com.studentdatabase.dao.DatastoreDao;
import com.studentdatabase.services.JsonMessages;

@RequestMapping("/view")
public class ViewController {

	@RequestMapping
	public String view() {
		
		return "view";
	}
	
	@RequestMapping(value = "/studentdatabase", method = RequestMethod.GET)
	public @ResponseBody Object viewStub(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		DatastoreDao dao = new DatastoreDao();
		
		
		TreeMap<Integer, Student> studentMap = (TreeMap)dao.queryAllEntities();
		if(studentMap != null)
			map.put("StudentDatabase", studentMap);
		map.put("Action", JsonMessages.SUCCESS_ACTION);
		return map;
	}
}
