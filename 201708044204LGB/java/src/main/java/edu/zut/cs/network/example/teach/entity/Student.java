package edu.zut.cs.network.example.teach.entity;

import edu.zut.cs.network.example.base.BaseObject;

/**
 * Example of Student Class for Entity Object
 * 
 * @author liuxiaoming
 *
 */
public class Student extends BaseObject<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2799307951280434053L;

	/**
	 * administrative class
	 */
	String adminClass;
	
	/**
	 * student Id
	 */
	String code;

	/**
	 * student name;
	 */
	String name;

	public String getAdminClass() {
		return adminClass;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setAdminClass(String adminClass) {
		this.adminClass = adminClass;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

}
