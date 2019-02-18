package com.dept.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.dept.model.Dept;
import com.dept.service.DeptService;
import com.home.model.User;
import com.home.service.UserService;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;


@Controller
@Scope("prototype")
@RequestMapping("/Dept")

public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private UserService userService;
	/*
		修改部门信息
	 */
	/*	@RequestMapping("updateUserPage")
		public ModelAndView updateUserPage(@RequestParam("uid") Integer uid,
				HttpServletRequest request) {
			ModelAndView mv = new ModelAndView();
			User use=userService.selectuid(uid);
			mv.addObject("use", use);
			mv.addObject("dept", deptService.selectall());
			mv.addObject("role", roleService.display());
			mv.setViewName("user/update");
			return mv;
		}*/
	@RequestMapping(value="createDept",method=RequestMethod.POST)
	@ResponseBody
	public Json createDept(HttpServletRequest request,@RequestBody Dept dept){
		try {
			
			dept.setPrincipal(0);
			Dept dep= deptService.selectdept(dept.getDepartmentname());
			if(dep==null){
				deptService.deptsave(dept);
				return new Json(200,"部门添加成功",null);
			}else{ 
				return new Json(201,"该部门已存在",null);
			}
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
	}
	}
	public static Date addDate(Date date,long day) throws ParseException {
		 long time = date.getTime(); // 得到指定日期的毫秒数
		 day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		 time+=day; // 相加得到新的毫秒数
		 return new Date(time); // 将毫秒数转换成日期
		}
	@RequestMapping("createDeptPage")
	@ResponseBody
	public ModelAndView createDeptPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dept",deptService.all());
		mv.addObject("hquser",userService.headdid());
		mv.setViewName("department/create");
		return mv;
	}
	
	@RequestMapping("updateDeptPage")
	@ResponseBody
	public ModelAndView updateUserPage(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		Dept dept=deptService.selectByPrimaryKey(id);
		mv.addObject("dep", dept);
		mv.addObject("dept", deptService.all());
		List<User> u=deptService.selectdid(id);
		List<User> u2=userService.headdid();
		if(u2!=null&&u2.size()!=0)
		for(int i=0;i<u2.size();i++){
			u.add(u2.get(i));
		}
		mv.addObject("user", u);
		mv.addObject("hquser", u2);
		mv.setViewName("department/update");
		return mv;
	}
	/*
	 * 部门添加
	 */
/*	@RequestMapping(value="/Deptsave",method=RequestMethod.POST)
	@ResponseBody
	public Json save(@RequestParam("departmentname") String departmentname){
	//Dept dept= deptService.selectdept(EncodingTool.encodeStr(departmentname));
		Dept dept= deptService.selectdept(departmentname);
		if(dept==null){
			//deptService.deptsave(EncodingTool.encodeStr(departmentname));
			deptService.deptsave(departmentname);
			return new Json(200,"部门添加成功",null);
		}else{ 
			return new Json(201,"该部门已存在",null);
		}
	}
	*/
	/*
	 * 部门列表
	 */
	@RequestMapping("/DeptlistPage")
	@ResponseBody
	public DataGrid DeptlistPage(HttpServletRequest request){
		DataGrid datagrid=new DataGrid();
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		 PagedResult<Dept> pagedResult=deptService.selectname(null,Integer.parseInt(page),Integer.parseInt(rows));
		 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
			 for(int i=0;i<pagedResult.getDataList().size();i++){
				if(pagedResult.getDataList().get(i).getId()==100000||
						pagedResult.getDataList().get(i).getId()==100033)pagedResult.getDataList().remove(i);
			 }
			 datagrid.setTotal(pagedResult.getTotal());
			 datagrid.setRows(pagedResult.getDataList());
		 }
		 	return datagrid;
	}
	
	
	/*
	 * 修改部门名称
	 */
	@RequestMapping(value="/Deptupdate",method=RequestMethod.POST)
	@ResponseBody
	public Json update(@RequestBody Dept record){
	
	/*String a =EncodingTool.encodeStr(record.getDepartmentname());
	record.setDepartmentname(a);*/
	
	Dept dept1=deptService.selectByPrimaryKey(record.getId());
	
    if(dept1!=null){
		int i =deptService.updateByPrimaryKey(record);
		if(i==1){
			return new Json(200,"修改成功",null);
		}
		return new Json(201,"修改失败请刷新后重试",null);
	}else{
		return new Json(201,"修改失败请刷新后重试",null);
	}
	}
	
	@RequestMapping("Deptlist")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		User user =(User) request.getSession().getAttribute("user");
		mv.addObject("role",user.getRid());
		mv.setViewName("department/dept");
		return mv;
		
	}
	@RequestMapping(value="selectLeadership",method=RequestMethod.GET)
	@ResponseBody
	public Json selectLeadership(@RequestParam("id") Integer id,HttpServletRequest request){
	try{
	return new Json(200,null,deptService.selectLeadership(id));
	}catch (Exception e) {
		  Log.getLogger().error(e.getMessage(),e);
	         return new Json(500,null,null);
	}
	
}
	@RequestMapping(value="selecttopDid",method=RequestMethod.POST)
	@ResponseBody
	public Json selecetopDid(@Param("id") Integer id,HttpServletRequest request){
	try{
		List<Dept> dept=deptService.selecttopDid(id);
	List<User> user=userService.selectusernumbers(id);
		if(dept.size()==0&&user.size()==0){
			if(id==100001||id==100000||id==100033){
				return new Json(203,"该部门不可删除！",null);
			}else{
			int i=deptService.deleteByPrimaryKey(id);
		
			if(i==1){
				return new Json(200,"删除成功",null);
			}else{
			return new Json(201,"删除失败请刷新后重试",null);
		}
		}
		}else{
			return new Json(202,"该部门下有未解绑的下属部门/员工，不能删除",null);
		}
	}catch (Exception e) {
		  Log.getLogger().error(e.getMessage(),e);
	         return new Json(500,null,null);
	}
	
}
}

