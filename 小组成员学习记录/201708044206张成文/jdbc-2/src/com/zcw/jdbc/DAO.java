package com.zcw.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DAO {

	
	public void update(String sql, Object...args)  {
		//insert,update,delete 都可以包含其中
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBC_tools.getconnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i=0;i<args.length;i++)
			{
				preparedStatement.setObject(i+1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBC_tools.release(null, preparedStatement, connection);
		}
	}
    
   // 查一个信息,返回对应的对象
     public <T> T get(Class<T> clazz,String sql, Object...args){
    	 
    	 T entity =null;
    	 Connection connection =null;
    	 PreparedStatement preparedStatement = null;
    	 ResultSet rs =null;
    	 try {
    		 connection = JDBC_tools.getconnection();
    		 preparedStatement = connection.prepareStatement(sql);
    		 //3.填充占位符
    		 for(int i=0;i<args.length;i++)
    		 {
    			 preparedStatement.setObject(i+1, args[i]);
    		 }
    		 //4.进行查询，得到ResultSet
    		 rs = preparedStatement.executeQuery();
    		 //5.若ResultSet中有记录，准备一个Map<String ,Object>  键：存放列的别名  值：存放列的值
    		 
    		 if(rs.next())
    		 {
    			 Map<String ,Object> values =new HashMap<String ,Object>();
    			 //6、得到ResultSetMetaData对象
    			 ResultSetMetaData resultSetMetaData = (ResultSetMetaData) rs.getMetaData();
    			 //7.处理ResultSet，指针下移一个单位
    			 //8.由ResultSetMetaData对象得到结果集中有多少列
    			  int columnCount = resultSetMetaData.getColumnCount();
    			  //9.由ResultSetMetaData得到每一列的别名，由ResultSet得到每一列的值
    			  for(int i=0;i<columnCount;i++)
    			  {
    				  String columnLabel = resultSetMetaData.getColumnLabel(i+1);
    				  Object columnValue = rs.getObject(i+1);
    				  //10.填充Map对象
    				  values.put(columnLabel, columnValue);
    				  
    			  }
    			  //11.用反射创建Class对应的对象
    			 entity = clazz.newInstance();
    			  //12.遍历Map对象，用反射填充对象的属性值
    			  for(Map.Entry<String, Object> entry: values.entrySet())
    			  {
    				  String propertyName = entry.getKey();
    				  Object value = entry.getValue();
    				  //ReflectionUtils.setFieldValue(entity, propertyName, value);
    				  //为属性赋值
    				  BeanUtils.setProperty(entity, propertyName, value);
    			  }
    		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBC_tools.release(rs, preparedStatement, connection);
		}
	return entity;
    }
 // 查一组信息，返回对应的对象集合
     public <T> List<T> getForList(Class<T> clazz,String sql, Object...args){
	return null;
   }
//返回某条记录的某一个字段的值  或一个统计的值（一共有多少条记录等。）
    public <E> E getForValue(String sql, Object...args){

	return null;
    }
}
