package com.yzq.katl.util;

import java.util.UUID;

public class UUIDGenerator {

	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
}
