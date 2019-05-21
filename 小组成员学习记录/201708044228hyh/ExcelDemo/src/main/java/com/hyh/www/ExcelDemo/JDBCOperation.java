package com.hyh.www.ExcelDemo;

//import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCOperation {
	public static int insert(String[] excelCell,int mark) {
		Connection conn=JDBCUtil.getConn();
		String sql="insert into student(stu_no, grade, major,stu_class,num,stu_id,stu_name,sex) values(?,?,?,?,?,?,?,?)";
		PreparedStatement psmt;
		try {
			psmt=(PreparedStatement)conn.prepareStatement(sql);
			psmt.setInt(1,Integer.parseInt(excelCell[mark++].trim()));
			psmt.setInt(2,Integer.parseInt(excelCell[mark++].trim()));
			psmt.setString(3, excelCell[mark++].trim());
			psmt.setString(4, excelCell[mark++].trim());
			if((excelCell[mark])==null||(excelCell[mark]).equals("")||(excelCell[mark]).equals("null")) {
			    psmt.setInt(5,0);
			    mark++;
			}else {
				psmt.setInt(5,Integer.parseInt(excelCell[mark++].trim()));
			}
			psmt.setString(6,excelCell[mark++].trim());
			psmt.setString(7, excelCell[mark++].trim());
			psmt.setString(8, excelCell[mark++].trim());
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mark;
	}

	/*public static Integer getAll() {
		Connection conn=JDBCUtil.getConn();
		String sql="select * from test";
		PreparedStatement psmt;
		try {
			psmt=(PreparedStatement)conn.clientPrepareStatement(sql);
			ResultSet rs=psmt.executeQuery();
			int col=rs.getMetaData().getColumnCount();
			System.out.println("---------------------------------------------");
			while(rs.next()) {
				for(int i=1;i<=col;i++) {
					System.out.print(rs.getString(i)+"    ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}