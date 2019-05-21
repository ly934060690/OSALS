package com.osals.enwrap.admin.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.sql.DriverManager;
//import java.sql.SQLException;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//import com.mysql.jdbc.Connection;
import com.osals.base.dao.GenericTreeDaoTestCase;
import com.osals.enwrap.admin.domain.Customer;

public class CustomerDaoTest extends GenericTreeDaoTestCase<Long, Customer, CustomerDao>{
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
	    this.customerDao = customerDao;
		this.dao=this.customerDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for (int i = 0; i < root_size; i++) {
			Customer customer = new Customer();
			customer.setC_name("customer_" + i);
			for (int j = 0; j < 10; j++) {
				Customer c = new Customer();
				c.setC_name("customer_" + i + "_" + j);
				c.setParent(customer);
			}
			this.customerDao.save(customer);
		}

		List<Customer> roots = this.customerDao.getRoot();
		assertEquals(root_size, roots.size());
		
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Customer> roots=" + roots); //$NON-NLS-1$
		}
	}
	
	/*@Test
	public void testExcel() throws Exception{
		try {
			File excelFile=new File("C:\\Users\\17905\\Desktop\\j2ee\\Customer.xlsx");//创建文件对象
			FileInputStream in=new FileInputStream(excelFile);//文件流
			Workbook wb=null;    //HSSFWorkbook的实现类
			wb=new XSSFWorkbook(in);
			disPlayRow(wb);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//文件流
	}			
	
	public static void disPlayRow(Workbook workbook) {
		try {
			//int sheetCount=workbook.getNumberOfSheets();//得到Sheet的数量
			Sheet sheet=workbook.getSheetAt(0);//遍历第1个Sheet
			
			//跳过第一行目录（列标识）
			int count=0,mark=0;
			cellNum=0;rowNum=0;
			for(Row row:sheet) {
				if(count<1) {
					count++;
					continue;
				}
				if(row.getCell(0)==null) {
					return;
				}
				
				//int columnTotalNum=row.getPhysicalNumberOfCells();//获取总列数
				//System.out.println("总列数："+columnTotalNum);
				
				cellNum=row.getLastCellNum();  //得到列数
				
				//不扫描空列
				int end=row.getLastCellNum();
				for(int i=0;i<end;i++) {
					Cell cell=row.getCell(i);
					if(cell==null) {
						//System.out.print("null"+"\t");
						excelCell[mark++]=null;
						continue;
					}
				
				    Object obj=getValue(cell);
				    //System.out.print(obj+"\t");
				    excelCell[mark++]=obj+"";
				}
				//System.out.println();
				rowNum++;                       //行数，不算目录
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//返回单元格的值
		private static Object getValue(Cell cell) {
			Object obj=null;
			switch(cell.getCellType()) {
			case BOOLEAN:
				obj=cell.getBooleanCellValue();break;
			case FORMULA:
				obj=cell.getCellFormula();break;
			case STRING:
				obj=cell.getStringCellValue();break;
			case NUMERIC:
				obj=cell.getDateCellValue();break;
				default:
					break;
			}
			return obj;
		}
		
		public static Connection getConn() {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/student_test";
			String username="root";
			String password="11q22q33q";
			Connection conn=null;
			try {
				Class.forName(driver);
				conn=(Connection)DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	
	private static String[] excelCell=new String[300];     //保存单元格数据
	private static int cellNum;                             //列数
	private static int rowNum;                            //行数
	*/
	
	CustomerDao customerDao;
	
}
