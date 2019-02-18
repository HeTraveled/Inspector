package com.home.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("error")
public class ErrorController {
	
	 @RequestMapping("500")
	    public ModelAndView error_500() {
		return new ModelAndView("error/500");
	 }
	 @RequestMapping("404")
	    public ModelAndView error_404() {
		return new ModelAndView("error/404");
	 }
	 @RequestMapping("400")
	    public ModelAndView error_400() {
		return new ModelAndView("error/400");
	 }
}