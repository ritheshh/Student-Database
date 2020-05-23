package com.studentdatabase.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentdatabase.dao.DatastoreDao;
import com.studentdatabase.services.JsonMessages;
import com.studentdatabase.services.JsonServices;

@RequestMapping("/delete")
public class DeleteController {

	@RequestMapping
	public String delete() {

		return "delete";
	}

	@RequestMapping(value = "/deletedata", method = RequestMethod.DELETE)
	public @ResponseBody Object deleteStudent(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		JsonServices service = new JsonServices();
		DatastoreDao dao = new DatastoreDao();
		int rollNo = service.extractSingleJsonElement(service.parseJsonToString(req), "rollNo").asInt();
		if (!dao.deleteEntity(rollNo)) {
			map.put("Action", JsonMessages.ERROR_ROLL_NO_NOT_FOUND);
			return map;
		}
		map.put("Action", JsonMessages.SUCCESS_ACTION);
		map.put("url", "/index.html");
		return map;
	}
}
