package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.ParkingDTO;
import com.test.service.ParkingService;


@Controller
@RequestMapping("/parking/*")
public class ParkingController {
	
	@Autowired
	ParkingService parkingService;

	@GetMapping("list.do")	//board.list.do
	public String parkingList(Model model) throws Exception{
		List<ParkingDTO> parkingList = new ArrayList<ParkingDTO>();
		parkingList = parkingService.parkingList();
		model.addAttribute("parkingList", parkingList);
		
		return "parking/parkingList";
		
	}
	
	@GetMapping("detail.do")	
	public String parkingDetail(@RequestParam("parkno") int parkno, Model model) throws Exception {
		ParkingDTO dto = parkingService.parkingDetail(parkno);
		model.addAttribute("dto", dto);
		return "parking/parkingDetail";
	}
	
	@GetMapping("insert.do")
	public String insertForm(HttpServletRequest request, Model model) throws Exception {
		return "parking/carIn";
	}
	
	@PostMapping("insert.do")
	public String carIn(HttpServletRequest request, Model model) throws Exception {
		
		ParkingDTO dto = new ParkingDTO();
		dto.setId(request.getParameter("id"));
		dto.setCarnum(request.getParameter("carnum"));
		parkingService.carIn(dto);
		
		return "redirect:list.do";
	}
	
	@GetMapping("delete.do")
	public String carOut(HttpServletRequest request, Model model) throws Exception {
		int parkno = Integer.parseInt(request.getParameter("parkno"));
		parkingService.carOut(parkno);
		
		return "redirect:list.do";
	}
	
	// 기록남는출차
	@PostMapping("delete2.do")
	public String carOut2(HttpServletRequest request, Model model) throws Exception{
		int parkno = Integer.parseInt(request.getParameter("parkno"));
		
		ParkingDTO dto = new ParkingDTO();
		dto.setParkno(parkno);
		dto.setOuttime(request.getParameter("outtime"));
		parkingService.carOut2(dto);
		
		return "redirect:list.do";
		
	}
	
	
}
