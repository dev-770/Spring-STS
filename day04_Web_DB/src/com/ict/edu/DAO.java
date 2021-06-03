package com.ict.edu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	private JdbcTemplate jdbcTemplate;

	public DAO() { }
	
	public DAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		System.out.println(jdbcTemplate);
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// jdbcTemplate 사용법은 select문 문법만 다르다.
	// insert, update, delete는 PreparedStatement 사용법과 같다.
	
	// 리스트 : select의 결과는 무조건 List<VO>이다. 
	public List<VO> getList() {
		String sql = "select * from members order by idx";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("age"));
				vo.setAge(rs.getString("age"));
				vo.setReg(rs.getString("reg"));
				return vo;
			}
		});
	}
	
	public int getInsert(VO vo) {
		int result = 0;
		String sql = "Insert into members values(?, ?, ?, ?, ?, sysdate)";
		result = jdbcTemplate.update(sql,vo.getIdx(),vo.getId(), vo.getPw(), vo.getName(), vo.getAge());
		return result;
	}
	
}
