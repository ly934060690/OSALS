package edu.zut.cs.software.OSALS.student.domain;

import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Student类
 * @author 研哥哥
 *
 */

@Entity
@Table(name = "T_STUDENT")
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7322046441088004051L;

	@Column(name = "GRADE")
	String grade;
	@Column(name = "MAJOR")
	String major;
	@Column(name = "CLASS")
	String CLASS;
	@Column(name = "SNO")
	String sno;
	@Column(name = "NAME")
	String name;
	@Column(name = "SEX")
	String sex;
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCLASS() {
		return CLASS;
	}
	public void setCLASS(String cLASS) {
		CLASS = cLASS;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
}
