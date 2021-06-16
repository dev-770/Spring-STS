package com.ict.db;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<BVO> getList() {
		List<BVO> list = null;
		list = sqlSessionTemplate.selectList("selectAll");
		return list;
	}
	
	public int getInsert(BVO bvo) {
		int result = 0;
		result = sqlSessionTemplate.insert("insert", bvo);
		return result;
	}
	
	public int getHit(String b_idx) {
		int result = 0;
		result = sqlSessionTemplate.update("hitup", b_idx);
		return result;
	}
	// 상세보기
	public BVO getOneList(String b_idx) {
		BVO bvo = null;
		bvo = sqlSessionTemplate.selectOne("onelist", b_idx);
		return bvo;
	}
	// 댓글 가져오기
	public List<CVO> getC_List(String b_idx) {
		List<CVO> c_list = null;
		c_list = sqlSessionTemplate.selectList("c_list", b_idx);
		return c_list;
	}
	
	// 댓글 삽입
	public int getC_Insert(CVO cvo) {
		int result = 0;
		result = sqlSessionTemplate.insert("c_insert", cvo);
		return result;
	}
}








