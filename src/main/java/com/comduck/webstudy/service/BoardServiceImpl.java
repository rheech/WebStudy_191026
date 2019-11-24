package com.comduck.webstudy.service;

import com.comduck.webstudy.dao.BoardDAOImpl;
import com.comduck.webstudy.vo.BoardVO;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
    BoardDAOImpl boardDAO;
	
	@Override
    public void create(BoardVO vo) {

    }

    @Override
    public void read(BoardVO vo) {

    }

    @Override
    public void update(BoardVO vo) {

    }

    @Override
    public List<BoardVO> listAll() {
        return null;
    }

    @Override
    public void increaseViewCount(int boardNumber) {

    }

	@Override
	public void inputList(BoardVO boardVO) {
		boardDAO.inputList(boardVO);
	}

	@Override
	public BoardVO showDetail(Map<String, Integer> paramMap) {
		return boardDAO.showDetail(paramMap);
	}
	
	@Override
	public void updateViewCnt(Map<String, Integer> paramMap) {
		boardDAO.updateViewCnt(paramMap);
	}

	@Override
	public void updateBoard(Map<String, Object> paramMap) {
		boardDAO.updateBoard(paramMap);
	}

	@Override
	public void deleteBoard(Map<String, Object> paramMap) {
		boardDAO.deleteBoard(paramMap);
	}

}
