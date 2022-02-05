package com.comento.project.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comento.project.board.BoardVO;
import com.comento.project.board.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/ListAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		model.addAttribute("list", boardService.listAll());
		return "listAll";
	}
	
	@RequestMapping(value = "/Write", method = RequestMethod.GET)
	public String wirte() {
		return "register";
	}
	
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String regist(BoardVO board) throws Exception {
		boardService.register(board);
		return "redirect:/ListAll";
	}
	
	@RequestMapping(value = "/Read", method = RequestMethod.GET)
	public String read(@RequestParam("no")Integer no, Model model) throws Exception {
		model.addAttribute(boardService.read(no));
		return "read";
	}
}
