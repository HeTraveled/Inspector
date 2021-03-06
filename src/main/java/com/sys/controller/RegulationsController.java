package com.sys.controller;

import java.io.File;
import java.util.ArrayList;
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
import com.sys.model.Attachments;
import com.sys.model.Regulations;
import com.sys.service.AttachmentsService;
import com.sys.service.RegulationsService;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("regulations")
public class RegulationsController {
	
	@Autowired
	private RegulationsService regulationsService;
	@Autowired
	private AttachmentsService attachmentsService;
	/*
	 * 制度表格列表
	 */
	
	@RequestMapping("regulationsList")
	@ResponseBody
	public DataGrid regulationsList(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			DataGrid datagrid=new DataGrid();
			User user=(User) request.getSession().getAttribute("user");
			Regulations regulations=new Regulations();
			if(user.getRid()==1)regulations.setState(null);
			else regulations.setState(1);
			PagedResult<Regulations> pagedResult=regulationsService.display(regulations,page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	/*
	 * 制度表格入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		ModelAndView mv=new ModelAndView();
		mv.addObject("role", user.getRid());
		mv.setViewName("sys/regulations");
		return mv;
	}
	/**
	 * 详情页
	 */
	@RequestMapping("regulationsDetails")
	public ModelAndView regulationsDetails(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("regulations",regulationsService.selectid(id));
		mv.addObject("files", attachmentsService.display(new Attachments(3,id)));
		mv.setViewName("sys/regulationsDetails");
		return mv;
	}
	/**
	 * 创建页
	 */
	@RequestMapping("createRegulationsPage")
	public ModelAndView createRegulationsPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/createRegulations");
		return mv;
	}
	/**
	 * 创建
	 */
	@RequestMapping("createRegulations")
	@ResponseBody
	public Json createRegulations(@RequestBody Regulations regulations,HttpServletRequest request){
		try {
			User user=(User)request.getSession().getAttribute("user");
			regulations.setCreateBy(user.getName());
			regulations.setCreateTime(new Date());
			Integer id=regulationsService.create(regulations);
			if(id!=null){
				if(regulations.getFiles().length!=0){
					List<Attachments> attachments=new ArrayList<Attachments>();
					for(int i=0;i<regulations.getFiles().length;i++)attachments.add(new Attachments(3,id,regulations.getFiles()[i]));
					//上传附件
					attachmentsService.creates(attachments);
				}
				return new Json(200,"操作成功！",null);
			}
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 修改页
	 */
	@RequestMapping("updateRegulationsPage")
	public ModelAndView updateRegulationsPage(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("regulations",regulationsService.selectid(id));
		mv.addObject("files", attachmentsService.display(new Attachments(3,id)));
		mv.setViewName("sys/updateRegulations");
		return mv;
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateRegulations")
	@ResponseBody
	public Json updateRegulations(@RequestBody Regulations regulations,HttpServletRequest request){
		try {
			if(regulationsService.update(regulations)==1){
				if(regulations.getFiles().length!=0){
					List<Attachments> attachments=new ArrayList<Attachments>();
					for(int i=0;i<regulations.getFiles().length;i++)attachments.add(new Attachments(3,regulations.getId(),regulations.getFiles()[i]));
					//上传附件
					attachmentsService.creates(attachments);
				}
				return new Json(200,"操作成功！",null);
			}
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
				if(regulationsService.delete(id)==1){
					return new Json(200,"操作成功！",null);
				}else
					return new Json(201,"操作失败！",null);
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
			 String path = request.getSession().getServletContext().getRealPath("/");
		     path=path.substring(0, path.indexOf("webapps"));
			if(regulationsService.deletes(id)!=0){
				//同时删除附件、文件
				for(int i=0;i<id.size();i++){
					List<Attachments> attachments=attachmentsService.display(new Attachments(3, id.get(i)));
					attachmentsService.delete(new Attachments(3, id.get(i)));
					if(attachments!=null&&attachments.size()!=0){
						for(int j=0;j<attachments.size();j++){
					//同时删除本地文件
					File file=new File(path+"webapps/InspectorImgs/files/"+attachments.get(j).getAttachment());
			         if(file.exists()&&file.isFile()){
			             file.delete();
			         }
						}
				}
				}
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
}