package com.sys.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sys.model.Slogan;
import com.sys.service.SloganService;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("slogan")
public class SloganController {
	
	@Autowired
	private SloganService sloganService;
	
	/*
	 * 微信标语列表
	 */
	
	@RequestMapping("sloganlist")
	@ResponseBody
	public DataGrid sloganlist(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			DataGrid datagrid=new DataGrid();
			PagedResult<Slogan> pagedResult=sloganService.display(null,page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	/*
	 * 微信标语入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sys/slogan");
		return mv;
	}
	/**
	 * 修改随机
	 */
	@RequestMapping("updaterandom")
	@ResponseBody
	public Json updaterandom(HttpServletRequest request){
		try {
			return new Json(200,"操作成功！",sloganService.updaterandom());
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 修改优先
	 */
	@RequestMapping("first")
	@ResponseBody
	public Json first(@RequestParam("id") Integer id,HttpServletRequest request){
		try {
			sloganService.updaterandom();
			return new Json(200,"操作成功！",sloganService.first(id));
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 随机显示
	 */
	@RequestMapping("random")
	@ResponseBody
	public Json random(HttpServletRequest request,HttpServletResponse response){
		try {
			//解决跨域问题
			response.setHeader("Access-Control-Allow-Origin", "*");  
	        response.setHeader("Access-Control-Allow-Methods", "*");  
	        response.setHeader("Access-Control-Max-Age", "3600");  
	        response.setHeader("Access-Control-Allow-Headers",
	        		"Origin, X-Requested-With, Content-Type, Accept");
	        Slogan slogan=sloganService.randomNum();
	        if(sloganService.randomNum()==null)slogan=sloganService.random();
			return new Json(200,"操作成功！",slogan);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 创建页
	 */
	@RequestMapping("createSloganPage")
	public ModelAndView createSloganPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/createSlogan");
		return mv;
	}
	/**
	 * 创建
	 */
	@RequestMapping("createSlogan")
	@ResponseBody
	public Json createSlogan(@RequestBody Slogan slogan,HttpServletRequest request){
		try {
			if(slogan.getTitle()==null)slogan.setTitle("");
			if(slogan.getTitle2()==null)slogan.setTitle2("");
			slogan.setFirst(0);
			if(sloganService.create(slogan)==1)
				return new Json(200,"操作成功！",null);
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 修改页
	 */
	@RequestMapping("updateSloganPage")
	public ModelAndView updateSloganPage(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("slogan",sloganService.selectid(id));
		mv.setViewName("sys/updateSlogan");
		return mv;
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateSlogan")
	@ResponseBody
	public Json updateSlogan(@RequestBody Slogan slogan,HttpServletRequest request){
		try {
			if(sloganService.update(slogan)==1)
				return new Json(200,"操作成功！",null);
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 删除多项
	 */
	@RequestMapping(value="deletes",method = RequestMethod.POST)
	@ResponseBody
	public Json deletes(@RequestBody List<Integer> id,HttpServletRequest request){
		try {
			if(sloganService.deletes(id)!=0){
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
}