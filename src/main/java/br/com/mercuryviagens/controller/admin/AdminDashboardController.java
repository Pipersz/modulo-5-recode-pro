package br.com.mercuryviagens.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

	@GetMapping
	public String list() {
		return "/admin/dashboard"; 
	}
}
