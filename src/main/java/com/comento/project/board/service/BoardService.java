package com.comento.project.service;

import java.util.List;

import com.comento.project.vo.BoardVO;

public interface BoardService {
	public void regist(BoardVO board) throws Exception;
	public BoardVO read(Integer no) throws Exception;
	public void modify(BoardVO board) throws Exception;
	public void remove(Integer no) throws Exception;
	public List<BoardVO> listAll() throws Exception;
}
