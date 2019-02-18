package com.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("Role")

public class RoleController {
	
	@Autowired
	private UserService userService;
	/*
	 * 权限账号列表
	 */
	
	@RequestMapping("/Rolelist")
	@ResponseBody
	public DataGrid Role(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		DataGrid datagrid=new DataGrid();
		PagedResult<User> pagedResult=userService.display(null,page,rows);
		if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
			 datagrid.setTotal(pagedResult.getTotal());
			 datagrid.setRows(pagedResult.getDataList());
		 }
		 	return datagrid;
	}
	
	
	@RequestMapping(value="/Role")
	public ModelAndView asd(HttpServletRequest request){
		return new ModelAndView("Annc/role");
	}

}
