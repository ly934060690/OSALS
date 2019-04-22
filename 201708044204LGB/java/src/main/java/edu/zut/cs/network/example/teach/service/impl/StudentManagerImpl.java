package edu.zut.cs.network.example.teach.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.zut.cs.network.example.teach.dao.StudentDao;
import edu.zut.cs.network.example.teach.dao.impl.StudentDaoImpl;
import edu.zut.cs.network.example.teach.entity.Student;
import edu.zut.cs.network.example.teach.service.StudentManager;

public class StudentManagerImpl implements StudentManager {

	protected Logger logger = LogManager.getLogger(this.getClass().getName());

	List<Student> studentList;
	Map<String, Student> studentMap;
	Map<Long, Student> studentIdMap;
	
	StudentDao studentDao = new StudentDaoImpl();

	@Override
	public void load(String data_file) {
		this.studentList = new ArrayList<Student>();
		this.studentMap = new HashMap<String, Student>();
		this.studentIdMap = new HashMap<>();

		InputStream input = StudentManagerImpl.class.getResourceAsStream(data_file);
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheetAt(1);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Student s = new Student();
			/**
			 * Set the system unique Id for object
			 */
			s.setId(Long.valueOf(1000 + i));
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					String value = String.valueOf(row.getCell(j).getStringCellValue());
					if (j == 0)
						s.setCode(value);
					if (j == 1)
						s.setName(value);
					if (j == 2)
						s.setAdminClass(value);
				}
			}
			logger.info(" student_" + i + " is :" + s);

			this.studentList.add(s);
			this.studentMap.put(s.getName(), s);
			this.studentIdMap.put(s.getId(), s);
		}
//		logger.info("size of student list is :" + this.studentList.size());
//		logger.info("size of student map is :" + this.studentMap.size());

	}

	@Override
	public List<Student> findByName(String name) {
		return this.studentDao.findByName(name);
	}

	@Override
	public Student findbyId(Long id) {
		return this.studentIdMap.get(id);
	}

}
