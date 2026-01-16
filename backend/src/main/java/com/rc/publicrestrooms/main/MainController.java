package com.rc.publicrestrooms.main;

import com.rc.publicrestrooms.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("main")
@Controller
public class MainController extends BaseController {

	@GetMapping("")
	public String main(Model model){

		return "main";
	}

}