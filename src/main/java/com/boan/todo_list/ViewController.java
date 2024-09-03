package com.boan.todo_list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping({ "/", "/home", "todo-list", "todo_list", "index" })
	public String webPage() {
		return "forward:/index.html";
	}

}
