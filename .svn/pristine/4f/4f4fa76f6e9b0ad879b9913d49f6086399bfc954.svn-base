package com.schedule.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.home.service.UserService;
import com.schedule.model.Events;
import com.schedule.model.Schedule;
import com.schedule.service.ScheduleService;
import com.util.Log;
import com.util.json.Json;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("schedule")
public class ScheduleController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ScheduleService scheduleService;
	/*
	 * 日程入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		List<User> users=new ArrayList<User>();
		users.add(user);
	//	mv.addObject("dept", userService.selectdid(user.getDid()));
		mv.addObject("dept", users);
		mv.addObject("u",user);
		mv.setViewName("schedule/schedule");
		return mv;
	}
	/**
	 * 修改个人日程页
	 */
	@RequestMapping("updateSchedulePage")
	public ModelAndView updateSchedulePage(@RequestParam("sid") Integer sid,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Schedule schedule=scheduleService.selectid(sid);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mv.addObject("startTime", sdf.format(schedule.getStartTime()));
		mv.addObject("endTime", sdf.format(schedule.getEndTime()));
		mv.addObject("schedule", schedule);
		mv.setViewName("schedule/update");
		return mv;
	}
	/**
	 *修改个人日程
	 */
	@RequestMapping(value="updateSchedule",method = RequestMethod.POST)
	@ResponseBody
	public Json updateSchedule(@RequestBody Schedule schedule,HttpServletRequest request){
		try {
				if(scheduleService.update(schedule)==1){
					return new Json(200,"操作成功！",null);
				}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 新建个人日程页
	 */
	@RequestMapping("createSchedulePage")
	public ModelAndView createSchedulePage(@RequestParam(value="date",required=false)@DateTimeFormat(pattern="yyyy-MM-dd") Date date,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(date!=null)mv.addObject("startTime", date);
		mv.setViewName("schedule/create");
		return mv;
	}
	/**
	 *添加日程
	 */
	@RequestMapping(value="createSchedule",method = RequestMethod.POST)
	@ResponseBody
	public Json createSchedule(@RequestBody Schedule schedule,HttpServletRequest request){
		try {
			schedule.setSource(1);//个人添加
			User user=(User)request.getSession().getAttribute("user");
			schedule.setUid(user.getUid());
			if(scheduleService.create(schedule)!=0){
					return new Json(200,"操作成功！",null);
				}else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 *日程数据
	 */
	@RequestMapping(value="scheduleData",method = RequestMethod.GET)
	@ResponseBody
	public Json scheduleData(@RequestParam("uid") Integer uid,HttpServletRequest request){
		try {
			List<Schedule> schedules=scheduleService.selectMonth(uid);
			List<Events> events=new ArrayList<Events>();
			if(schedules!=null&&schedules.size()!=0){
				for(int i=0;i<schedules.size();i++){
					Schedule s=schedules.get(i);
					if(s.getSource()==1)events.add(new Events(s.getSid(),s.getBody(),s.getStartTime(),s.getEndTime(),"#FF7256"));
					else events.add(new Events(s.getSid(),s.getBody(),s.getStartTime(),s.getEndTime(),"#6CA6CD"));
				}
			}
				return new Json(200,null,events);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/** 
     * 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML , 
     * @return String 
     */  
public static String getRandColorCode(){  
  String r,g,b;  
  Random random = new Random();  
  r = Integer.toHexString(random.nextInt(256)).toUpperCase();  
  g = Integer.toHexString(random.nextInt(256)).toUpperCase();  
  b = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    
  r = r.length()==1 ? "0" + r : r ;  
  g = g.length()==1 ? "0" + g : g ;  
  b = b.length()==1 ? "0" + b : b ;  
    
  return r+g+b;  
 }
/**
 *	删除日程
 */
@RequestMapping(value="delete",method = RequestMethod.GET)
@ResponseBody
public Json delete(@RequestParam("sid") Integer sid,HttpServletRequest request){
	try {
			if(scheduleService.delete(sid)==1){
				return new Json(200,"操作成功！",null);
			}else return new Json(201,"操作失败！",null);
	} catch (Exception e) {
		  Log.getLogger().error(e.getMessage(),e);  
	         return new Json(500,null,null);
	}
}
}