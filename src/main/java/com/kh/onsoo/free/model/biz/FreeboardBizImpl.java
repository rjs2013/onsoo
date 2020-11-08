package com.kh.onsoo.free.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onsoo.free.model.dao.FreeboardDao;
import com.kh.onsoo.free.model.dto.FreeboardDto;
import com.kh.onsoo.utils.PagingVO;

@Service
public class FreeboardBizImpl implements FreeboardBiz {

	@Autowired
	private FreeboardDao freeboardDao;
	
	@Override
	public List<FreeboardDto> selectList() {
		return freeboardDao.selectList();
	}

	@Override
	public FreeboardDto selectOne(int free_no) {
		return freeboardDao.selectOne(free_no);
	}

	@Override
	public int insert(FreeboardDto dto) {
		return freeboardDao.insert(dto);
	}

	@Override
	public int update(FreeboardDto dto) {
		return freeboardDao.update(dto);
	}

	@Override
	public int delete(int free_no) {
		return freeboardDao.delete(free_no);
	}

	//	페이징
	
	@Override
	public int countBoard() {
		return freeboardDao.countBoard();
	}

	@Override
	public List<FreeboardDto> selectBoard(PagingVO vo) {
		return freeboardDao.selectBoard(vo);
		
	}

}
