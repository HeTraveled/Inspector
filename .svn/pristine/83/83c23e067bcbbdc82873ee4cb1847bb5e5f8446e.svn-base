package com.sys.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.sys.model.MessageRemind;
import com.sys.model.Messages;
import com.sys.service.MessageRemindService;
import com.sys.service.MessagesService;
import com.util.FilterRules;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("messageRemind")
public class MessageRemindController {
	
	@Autowired
	private MessagesService messagesService;
	@Autowired
	private MessageRemindService messageRemindService;
	
	/*
	 * 消息列表
	 */
	
	@RequestMapping("messageRemindList")
	@ResponseBody
	public DataGrid messageRemindList(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value = "filterRules", required = false) String filterRules,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			List<FilterRules> frs = new ArrayList<FilterRules>();
			if (filterRules != null) {
				JSONArray json = JSONArray.fromObject(filterRules);
				if (json.size() > 0) {
					for (int i = 0; i < json.size(); i++) {
						JSONObject job = json.getJSONObject(i);
						frs.add(new FilterRules((String) job.get("field"),
								(String) job.get("op"), (String) job.get("value")));
					}
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DataGrid datagrid=new DataGrid();
			User user=(User) request.getSession().getAttribute("user");
			Messages messages=new Messages();
			for (int i = 0; i < frs.size(); i++) {
				FilterRules fr = frs.get(i);
					if (fr.getField().equals("state"))
						if (fr.getValue() != null && !fr.getValue().equals(""))
							messages.setState(Integer.parseInt(fr.getValue()));
					if (fr.getField().equals("type"))
						if (fr.getValue() != null && !fr.getValue().equals(""))
							messages.setType(Integer.parseInt(fr.getValue()));
					if (fr.getField().equals("title"))
						if (fr.getValue() != null && !fr.getValue().equals(""))
							messages.setTitle(fr.getValue());
					if (fr.getField().equals("createTime"))
						if (fr.getValue() != null && !fr.getValue().equals(""))
							messages.setCreateTime(sdf.parse(fr.getValue()));
					if (fr.getField().equals("mrId"))
						if (fr.getValue() != null && !fr.getValue().equals(""))
							messages.setMrId(Integer.parseInt(fr.getValue()));
			}
			if (sort != null) {
				String[] newsort = sort.split(",");
				String[] neworder = order.split(",");
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < newsort.length; i++) {
					if (i == 0)
						sb.append(" order by ");
					if (newsort[i].equals("mrId"))
						newsort[i] = "id";
					if (newsort[i].equals("title"))
						newsort[i] = "title";
					if (newsort[i].equals("type"))
						newsort[i] = "type";
					if (newsort[i].equals("createTime"))
						newsort[i] = "reading_time";
					if (newsort[i].equals("state"))
						newsort[i] = "state";
					if (newsort[i].equals("state")||newsort[i].equals("mrId")||newsort[i].equals("reading_time")) {
						if (i == 0)
							sb.append("mr."+newsort[i] + " " + neworder[i]);
						else
							sb.append(",mr." + newsort[i] + " " + neworder[i]);
					}else {
						if (i == 0)
							sb.append("mes."+newsort[i] + " " + neworder[i]);
						else
							sb.append(",mes." + newsort[i] + " " + neworder[i]);
					}
				}
				messages.setOrderBy(sb.toString());
				}else
					messages.setOrderBy("order by mr.state asc,mr.reading_time desc");
			messages.setUid(user.getUid());
			PagedResult<Messages> pagedResult=messagesService.display(messages,page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	
	/*
	 * 个人消息入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(@RequestParam(value="state",required=false) Integer state,
			HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.addObject("state", state);
		User user=(User)request.getSession().getAttribute("user");
		mv.addObject("uid", user.getUid());
		mv.setViewName("sys/messageRemind");
		return mv;
	}
	/*
	 * 详情页
	 */
	@RequestMapping("messageRemindDetails")
	public ModelAndView messageRemindDetails(@RequestParam("id") Integer id,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		mv.addObject("message", messageRemindService.selectid(id,user.getUid()));
		mv.setViewName("sys/messageRemindDetails");
		return mv;
	}
	/**
	 * 单个未读改已读
	 */
	@RequestMapping(value="updateMessageRemind",method = RequestMethod.POST)
	@ResponseBody
	public Json updateMessageRemind(@RequestBody MessageRemind messageRemind,HttpServletRequest request){
		try {
			if(messageRemindService.update(messageRemind)==1)
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
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@RequestBody List<Integer> id,HttpServletRequest request){
		try {
			if(messageRemindService.deletes(id)!=0){
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
	/**
	 * 清空
	 */
	@RequestMapping(value="empty",method = RequestMethod.GET)
	@ResponseBody
	public Json empty(@RequestParam("uid") Integer uid,HttpServletRequest request){
		try {
			if(messageRemindService.empty(uid)==1){
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
	/**
	 * 多项标记已读
	 */
	@RequestMapping(value="batchflag",method = RequestMethod.POST)
	@ResponseBody
	public Json batchflag(@RequestBody List<Integer> id,HttpServletRequest request){
		try {
			if(messageRemindService.batchflag(id)!=0){
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);
		         return new Json(500,null,null);
		}
	}
}