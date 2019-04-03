package edu.zut.cs;

import java.sql.SQLException;

public class Revicive {
	public static void main(String[] args) throws SQLException {
		Consumer cd=new Consumer();
		cd.getMessage();
		int num=cd.getCount()/8,mark=0;
		while((num--)>0) {
		    mark=KeepJDBC.insert(cd.getExcelCell(),mark);	
		}
		//JDBCOperation.getAll();
	}
}
