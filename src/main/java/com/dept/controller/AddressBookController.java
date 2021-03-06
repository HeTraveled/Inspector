package com.dept.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.home.service.UserService;
import com.util.page.DataGrid;
import com.util.page.PagedResult;
@Controller
@Scope("prototype")
@RequestMapping("AB")
public class AddressBookController {
	@Autowired
	private UserService userService;
	
	/*
	 * 通讯录用户详细信息
	 */
	@RequestMapping("/ABlistPage")
	@ResponseBody
	public DataGrid ABlistPage(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@RequestParam(value="did",required=false) Integer did,HttpServletRequest request){
	 
	
		 DataGrid datagrid=new DataGrid();

		 PagedResult<User> pagedResult=userService.select(null,page,rows,did);
		 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
			 datagrid.setTotal(pagedResult.getTotal());
			 datagrid.setRows(pagedResult.getDataList());
		 }
		 	return datagrid;
	}
	
	@RequestMapping(value="/AB1")
	public ModelAndView asd(@RequestParam(value="did",required=false) Integer did,
			HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.addObject("did", did);
		mv.setViewName("department/ab");
		return mv;
	}
}
