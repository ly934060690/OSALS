/**
 * 
 */
package com.b510.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.b510.common.Common;
import com.b510.excel.util.DbUtil;
import com.b510.excel.vo.Student;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class SaveData2DB {

	@SuppressWarnings({ "rawtypes" })
	public void save() throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		Student student = null;
		List<Student> list = xlsMain.readXls();

		for (int i = 0; i < list.size(); i++) {
			student = list.get(i);
			List l = DbUtil.selectOne(Common.SELECT_STUDENT_SQL + "'%" + student.getName() + "%'", student);
			if (!l.contains(1)) {
				DbUtil.insert(Common.INSERT_STUDENT_SQL, student);
			} else {
				System.out.println("The Record was Exist : No. = " + student.getNo() + " , Name = " + student.getName() + ", Age = " + student.getAge() + ", and has been throw away!");
			}
		}
	}
}
