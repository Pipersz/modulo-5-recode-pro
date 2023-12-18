package br.com.mercuryviagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.User;
import br.com.mercuryviagens.dto.UserDto;
import br.com.mercuryviagens.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@GetMapping("/register")
	public ModelAndView registerPage() {
		ModelAndView model = new ModelAndView("register");
		model.addObject("userDto", new UserDto());
		return model;
	}
	
	@PostMapping("/register")
	public String register(UserDto userDto, BindingResult result, Model model) {
		
		User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Já existe uma conta cadastrada com o mesmo email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
	}
}
