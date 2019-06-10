package com.fortech.internship.dao;


public enum Level {
	 STUDENT(4),
	 ADMIN(3),
	 PROFESOR(2),
	 INSCRIS(1);
	
	 private final int levelCode;

	    Level(int levelCode) {
	        this.levelCode = levelCode;
	    }
	    
	    public int getLevelCode() {
	        return this.levelCode;
	    }
	
}