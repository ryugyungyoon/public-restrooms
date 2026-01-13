package com.rc.publicrestrooms.base;

import com.rc.publicrestrooms.http.HttpBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	@Autowired
	protected HttpBuilder httpBuilder;

}
