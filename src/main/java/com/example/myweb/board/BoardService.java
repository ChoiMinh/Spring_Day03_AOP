package com.example.myweb.board;

import java.util.List;

public interface BoardService {
	BoardVO getOne(BoardVO vo);
	List<BoardVO> getList(BoardVO vo);
	
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(BoardVO vo);
}