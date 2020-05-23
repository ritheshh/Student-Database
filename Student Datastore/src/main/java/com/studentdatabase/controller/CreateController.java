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

@RequestMapping("/create")
public class CreateController {

		@RequestMapping
		public String create() {

			return "create";
		}
		
		@RequestMapping(value = "/studentdatabase", method = RequestMethod.POST)
		public @ResponseBody Object createStub(HttpServletRequest req) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			JsonServices service = new JsonServices();
			Student student = service.parseJsonStudentEntry(req);
			DatastoreDao dao = new DatastoreDao(); 
			if(dao.checkEntityExists(student.getRollno())) {
				System.out.println("Error: This RollNo. is already present in the database");
				map.put("Action", JsonMessages.ERROR_STUDENT_ENTRY_ALREADY_EXISTS);
				return map;
			}
			dao.putEntity(student);
			map.put("Action", JsonMessages.SUCCESS_ACTION);
			map.put("url", "/index.html");
			return map;	
		}
}
