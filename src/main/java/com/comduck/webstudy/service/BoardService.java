package com.comduck.webstudy.service;

import com.comduck.webstudy.vo.BoardParam;
import com.comduck.webstudy.vo.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    void create(BoardVO vo);
    void read(BoardVO vo);
    void update(BoardVO vo);
    
    List<BoardVO> listAll();
    void increaseViewCount(int boardNumber);
    void inputList(BoardVO boardVO);
    BoardVO showDetail (Map<String, Integer> paramMap);
    void updateViewCnt(Map<String, Integer> paramMap);
    void updateBoard (Map<String, Object> paramMap);
    void deleteBoard(Map<String, Object> paramMap);
}
