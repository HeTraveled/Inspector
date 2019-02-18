package com.official.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.official.model.OfficialArticle;
import com.official.service.OfficialArticleService;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("official")
public class OfficialController {
	
	@Autowired
	private OfficialArticleService officialArticleService;
	
	/*
	 * 公文列表
	 */
	
	@RequestMapping("officialArticleList")
	@ResponseBody
	public DataGrid officialArticleList(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			DataGrid datagrid=new DataGrid();
		//	User user=(User) request.getSession().getAttribute("user");
			PagedResult<OfficialArticle> pagedResult=officialArticleService.display(null,page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	/*
	 * 公文入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		ModelAndView mv=new ModelAndView();
		mv.addObject("role", user.getRid());
		mv.setViewName("official/official");
		return mv;
	}
	/**
	 * 详情页
	 */
	@RequestMapping("officialArticleDetails")
	public ModelAndView officialArticleDetails(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("official",officialArticleService.selectid(id));
		mv.setViewName("official/officialArticleDetails");
		return mv;
	}
	/**
	 * 创建页
	 */
	@RequestMapping("createofficialArticlePage")
	public ModelAndView createofficialArticlePage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("official/createofficialArticle");
		return mv;
	}
	/**
	 * 创建
	 */
	@RequestMapping("createofficialArticle")
	@ResponseBody
	public Json createofficialArticle(@RequestBody OfficialArticle officialArticle,HttpServletRequest request){
		try {
			User user=(User)request.getSession().getAttribute("user");
			officialArticle.setCreateBy(user.getName());
			officialArticle.setCreateTime(new Date());
			if(officialArticleService.create(officialArticle)==1)
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
	@RequestMapping("updateofficialArticlePage")
	public ModelAndView updateofficialArticlePage(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("official",officialArticleService.selectid(id));
		mv.setViewName("official/updateofficialArticle");
		return mv;
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateofficialArticle")
	@ResponseBody
	public Json updateofficialArticle(@RequestBody OfficialArticle officialArticle,HttpServletRequest request){
		try {
			if(officialArticleService.update(officialArticle)==1)
				return new Json(200,"操作成功！",null);
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Json delete(@RequestParam("id") Integer id,HttpServletRequest request){
		try {
				if(officialArticleService.delete(id)==1){
					return new Json(200,"操作成功！",null);
				}else
					return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
}