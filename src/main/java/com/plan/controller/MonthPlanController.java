package com.plan.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.plan.model.MonthPlan;
import com.plan.model.MonthPlanMessage;
import com.plan.model.MonthPlanNext;
import com.plan.service.MonthPlanMessageService;
import com.plan.service.MonthPlanNextService;
import com.plan.service.MonthPlanService;
import com.sys.model.MessageRemind;
import com.sys.model.Messages;
import com.sys.service.MessageRemindService;
import com.sys.service.MessagesService;
import com.util.Log;
import com.util.excel.ExcelUtil;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("month")
public class MonthPlanController {
	
	@Autowired
	private MonthPlanService monthplanService;
	@Autowired
	private MonthPlanNextService MonthPlanNextServie;
	@Autowired
	private DeptService deptService;
	@Autowired 
	private MonthPlanMessageService monthPlanMessageService;
	@Autowired
	private MessagesService messagesService;
	@Autowired
	private MessageRemindService messageRemindService;
	
	//新建月计划跳转
	@RequestMapping("creatmonthplan")
	public ModelAndView creatmonthplan(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		Calendar cal = Calendar.getInstance();
		Integer months = cal.get(Calendar.MONTH)+1;
		Integer years = cal.get(Calendar.YEAR);
		MonthPlan monthPlan = monthplanService.selectmonth(months, years,user.getUid());
		if(monthPlan!=null)
			mv.addObject("thismonth",MonthPlanNextServie.selectthismonthsplan(monthPlan.getMid()));
		
		mv.setViewName("plan/monthplan");
		return mv;
	}
	//更新下月计划跳转
			@RequestMapping("monthplannextskip")
			public ModelAndView monthplannextskip(int mid,HttpServletRequest request){
				ModelAndView mv=new ModelAndView();
				//计划下月计划表
				mv.addObject("monthnext", MonthPlanNextServie.selectthismonthsplan(mid));
				mv.setViewName("plan/monthplannextupdate");
				return mv;
			}
	//月计划列表跳转
	@RequestMapping("monthplanlist")
	public ModelAndView monthplanlist(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		
		User user=(User)request.getSession().getAttribute("user");
		Calendar cal = Calendar.getInstance();
		//上月，+1为本月
		Integer months = cal.get(Calendar.MONTH)+2;
		Integer months2 = cal.get(Calendar.MONTH)+1;
		Integer years = cal.get(Calendar.YEAR);
		Integer year = cal.get(Calendar.YEAR);
		 years=(months<=12?years:years+1);
		months=(months<=12?months:1);
		MonthPlan monthPlan = monthplanService.selectmonth(months, years,user.getUid());
		MonthPlan monthPlan2 = monthplanService.selectmonth(months2, year,user.getUid());
		
		if(monthPlan==null){
			mv.addObject("monthplan",1);
		}else{
			mv.addObject("monthplan",2);
		}
		  Dept dept=deptService.selectByPrimaryKey(user.getDid());
	      if(user.getUid()==dept.getPrincipal())
			mv.addObject("auditrole",1);
		if(monthPlan2!=null){
		
			mv.addObject("monthPlan2",1);
		}
		mv.setViewName("plan/monthsplanlist");
		return mv;
	}
	//详情单条计划删除
	@RequestMapping(value="monthplandelect",method=RequestMethod.POST)
	@ResponseBody
	public Json monthplandelect(int id){
		try{
			if(MonthPlanNextServie.monthplandelect(id)==1){
				return new Json(200,"提交成功",null);
			}
			return new Json(201,"失败",null);
		}catch(Exception e){
			 Log.getLogger().error(e.getMessage(),e);  
		      return new Json(500,null,null);
		}
	}
	//部门月计划列表跳转
		@RequestMapping("deptmonthplanPage")
		public ModelAndView deptmonthplanPage(int did,HttpServletRequest request){
			ModelAndView mv=new ModelAndView();
			
			request.getSession().setAttribute("did", did);
		
			mv.setViewName("plan/deptmonthsplan");
			return mv;
		}
	
	//本月工作
		@RequestMapping("thisplanlist")
		public ModelAndView planlist(HttpServletRequest request){
			ModelAndView mv=new ModelAndView();
			Calendar cal = Calendar.getInstance();
			//上月，+1为本月
			Integer months = cal.get(Calendar.MONTH)+1;
			Integer years = cal.get(Calendar.YEAR);
			User user=(User)request.getSession().getAttribute("user");
			years=(months<=12?years:years+1);
			months=(months<=12?months:1);
			MonthPlan monthPlan = monthplanService.selectmonth(months, years,user.getUid());
			
			mv.addObject("lastmonth", monthPlan);
			if(monthPlan!=null){
				List<MonthPlanNext> monthPlanNext=MonthPlanNextServie.selectthismonthsplan(monthPlan.getMid());
				if(monthPlanNext.size()!=0){
					//上月副表
					mv.addObject("lastmonthnext",monthPlanNext);
				
				}
			}
			
			
			mv.setViewName("plan/thismonthplan");
			return mv;
		}
	
	//月计划审核列表跳转
	@RequestMapping("monthplanaudit")
	public ModelAndView monthplanaudit(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("plan/monthplanaudit");
		return mv;
	}
	//月审核详情
	@RequestMapping("monthplanauditparticularPage")
	@ResponseBody
	public ModelAndView monthplanauditparticularPage(@Param("mid")int mid,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		
		Calendar cal = Calendar.getInstance();
		
		Integer months = cal.get(Calendar.MONTH)+1;
		
		Integer years = cal.get(Calendar.YEAR);
		Integer leader=(Integer) request.getSession().getAttribute("leader");
		User user=(User)request.getSession().getAttribute("user");
		//本月
		MonthPlan monthPlan1=monthplanService.selectthismonth(mid);
		
		MonthPlan monthPlan2 = monthplanService.selectmonth(months, years,monthPlan1.getUid());
		mv.addObject("lastmonth",monthPlan2);
		
		if(monthPlan2!= null){
			//月副表
			mv.addObject("lastmonthnext",MonthPlanNextServie.selectthismonthsplan(monthPlan2.getMid()));
		}
		mv.addObject("thismonth",monthPlan1);
		mv.addObject("nextmonth",MonthPlanNextServie.selectthismonthsplan(mid));
		mv.addObject("leader",leader);
		mv.addObject("userid",user.getUid());
		mv.setViewName("plan/monthsplanauditparticulars");
		return mv;
	}
	
	//月计划留言列表跳转
	@RequestMapping("monthplanmessageskip")
	public ModelAndView monthplanmessage(Integer mid,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		request.getSession().setAttribute("messagemid", mid);
		mv.setViewName("plan/monthsplanmessagelist");
		return mv;
	}
	//新建月计划
	@RequestMapping(value="creatmonthsplan",method=RequestMethod.POST)
	@ResponseBody
	public Json creatmonthsplan(@RequestBody MonthPlan monthPlan,HttpServletRequest request){
		try{
			if(monthPlan!=null){
			User user=(User)request.getSession().getAttribute("user");
			monthPlan.setUid(user.getUid());
			monthPlan.setCreateTime(new Date());
			monthPlan.setState(0);
		
			Calendar cal = Calendar.getInstance();
			Integer months = cal.get(Calendar.MONTH)+1;
			Integer years = cal.get(Calendar.YEAR);
			
			MonthPlan mp=monthplanService.selectmonth(months, years, user.getUid());
			//如果本月不为空，更新本月留言备注
			if(mp!=null){
				MonthPlan monthPlan2=new MonthPlan();
				monthPlan2.setConclusion(monthPlan.getConclusion());
				monthPlan2.setRemarks(monthPlan.getRemarks());
				monthPlan2.setMid(mp.getMid());
				monthplanService.updateplan(monthPlan2);
			}
			monthPlan.setConclusion(null);
			monthPlan.setRemarks(null);
			Integer a=monthplanService.creatMonthPlan(monthPlan);
			if(a!=null){
				for(int i=0;i<monthPlan.getMonthPlanNext().size();i++){
					monthPlan.getMonthPlanNext().get(i).setMid(a);
					monthPlan.getMonthPlanNext().get(i).setState(1);
				}
				if(
				MonthPlanNextServie.creatMonthPlanNext(monthPlan.getMonthPlanNext())!=null){
					return new Json(200,"提交成功",null);
				}
			}
		}
			return new Json(201,"提交失败",null);
			
		}catch(Exception e){
			 Log.getLogger().error(e.getMessage(),e);  
		      return new Json(500,null,null);
		}
		
	}
	
	//下月计划更新
			@RequestMapping(value="updatemonthplannext",method=RequestMethod.POST)
			@ResponseBody
			public Json updatemonthplannext(@RequestBody List<MonthPlanNext> monthPlanNext,HttpServletRequest request ){
				try{
		
					if(MonthPlanNextServie.creatMonthPlanNext(monthPlanNext)!=null){
				return new Json(200,"提交成功",null);
				}else{
					return new Json(201,"提交失败",null);
				}
				
				}catch(Exception e){
					 Log.getLogger().error(e.getMessage(),e);  
				      return new Json(500,null,null);
				}
			}
	/*//本月计划列表
		@RequestMapping("/monthslistPage")
		@ResponseBody
		public DataGrid weekslistPage(HttpServletRequest request){
			Calendar cal = Calendar.getInstance();
			int thismonth = cal.get(cal.MONTH+1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			 Calendar date = Calendar.getInstance();
		     String year = String.valueOf(date.get(Calendar.YEAR));
			DataGrid datagrid=new DataGrid();
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			 PagedResult<MonthPlanNext> pagedResult=MonthPlanNextServie.selectall(null,Integer.parseInt(page),Integer.parseInt(rows));
			 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 }
			 	return datagrid;
		}*/
		//部门列表
		@RequestMapping("/DeptlistPage")
		@ResponseBody
		public DataGrid DeptlistPage(HttpServletRequest request){
			DataGrid datagrid=new DataGrid();
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			User user=(User)request.getSession().getAttribute("user");
			 User user2=monthplanService.selectrole(user.getUid());
			if(user.getRid()==1||user2!=null){
			 PagedResult<Dept> pagedResult=deptService.selectname(null,Integer.parseInt(page),Integer.parseInt(rows));
			 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 }
			}else{
				PagedResult<Dept> pagedResult=deptService.select(user.getDid(),Integer.parseInt(page),Integer.parseInt(rows));
				 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
					 datagrid.setTotal(pagedResult.getTotal());
					 datagrid.setRows(pagedResult.getDataList());
				 }
			}
			 	return datagrid;
		}
		//部门月计划列表
		@RequestMapping("/deptmonthplan")
		@ResponseBody
		public DataGrid deptmonthplan(HttpServletRequest request){
			DataGrid datagrid=new DataGrid();
			Calendar cal = Calendar.getInstance();
			Integer month = cal.get(Calendar.MONTH)+1;
			Integer years = cal.get(Calendar.YEAR);
			Integer did=(Integer) request.getSession().getAttribute("did");
		   String page=request.getParameter("page");
			String rows=request.getParameter("rows");	
			
			PagedResult<MonthPlan> pagedResult=monthplanService.deptmonthplan(did, years, month,Integer.parseInt(page),Integer.parseInt(rows));
			 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 }
			 return datagrid;
		}
		//部门月计划列表详情
		@RequestMapping("/deptmonthplanparticular")
		@ResponseBody
		public ModelAndView deptmonthplanparticular(@Param("mid")int mid,HttpServletRequest request){
			ModelAndView mv=new ModelAndView();
			Calendar cal = Calendar.getInstance();
			Integer months = cal.get(Calendar.MONTH)+2;
			Integer years = cal.get(Calendar.YEAR);
			years=(months<=12?years:years+1);
			months=(months<=12?months:1);
			User user=(User)request.getSession().getAttribute("user");
			mv.addObject("userid", user.getUid());
			mv.addObject("power", user.getRid());
			MonthPlan montPlan=monthplanService.selectthismonth(mid);
			//本月主表
			mv.addObject("thismonth",montPlan);
			//本月
			mv.addObject("nextmonth",MonthPlanNextServie.selectthismonthsplan(mid));
			//下月主表
			MonthPlan monthPlan = monthplanService.selectmonth(months, years,montPlan.getUid());
			mv.addObject("lastmonth",monthPlan);
			if(monthPlan!= null){
				//下月副表
				mv.addObject("lastmonthnext",MonthPlanNextServie.selectthismonthsplan(monthPlan.getMid()));
			}
			mv.addObject("message",monthPlanMessageService.selectMessage(mid));
			mv.setViewName("plan/monthsplanparticulars");
			return mv;
		}
		//完成状态
		@RequestMapping(value="/monthplannextupdate",method=RequestMethod.POST)
		@ResponseBody
		public Json monthplannextupdate(@Param("id")int id,String remarks){
			try{
			
				if(MonthPlanNextServie.updatestate(id,remarks)==1){
					 return new Json(200,"修改成功",null);
				}
				 return new Json(201,"修改失败",null);
			}catch(Exception e){
				 Log.getLogger().error(e.getMessage(),e);  
			      return new Json(500,null,null);
			}
		}
		//留言
		@RequestMapping(value="creatmonthplanmessage",method=RequestMethod.POST)
		@ResponseBody
		public Json creatmonthplanmessage( MonthPlanMessage monthPlanMessage,HttpServletRequest request){
			try{
				User user=(User)request.getSession().getAttribute("user");
				monthPlanMessage.setCreateBy(user.getName());
				if(monthPlanMessage.getMessage()!=null)
				monthPlanMessage.setCreateTime(new Date());
				if(monthPlanMessageService.creatMessage(monthPlanMessage)==1){
					 return new Json(200,"修改成功",null);
				}
				 return new Json(201,"修改失败",null);
			}catch(Exception e){
				 Log.getLogger().error(e.getMessage(),e);  
			      return new Json(500,null,null);
			}
		}
		//审核和分数
			@RequestMapping(value="updatemyScore",method=RequestMethod.POST)
			@ResponseBody
			public Json updatemyScore( @Param("myScore")BigDecimal myScore,@Param("mid")Integer mid,HttpServletRequest request){
				try{
					if(myScore!=null){
						MonthPlan monthp=monthplanService.selectthismonth(mid);
						MonthPlan monthPlan=new MonthPlan();
					
						monthPlan.setMid(mid);
					
						if(monthp.getState()==0)
							monthPlan.setState(1);
						
						if(monthplanService.updateScore(monthPlan)==1){
							 return new Json(200,"审核成功",null);
						}else{
							return new Json(201,"审核失败",null);
						}
						}
					return new Json(201,"审核失败",null);
				}catch(Exception e){
				Log.getLogger().error(e.getMessage(),e);  
			      return new Json(500,null,null);
			} 
			}
		
		@RequestMapping("/monthplanmessagelist")
		@ResponseBody
		public DataGrid monthplanmessagelist(HttpServletRequest request){
			DataGrid datagrid=new DataGrid();
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			Integer mid=(Integer) request.getSession().getAttribute("messagemid");
			 PagedResult<MonthPlanMessage> pagedResult=monthPlanMessageService.selectall(mid,Integer.parseInt(page),Integer.parseInt(rows));
			 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
					 }
					return datagrid;
				}
		//多身份月审核列表显示
		@RequestMapping("/monthplanauditlist")
		@ResponseBody
		public DataGrid monthplanauditlist(HttpServletRequest request){
			DataGrid datagrid=new DataGrid();
			Calendar cal = Calendar.getInstance();
			Integer years = cal.get(Calendar.YEAR);
			Integer month = cal.get(Calendar.MONTH)+2;

			
			years=(month<=12?years:years+1);
			month=(month<=12?month:1);

			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			User user=(User)request.getSession().getAttribute("user");
			PagedResult<MonthPlan> pagedResult=monthplanService.monthplanaudit(user.getDid(),years,month,Integer.parseInt(page),Integer.parseInt(rows));
			 if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
				 request.getSession().setAttribute("leader", 100);
					 }
		
				return datagrid;
				}
		//留言实时消息显示
		@RequestMapping(value="creatleaveamessage",method=RequestMethod.POST)
		@ResponseBody
		public Json creatleaveamessage( @RequestParam("mid") Integer mid,@RequestParam("flag") Integer flag,HttpServletRequest request){
			try{
			
				String body ="";
				if(flag==1)body="发起";
				else if(flag==2)body="修改";
				else if(flag==3)body="留言";
				User user=(User)request.getSession().getAttribute("user");
				
				MonthPlan monthPlan=monthplanService.selectthismonth(mid);
				if(monthPlan.getUid()!=user.getUid()){
				Integer messageid=messagesService.create(
						new Messages(user.getName()+body+"了"+monthPlan.getName()+monthPlan.getYears()+"年的第"+
				monthPlan.getMonths()+"月计划",5,mid));
				if(messageid!=0){
					List<MessageRemind> mrs=new ArrayList<MessageRemind>();
					Date date=new Date();
					
							MessageRemind mr=new MessageRemind();
							mr.setMid(messageid);
							mr.setState(0);
							mr.setUid(monthPlan.getUid());
							mr.setReadingTime(date);
							mrs.add(mr);
							//同时推送模板消息
					if(messageRemindService.creates(mrs)!=0){
						return new Json(200,"操作成功！",null);
					}else return new Json(201,"操作失败！",null);
				}
				else return new Json(201,"操作失败！",null);
				}else{
					return new Json(200,"操作成功！",null);
				}
			}catch(Exception e){
				 Log.getLogger().error(e.getMessage(),e);  
			      return new Json(500,null,null);
			}
		}
		
		
			//导出Excel
		@RequestMapping("downExcel")
		public String downExcel( HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			String fileName = "月度工作计划表";
			Calendar cal = Calendar.getInstance();
			Integer months = cal.get(Calendar.MONTH)+1;
			Integer years = cal.get(Calendar.YEAR);
			User user = (User) request.getSession().getAttribute("user");
			Dept dept=deptService.selectByPrimaryKey(user.getDid());
			// 填充projects数据
			MonthPlan monthPlan=monthplanService.selectmonth(months, years,user.getUid());
			List<MonthPlanNext> projects = MonthPlanNextServie.selectthismonthsplan(monthPlan.getMid());
			List<Map<String, Object>> list = createExcelRecord(projects,request);
			String columnNames[] = {"类别", "工作任务内容", "预计完成时间", "预期目标效果",
					"设定分值", "完成情况说明", "部门负责人评分", "分管集团领导审核" };// 列名
			String keys[] = { "sort", "planbody", "time", "target", "score",
					"state", "principalsocre", "leadersocre" };// map中的key
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			
			MonthPlan monthPlan2 =new MonthPlan();
			monthPlan2.setName(user.getName());
			monthPlan2.setMonths(months);
			monthPlan2.setYears(years);
			monthPlan2.setDepartmentname(dept.getDepartmentname());
			
			
			try {
				ExcelUtil.createWorkBook(list, keys, columnNames,monthPlan2).write(os);
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} catch (final IOException e) {
				throw e;
			} finally {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			}
			return null;
		}

		

		private List<Map<String, Object>> createExcelRecord(List<MonthPlanNext> projects,HttpServletRequest request) {
			List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("sheetName", "sheet1");
			listmap.add(map);
			MonthPlanNext project = null;
			//插入数据
			for (int j = 0; j < projects.size(); j++) {
				project = projects.get(j);
				Map<String, Object> mapValue = new HashMap<String, Object>();
				
				mapValue.put("sort", null);
				mapValue.put("planbody", project.getBody());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
				mapValue.put("time",sdf.format(project.getEndTime()) );
				mapValue.put("target", project.getRemarks());
				mapValue.put("score", null);
				if(project.getState()==1)
					mapValue.put("state", "进行中");
				if(project.getState()==2)
					mapValue.put("state", "未完成");
				if(project.getState()==3)
					mapValue.put("state", "完成");
				mapValue.put("principalsocre",null);
				mapValue.put("leadersocre",null);
				
				listmap.add(mapValue);
			}
			return listmap;
		}
}