package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {

	private SqlSessionTemplate sessionTemplate;
	
	/**의존성 주입*/
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	Connection conn = null;
	
	public void insertData(CustomDTO dto) {
		
		sessionTemplate.insert("com.custom.insert",dto);
		
	}
	
	public List<CustomDTO> getList(){
		
		List<CustomDTO> lists = sessionTemplate.selectList("com.custom.list");
		
		return lists;
	
	}
	
	public CustomDTO getReadData(int id){
		
		CustomDTO dto = sessionTemplate.selectOne("com.custom.listOne",id);
		
		return dto;
		
	}
	
	public void updateData(CustomDTO dto) {
		
		sessionTemplate.update("com.custom.update",dto);
		
	}
	
	public void deleteData(int id) {
		
		sessionTemplate.delete("com.custom.delete",id);
		
		
	}

	
}
