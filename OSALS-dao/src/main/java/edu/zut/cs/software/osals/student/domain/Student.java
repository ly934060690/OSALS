package edu.zut.cs.software.osals.student.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

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
@Proxy(lazy = false)
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2149998881257140258L;

	@Column(name = "GRADE")
	String grade;
	@Column(name = "MAJOR")
	String major;
	@Column(name = "SCLASS")
	String sclass;
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

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
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
