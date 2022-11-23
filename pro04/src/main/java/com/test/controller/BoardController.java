package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.BoardDTO;
import com.test.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@GetMapping("list.do")
	public String boardList(Model model) throws Exception{
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList = boardService.boardList();
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
		
	}
	
	@GetMapping("detail.do")
	public String boardDetail(@RequestParam("seq") int seq, Model model) throws Exception{
		
		
		
		return "board/boardDetail";
		
	}
	
}