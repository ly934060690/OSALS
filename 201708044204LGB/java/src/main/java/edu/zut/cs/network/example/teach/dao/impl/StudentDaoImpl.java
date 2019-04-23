package edu.zut.cs.network.example.teach.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.zut.cs.network.example.teach.dao.StudentDao;
import edu.zut.cs.network.example.teach.entity.Student;

public class StudentDaoImpl implements StudentDao {

	protected Logger logger = LogManager.getLogger(this.getClass().getName());

	String url = "jdbc:mysql://202.196.37.91:3306/course?useUnicode=true&characterEncoding=utf8";
	String user = "zutnlp";
	String password = "zutnlp";

	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;

	public StudentDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> studentList = new ArrayList<Student>();
		try {
			rs = stmt.executeQuery("SELECT ID, FULLNAME FROM T_STUDENT");
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getLong(1));
				student.setName(rs.getString(2));
//				logger.info("{ID:" + rs.getLong(1) + "\t fullname:" + rs.getString(2) + "}");
				if (StringUtils.equals(student.getName(), name)) {
					logger.info("found student:" + student);
					studentList.add(student);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentList;
	}

	@Override
	public Student findById(Long id) {
		Student student = null;
		try {
//			String selectSQL = "SELECT ID, FULLNAME FROM T_STUDENT WHERE ID = ? ";
			String selectSQL = "SELECT ID, CODE, FULLNAME, CLAZZ FROM T_STUDENT WHERE ID =  "+ id;
//			PreparedStatement ps = this.con.prepareStatement(selectSQL);
//			ps.setLong(1, id);					
			ResultSet rs = this.stmt.executeQuery(selectSQL);
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getLong("ID"));
				student.setCode(rs.getString("CODE"));
				student.setName(rs.getString("FULLNAME"));
				student.setAdminClass(rs.getString("CLAZZ"));
//				logger.info("{ID:" + rs.getLong(1) + "\t fullname:" + rs.getString(2) + "}");
				if (student.getId() == id) {
					logger.info("found student:" + student);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		String valueString = "VALUES (" + student.getId() + "," + student.getName() + " " + student.getCode() + ")";
		String sql = "INSERT INTO T_STUDENT " + valueString;
		try {
			int num = this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
