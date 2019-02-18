package com.sys.controller;

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
import com.sys.model.News;
import com.sys.service.NewsService;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	
	
	@RequestMapping("/newslistskip")
	@ResponseBody
	public ModelAndView newslistskip(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		User user=(User) request.getSession().getAttribute("user");
		mv.addObject("user", user.getUid());
		mv.setViewName("news/newslist");
		return mv;
		
	}
	@RequestMapping("/newscreatskip")
	@ResponseBody
	public ModelAndView newscreatskip(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("news/creatnews");
		return mv;
		
	}
	
	@RequestMapping("/newslist")
	@ResponseBody
	public DataGrid newslist(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows, HttpServletRequest request){
		DataGrid datagrid=new DataGrid();
		PagedResult<News> pagedResult=newsService.select(page,rows);
		 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
			 datagrid.setTotal(pagedResult.getTotal());
			 datagrid.setRows(pagedResult.getDataList());
		 }
		 	return datagrid;
	}
	@RequestMapping(value="/creatnews",method=RequestMethod.POST)
	@ResponseBody
	public Json creatnews(@RequestBody News news){
		try{
			if(newsService.creatnews(news)==1){
				return new Json(200,"创建成功",null);
			}else{
				return new Json(201,"创建失败请刷新后重试",null);
			}
		}catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	@RequestMapping(value="/delectnews",method=RequestMethod.POST)
	@ResponseBody
	public Json delectnews(@RequestParam int id){
		try{
			if(newsService.delectnews(id)==1){
				return new Json(200,"删除成功",null);
			}else{
				return new Json(201,"删除失败请刷新后重试",null);
			}
		}catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	

}
