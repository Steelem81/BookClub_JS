package com.jeffs.bookClub.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeffs.bookClub.models.LoginUser;
import com.jeffs.bookClub.models.User;
import com.jeffs.bookClub.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session != null) {
			return "redirect:/books/all";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User newUser, BindingResult result, Model model, HttpSession session){
		User user = userServ.register(newUser,  result);
		
		if(user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			session.setAttribute("userId", user.getId());
			System.out.println(user.getId());
			return "redirect:/books/all";
		}
		
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (user == null) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {
			session.setAttribute("userId", user.getId());
			return "redirect:/books/all";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	

}
