package com.comduck.webstudy.dao;

import com.comduck.webstudy.vo.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardMapper {
    List<BoardVO> listAll();
    void inputList(BoardVO boardVO);
    BoardVO showDetail(Map<String, Integer> paramMap);
	void updateViewCnt(Map<String, Integer> paramMap);
	void updateBoard (Map<String, Object> paramMap);
	void deleteBoard (Map<String, Object> paramMap);
}
