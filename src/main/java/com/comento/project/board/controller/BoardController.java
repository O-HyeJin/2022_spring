package com.comento.project;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comento.project.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/ListAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", boardService.listAll());
	}
}
