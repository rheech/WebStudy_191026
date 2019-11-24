package com.comduck.webstudy.dao;

import com.comduck.webstudy.vo.BoardParam;
import com.comduck.webstudy.vo.BoardVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private static final String NAMESPACE = "com.comduck.webstudy.dao";

    @Inject
    private SqlSession sqlSession;

    @Inject
    private BoardMapper boardMapper;

    @Override
    public void create(BoardVO vo) {
        sqlSession.insert("BoardMapper.insert", vo);
    }

    @Override
    public void read(int boardNumber) {
        sqlSession.selectOne("BoardMapper.view", boardNumber);
    }

    @Override
    public void update(BoardVO vo) {
        sqlSession.update("BoardMapper.updateArticle", vo);
    }

    @Override
    public List<BoardVO> listAll() {
        return boardMapper.listAll();
    }

    @Override
    public void increaseViewCount(int boardNumber) {
        sqlSession.update("BoardMapper.increaseViewCount", boardNumber);
    }

	@Override
	public void inputList(BoardVO boardVO) {
        boardMapper.inputList(boardVO);
	}

	@Override
	public BoardVO showDetail(Map<String, Integer> paramMap) {
		return boardMapper.showDetail(paramMap);
	}

	@Override
	public void updateViewCnt(Map<String, Integer> paramMap) {
		boardMapper.updateViewCnt(paramMap);
	}

	@Override
	public void updateBoard(Map<String, Object> paramMap) {
		boardMapper.updateBoard(paramMap);
	}

	@Override
	public void deleteBoard(Map<String, Object> paramMap) {
		boardMapper.deleteBoard(paramMap);
	}
	
}
