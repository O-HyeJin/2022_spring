package com.comento.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comento.project.dao.BoardDAO;
import com.comento.project.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		boardDAO.create(board);
	}

	@Override
	public BoardVO read(Integer no) throws Exception {
		return boardDAO.read(no);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void remove(Integer no) throws Exception {
		boardDAO.delete(no);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}

}
