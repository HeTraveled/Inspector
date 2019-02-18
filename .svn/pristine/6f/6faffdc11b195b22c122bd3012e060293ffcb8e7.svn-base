package com.sys.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.sys.model.Bug;
import com.sys.model.Horn;
import com.sys.service.BugService;
import com.sys.service.HornService;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("bug")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	/*
	 * 问题反馈列表
	 */
	
	@RequestMapping("bugList")
	@ResponseBody
	public DataGrid bugList(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			DataGrid datagrid=new DataGrid();
			PagedResult<Bug> pagedResult=bugService.display(page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	/*
	 * 入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sys/bug");
		return mv;
	}
	/**
	 * 创建页
	 */
	@RequestMapping("createBugPage")
	public ModelAndView createBugPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/createBug");
		return mv;
	}
	/**
	 * 创建
	 */
	@RequestMapping("createBug")
	@ResponseBody
	public Json createBug(@RequestBody Bug bug,HttpServletRequest request){
		try {
			User user=(User)request.getSession().getAttribute("user");
			bug.setCreateBy(user.getName());
			bug.setCreateTime(new Date());
			if(bugService.create(bug)==1)
				return new Json(200,"提交成功！",null);
			else return new Json(201,"提交失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
}