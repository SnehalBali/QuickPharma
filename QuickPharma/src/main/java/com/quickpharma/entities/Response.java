package com.quickpharma.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class Response {
	
	public static ResponseEntity<?> success(Object data) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("status", "success");
		if(data != null)
			map.put("data", data);
		
		return ResponseEntity.ok(map);
	}
	
	public static ResponseEntity<?> error(Object error) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("status", "error");
		if(error != null)
			map.put("error", error);
		
		return ResponseEntity.ok(map);
	}

}
