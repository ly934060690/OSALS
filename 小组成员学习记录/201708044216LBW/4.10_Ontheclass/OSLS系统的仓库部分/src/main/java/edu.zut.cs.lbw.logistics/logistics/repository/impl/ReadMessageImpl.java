package edu.zut.cs.lbw.logistics.logistics.repository.impl;

import com.logistics.lbw.logistics.repository.ReadMessage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
@Repository("readMessage")
@Component
public class ReadMessageImpl implements ReadMessage
{
    @Override
    public String Read()
    {
        String text="";
        try
        {
            File path = new File("D:\\Java\\IDEAWorkShop\\OSLS系统的物流部分的提前准备\\PartForLogistics\\src\\Goods.txt");
            FileInputStream is =  new FileInputStream(path);
            HSSFWorkbook excel=new HSSFWorkbook(is);     //HSSFWorkbook Excel的文档对象
            //获取第一个sheet
            HSSFSheet sheet0=excel.getSheetAt(0);      //HSSFSheet是Excel的表单
            for (Iterator rowIterator = sheet0.iterator(); rowIterator.hasNext();)
            {
                HSSFRow row=(HSSFRow) rowIterator.next();          //这里是获取行
                for (Iterator iterator=row.cellIterator();iterator.hasNext();)
                {
                    HSSFCell cell=(HSSFCell) iterator.next();    //这里是获取格子单元
                    //根据单元的的类型 读取相应的结果
                    if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING) text+=cell.getStringCellValue()+"\t";
                    else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) text+=cell.getNumericCellValue()+"\t";
                    else if(cell.getCellType()==HSSFCell.CELL_TYPE_FORMULA) text+=cell.getCellFormula()+"\t";
                }
                text+="\n";
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return text;
    }
}
