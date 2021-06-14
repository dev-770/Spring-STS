package com.ict.edu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	// MyBatis에서 DB 사용을 위해 지원하는 클래스 (DI)
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// DB 처리할 메소드들 만들기 
	public List<VO> getList(){
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("selectAll");
		return list;
	}
	
	public int getInsert(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.insert("insert", vo);
		return result;
	}
	
	public VO getDetail(VO vo) {
		VO one_vo = null;
		one_vo = sqlSessionTemplate.selectOne("detail", vo);
		return one_vo;
	}
	
	public int getDelete(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.delete("delete", vo);
		return result;
	}
	
	public int getUpdate(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.update("update", vo);
		return result;
	}
}








