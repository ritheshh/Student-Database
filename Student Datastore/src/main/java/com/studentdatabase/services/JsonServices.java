package com.studentdatabase.services;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentdatabase.bean.Student;

public class JsonServices {

	public Student parseJsonStudentEntry(HttpServletRequest req) {
		String jsonString = parseJsonToString(req);
		ObjectMapper mapper = new ObjectMapper();

		try {
			Student student = mapper.readValue(jsonString.toString(), Student.class);
			return student;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public String parseJsonToString(HttpServletRequest req) {
		StringBuffer jsonSb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jsonSb.append(line);
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonSb.toString();
	}
	
	public JsonNode extractSingleJsonElement(String jsonString, String element) {
		JsonNode node = null;
		try {
			node = new ObjectMapper().readValue(jsonString, JsonNode.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		return node.get(element);
	}
	
}
