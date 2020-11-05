package com.kh.onsoo.admin.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onsoo.admin.model.dto.AdminDto;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@Override
	public List<AdminDto> selectList() {
		List<AdminDto> list = new ArrayList<AdminDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			logger.info("AdminDaoImpl selectList[error]");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AdminDto selectOne(String member_id) {
		AdminDto dto = new AdminDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", member_id);
		} catch (Exception e) {
			logger.info("AdminDaoImpl selectOne[error]");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(AdminDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			logger.info("AdminDaoImpl insert[error]");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(AdminDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			logger.info("AdminDaoImpl update[error]");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int member_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",member_no);
		} catch (Exception e) {
			logger.info("AdminDaoImpl delete[error]");
			e.printStackTrace();
		}
		return res;
	}
	
	
	//�븘�씠�뵒 以묐났泥댄겕 
	@Override
	public int idchk(AdminDto dto) {
		int res= 0;
		try {
			res=sqlSession.selectOne(NAMESPACE+"idchk",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public AdminDto selectOne2(String member_id) {
		AdminDto dto = new AdminDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne2", member_id);
		} catch (Exception e) {
			logger.info("AdminDaoImpl selectOne2[error]");
			e.printStackTrace();
		}
		
		return dto;
	} 

}
