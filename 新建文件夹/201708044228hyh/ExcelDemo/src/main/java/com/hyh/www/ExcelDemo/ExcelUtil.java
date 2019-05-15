package com.hyh.www.ExcelDemo;

//从excel表中读取数据

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//获取Workbook
public class ExcelUtil {
	public static int getCellNum() {
		return cellNum;
	}

	public static int getRowNum() {
		return rowNum;
	}

	public static String[] getExcelCell() {
		return excelCell;
	}

	private static final String EXCEL_XLS="xls";
	private static final String EXCEL_XLSX="xlsx";
	private static String[] excelCell=new String[3000];     //保存单元格数据
	private static int cellNum;                             //列数
	private static int rowNum;                              //行数
	
	public static Workbook getWorkbook(InputStream in,File file) throws IOException {
		Workbook wb=null;    //HSSFWorkbook的实现类
		if(file.getName().endsWith(EXCEL_XLS)) { //endsWith()测试此字符串是否以指定的后缀结尾。 
			wb=new HSSFWorkbook(in);
			//HSSFWorkbook支持以。xls为后缀的二进制格式
		}else if(file.getName().endsWith(EXCEL_XLSX)) {
			wb=new XSSFWorkbook(in);
		}
		return wb;
	}
	
	//判断文件是否是Excel文件
	public static void checkExcelVaild(File file) throws Exception {
		if(!file.exists()) {
			throw new Exception("文件不存在！");
		}
		if(!(file.isFile()&&(file.getName().endsWith(EXCEL_XLS)||file.getName().endsWith(EXCEL_XLSX)))){//endsWith()测试此字符串是否以指定的后缀结尾。 
			throw new Exception("文件不是Excel文件！");
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
	
	public static void main(String[] args) throws Exception {
		//SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");//一个具体的类,使用给定模式 SimpleDateFormat并使用默认的 FORMAT语言环境的默认日期格式符号。 
		try {	
			File excelFile=new File("C:\\Users\\17905\\Desktop\\j2ee\\Software17_Student_JavaEE.xlsx");//创建文件对象
			FileInputStream in=new FileInputStream(excelFile);//文件流
			checkExcelVaild(excelFile);//判断文件是否是Excel文件
			Workbook workbook=getWorkbook(in,excelFile);
			disPlayRow(workbook);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
