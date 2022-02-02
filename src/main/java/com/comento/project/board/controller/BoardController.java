package com.comento.project.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
