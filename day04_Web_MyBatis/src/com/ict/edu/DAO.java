package com.ict.edu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public DAO() { }
	
	public DAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate =sqlSessionTemplate;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List< VO> getList() {
		List<VO> list = null;
		// select 4가지 경우 : 결과 여러개 (List<VO>) : selectList()
		//									  결과 한 개 (VO)				:selectOne()
		// 								  파라미터 값이 없는 경우	: 메소드("사용매퍼 ID");
		//									  파라미터 값이 있는 경우
		//											- 파라미터 값이 한 개일 경우 : 메소드("사용매퍼 ID", 파라미터);
		//											- 파라미터 값이 두 개일 경우 (VO, Map) :
		//													 메소드("사용매퍼 ID" vo);,  메소드("사용매퍼 ID" map);
		list = sqlSessionTemplate.selectList("selectAll");
		return list;
	}
	
	// insert, update, delete 결과 무조건 int
	public int getInsert(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.insert("insert", vo);
		return result;
	}
	
	// idx로 검색하는 select문
	public VO detail(String idx) {
		VO vo = null;
		vo = sqlSessionTemplate.selectOne("detail", idx);
		return vo;
	}
}
