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
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", boardService.listAll());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerView() {
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerAction(BoardVO board) throws Exception {
		boardService.register(board);
		return "redirect:/listAll";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("no")Integer no, Model model) throws Exception {
		model.addAttribute(boardService.read(no));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyView(Integer no, Model model) throws Exception {
		model.addAttribute(boardService.read(no));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyAction(BoardVO board) throws Exception {
		boardService.modify(board);
		return "redirect:/listAll";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("no")Integer no) throws Exception {
		boardService.remove(no);
		return "redirect:/listAll";
	}
}
