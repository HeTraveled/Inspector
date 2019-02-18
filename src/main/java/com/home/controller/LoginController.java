package com.home.controller;

import java.io.File;







import java.io.PrintWriter;
import java.net.URLDecoder;

import java.util.Date;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.io.FileUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.WebSocketSession;

import springfox.documentation.annotations.ApiIgnore;


import com.dept.model.Dept;
import com.dept.service.DeptService;
import com.home.model.Announcement;
import com.home.model.AnnouncementState;
import com.home.model.Menu;
import com.home.model.User;
import com.home.service.AnnouncementServer;
import com.home.service.AnnouncementStateService;
import com.home.service.MenuService;
import com.home.service.UserService;
import com.inspector.model.Inspector;
import com.inspector.service.InspectorService;
import com.plan.model.MonthPlan;
import com.plan.model.MonthPlanNext;
import com.plan.model.WeeksPlan;
import com.plan.model.YearPlan;
import com.plan.service.MonthPlanNextService;
import com.plan.service.MonthPlanService;
import com.plan.service.WeeksPlanService;
import com.plan.service.YearPlanService;
import com.sys.model.Attachments;
import com.sys.service.AttachmentsService;
import com.sys.service.HornService;
import com.sys.service.MessageRemindService;
import com.sys.service.NewsService;
import com.sys.service.PropellingService;
import com.sys.service.RegulationsService;
import com.util.CompressPicDemo;
import com.util.HTMLSpirit;
import com.util.Log;
import com.util.MD5;
import com.util.json.Json;
import com.util.login.MemoryData;
import com.util.page.PagedResult;
import com.util.websocket.MyWebSocketHandler;

@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("home")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private InspectorService inspectorService;
	@Autowired
	private AnnouncementServer announcementService;
	@Autowired
	private RegulationsService regulationsService;
	@Autowired
	private HornService hornService;
	@Autowired
	private MessageRemindService messageRemindService;
	@Autowired
	private PropellingService propellingService;
	@Autowired
	private MonthPlanService monthPlanService;
	@Autowired
	private MonthPlanNextService monthPlanNextService;
	@Autowired
	private YearPlanService yearPlanService;
	@Autowired
	private WeeksPlanService weeksPlanService;
	@Autowired
	private AttachmentsService attachmentsService;
	@Autowired 
	private AnnouncementStateService announcementStateService;
	@Autowired 
	private NewsService newsService;
	
	
	/**
	 * 首页加载
	 */
	@RequestMapping("index")
	public ModelAndView Index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		// 判断session用户是否已经登录
		if (user != null) {
			//显示菜单
			List<Menu> menu=menuService.selectall();
			if(menu!=null&&menu.size()!=0){
				for(int i=0;i<menu.size();i++){
					Menu m=menu.get(i);
						for(int j=0;j<m.getMenu().size();j++){
							Menu m2=m.getMenu().get(j);
							if(m2.getName().equals("新建督查事项")&&user.getRid()!=1)m.getMenu().remove(j);
							if(m2.getName().equals("账号管理")&&user.getRid()!=1)m.getMenu().remove(j);
//							if(m2.getName().equals("微信消息推送")&&user.getRid()!=1)m.getMenu().remove(j);
//							if(m2.getName().equals("微信文字标语")&&user.getRid()!=1)m.getMenu().remove(j);
						}
						if(m.getName().equals("系统管理")&&user.getRid()!=1){
							m.getMenu().remove(4);
							m.getMenu().remove(3);
							m.getMenu().remove(2);

						}
				}
			}
			mv.addObject("menu",menu);
			//小喇叭推送 24小时内消息有效
		//	mv.addObject("horn", hornService.select24H());
			//重新加载最新登录用户信息
			mv.addObject("u", userService.selectuid(user.getUid()));
			//用户未读信息条数
			mv.addObject("message", messageRemindService.unreadNum(user.getUid()));
			//系统消息个数
			mv.addObject("dialogNum", messageRemindService.selectNum(user.getUid()));
			mv.addObject("prompt", userService.selectuid(user.getUid()).getPrompt());
			mv.setViewName("home/index");
		} else{
			mv.setViewName("home/login");
		}
		return mv;
	}
	/**
	 * 右侧页加载
	 */

	@RequestMapping(value="desktop",method = RequestMethod.GET)

	public ModelAndView right(@RequestParam(value="pageNo",required=false) Integer pageNo,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		Calendar cal = Calendar.getInstance();
		//上月，+1为本月
		Integer months = cal.get(Calendar.MONTH)+1;
		Integer years = cal.get(Calendar.YEAR);
		int thisweek = cal.get(Calendar.WEEK_OF_YEAR);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		Inspector inspector=new Inspector();
		Integer did=null;
		//不等于督查员身份，查询所属部门督查事项
		if(user.getRid()!=1){
			did=user.getDid();
		//如果是部门负责人 
		//查询是否一人管理多部门
		if(deptService.countPri(user.getUid())>1){
			did=null;
			StringBuffer sb=new StringBuffer();
			List<Dept> dept=deptService.principal(user.getUid());
			//	sb.append(" and ins.state!=1 and ins.state!=3 and ins.state!=5  and (");
			sb.append("  and (");
			for(int i=0;i<dept.size();i++){
				if(i==0)sb.append("ins.responsibility="+dept.get(i).getId()+" or  FIND_IN_SET("+dept.get(i).getId()+",ins.assist_dept)");
				else sb.append(" or ins.responsibility="+dept.get(i).getId()+" or  FIND_IN_SET("+dept.get(i).getId()+",ins.assist_dept) ");
			}
			sb.append(")");
			inspector.setMuchdept(sb.toString());
		}
		}
		if(user.getDid()==100001||user.getRid()==1)did=null;
		inspector.setDid(did);
		//制度表格个数
		//mv.addObject("regulationsNum", regulationsService.regulationNum());
		//head begin
		//进行中的督查事项
		mv.addObject("progressNum", inspectorService.progressNum(inspector));
		//已过期的督查事项
		mv.addObject("expireNum", inspectorService.expireNum(inspector));
		//head end
		//督查事项 begin
		PagedResult<Inspector> pagedResult=inspectorService.homePage(inspector,pageNo,5);
		if(pageNo!=null&&pageNo<1)pageNo=1;
		if(pageNo!=null&&pageNo>pagedResult.getPages())pageNo=(int) pagedResult.getPages();
		if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0)for(int i=0;i<pagedResult.getDataList().size();i++)
			pagedResult.getDataList().get(i).setRequirements(HTMLSpirit.delHTMLTag(pagedResult.getDataList().get(i).getRequirements()));
		mv.addObject("inspectors", pagedResult);
		//督查事项 end
		//通知公告
		mv.addObject("annc", annclist(user));
		mv.addObject("uid", user.getUid());
		/*//本月工作
		MonthPlan monthPlan=monthPlanService.selectmonth(months, years, user.getUid());
		if(monthPlan!=null){
		List<MonthPlanNext> monthPlanNext=monthPlanNextService.selectthismonthsplan(monthPlan.getMid());
		mv.addObject("plansize",monthPlanNext.size());
	}
		//年计划
		YearPlan yearPlan=yearPlanService.selectlastyear(years);
		mv.addObject("yearplan",yearPlan);
		//月计划
		mv.addObject("monthplan",monthPlan);
		//周计划
		WeeksPlan weeksPlan=weeksPlanService.selectweekdept(user.getDid(), years, thisweek);
		mv.addObject("weekplan",weeksPlan);*/
		//新闻简讯
		mv.addObject("news", newsService.selectfive());
		//待办事项数量
		List<AnnouncementState> announcementState=announcementStateService.selectsize(user.getUid());
		mv.addObject("announcementstate", announcementState.size());
		mv.setViewName("home/desktop");
		return mv;
	}
	/**
	 * 督查事项加载
	 */
	@RequestMapping(value = "insPage", method = RequestMethod.GET)
	@ResponseBody
	public Json insPage(HttpServletRequest request, @RequestParam(value="pageNo",required=false) Integer pageNo)
			throws Exception {
		try {
			User user=(User)request.getSession().getAttribute("user");
			Inspector inspector=new Inspector();
			Integer did=null;
			//不等于督查员身份，查询所属部门督查事项
			if(user.getRid()!=1){
				did=user.getDid();
			//如果是部门负责人 
			//查询是否一人管理多部门
			if(deptService.countPri(user.getUid())>1){
				did=null;
				StringBuffer sb=new StringBuffer();
				List<Dept> dept=deptService.principal(user.getUid());
				//	sb.append(" and ins.state!=1 and ins.state!=3 and ins.state!=5  and (");
				sb.append("  and (");
				for(int i=0;i<dept.size();i++){
					if(i==0)sb.append("ins.responsibility="+dept.get(i).getId()+" or  FIND_IN_SET("+dept.get(i).getId()+",ins.assist_dept)");
					else sb.append(" or ins.responsibility="+dept.get(i).getId()+" or  FIND_IN_SET("+dept.get(i).getId()+",ins.assist_dept) ");
				}
				sb.append(")");
				inspector.setMuchdept(sb.toString());
			}
			}
			if(user.getDid()==100001||user.getRid()==1)did=null;
			inspector.setDid(did);
			//督查事项 begin
			PagedResult<Inspector> pagedResult=inspectorService.homePage(inspector,pageNo,5);
			if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0)for(int i=0;i<pagedResult.getDataList().size();i++)
				pagedResult.getDataList().get(i).setRequirements(HTMLSpirit.delHTMLTag(pagedResult.getDataList().get(i).getRequirements()));
			//督查事项 end
		 return new Json(200,null,pagedResult);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 	小喇叭加载
	 */
	 @RequestMapping("horn")
	    public ModelAndView horn(HttpServletRequest request) {
		 ModelAndView mv=new ModelAndView();
		//小喇叭推送 24小时内消息有效
			mv.addObject("horn", hornService.select24H());
		 mv.setViewName("home/horn");
		return mv;
	 }
		/**
		 * 	系统消息加载
		 */
		 @RequestMapping("dialog")
		    public ModelAndView dialog(HttpServletRequest request) {
			 ModelAndView mv=new ModelAndView();
			//显示最新五条未读消息
			 User user=(User)request.getSession().getAttribute("user");
				mv.addObject("dialog",messageRemindService.selectTop5(user.getUid()));
			 mv.setViewName("home/dialog");
			return mv;
		 }
	/**
	 * 个人资料设置页
	 */
	@RequestMapping("info")
	public ModelAndView info(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User user=(User) request.getSession().getAttribute("user");
		//查询所有部门
		//mv.addObject("dept",deptService.all());
		User use=userService.selectuid(user.getUid());
		String birth=null;
		if (use.getBirth() != null)
			birth =use.getBirth().toLocaleString().split(" ")[0];
//		if(use.getRid()==1){
//			Date PropellingTime=propellingService.selectid().getPropellingTime();
//			StringBuffer sb=new StringBuffer();
//			sb.append(PropellingTime.getHours());
//			sb.append(":");
//			sb.append(PropellingTime.getMinutes());
//			mv.addObject("propelling", sb.toString());
//		}
		mv.addObject("deptname", deptService.selectByPrimaryKey(use.getDid()).getDepartmentname());
		mv.addObject("birth", birth);
		mv.addObject("use",use);
		mv.setViewName("home/info");
		return mv;
	}
	/**
	 * session
	 */
	@RequestMapping(value = "session", method = RequestMethod.GET)
	@ResponseBody
	public Json session(HttpServletRequest request)
			throws Exception {
		try {
			User user=(User)request.getSession().getAttribute("user");
			if(user!=null) return new Json(200,null,null);
			else return new Json(201,null,null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 消息条数
	 */
	@RequestMapping(value = "dialogNum", method = RequestMethod.GET)
	@ResponseBody
	public Json dialogNum(HttpServletRequest request)
			throws Exception {
		try {
			User user=(User)request.getSession().getAttribute("user");
			return new Json(200,null,messageRemindService.unreadNum(user.getUid()));
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 当前在线人数
	 */
	@RequestMapping(value = "peopleNum", method = RequestMethod.GET)
	@ResponseBody
	public Json peopleNum(HttpServletRequest request)
			throws Exception {
		try {
			int num=0;
			new MyWebSocketHandler();
			List<WebSocketSession> users=MyWebSocketHandler.getUsers();
			if(users!=null&&users.size()!=0)num=users.size();
			return new Json(200,null,num);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 个人资料修改
	 */
	@RequestMapping(value = "updateInfo", method = RequestMethod.POST)
	@ResponseBody
	public Json updateInfo(@RequestBody User user,HttpServletRequest request)
			throws Exception {
		try {
			if(userService.update(user)==1){
			return new Json(200,"保存成功！",null);
			}else return new Json(201,"保存失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 推送时间修改
	 */
	@RequestMapping(value = "updatePropelling", method = RequestMethod.GET)
	@ResponseBody
	public Json updatePropelling(@RequestParam("protime") String protime,HttpServletRequest request)
			throws Exception {
		try {
			if(propellingService.update(protime)==1){
			return new Json(200,"保存成功！",null);
			}else return new Json(201,"保存失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Json Login(@RequestParam("username") String username,
			@RequestParam("password") String password,HttpServletRequest request)
			throws Exception {
		try {
			User user = userService.login(new User(username,
					new MD5().getMD5ofStr(URLDecoder.decode(password,"utf-8"))));
			
			if (user != null) {
				if(user.getState()==1){
				//3在sessionIDMap中存放此用户sessionID
			String sessionID = request.getRequestedSessionId();
			String name = user.getName();
			if (!MemoryData.getSessionIDMap().containsKey(name)) { //不存在，首次登陆，放入Map
			MemoryData.getSessionIDMap().put(name, sessionID);
				}else if(MemoryData.getSessionIDMap().containsKey(name)&&!StringUtils.equals(sessionID, MemoryData.getSessionIDMap().get(name))){
					MemoryData.getSessionIDMap().remove(name);
					MemoryData.getSessionIDMap().put(name, sessionID);
			}
			request.getSession().setAttribute("user", user);
			return new Json(200,"登录成功！",null);
			}else if(user.getState()==2){
				return new Json(234,"您的账号正在审核中,有疑问请联系管理员！",null);
			}
				else{
				return new Json(233,"您的账号已被暂停使用,有疑问请联系管理员！",null);
			}

		}else{
				return new Json(222,"用户名或密码错误！",null);
			}
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 用户注销
	 */
	@RequestMapping("off")
	public ModelAndView off(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		request.getSession().invalidate();
		MemoryData.getSessionIDMap().remove(user.getName());
		return new ModelAndView("redirect:index");
	}
	/**
	 * 用户登录页
	 */
	@RequestMapping("loginPage")
	public ModelAndView loginPage(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
			if(request.getParameter("isflag")!=null)mv.addObject("comp","您的账号当前在其他设备上登录<br>如非本人操作,请及时修改账号密码谨防被盗！");
		mv.setViewName("home/login");
		return mv;
	}
	/**
	 * 修改密码页
	 */
	@RequestMapping("updatePwd")
	public ModelAndView updatePwd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/updatePwd");
		return mv;
	}
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "updatepwd", method = RequestMethod.POST)
	@ResponseBody
	public Json updatepwd(@RequestParam("oldpwd") String oldpwd,@RequestParam("newpwd") String newpwd,
			@RequestParam("uid") Integer uid,HttpServletRequest request)
			throws Exception {
			try {
				//先判断原密码是否正确
				if(userService.selectuid(uid).getPassword().
						equals(new MD5().getMD5ofStr(URLDecoder.decode(oldpwd,"utf-8")))){
					if(userService.updatepwd(String.valueOf(uid) ,
							new MD5().getMD5ofStr(URLDecoder.decode(newpwd,"utf-8")))==1){
						return new Json(200,"修改成功！",null);
					}else{
						return new Json(202,"修改失败！",null);
					}
				}else{
					return new Json(201,"原密码错误！",null);
				}
			} catch (Exception e) {
				  Log.getLogger().error(e.getMessage(),e);  
			         return new Json(500,null,null);
			}
	}
	/**
	 * 找回密码页
	 */
	@RequestMapping("retrievePwd")
	public ModelAndView retrievePwd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/retrievePwd");
		return mv;
	}
	
	/**
	 * 头像上传
	 */
 @RequestMapping(value="headImg",method = RequestMethod.POST)  
 public void headImg(@RequestParam(value = "file", required = false) MultipartFile file,
		 HttpServletRequest request,HttpServletResponse response) throws Exception {  
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
     String path = request.getSession().getServletContext().getRealPath("/");
     path=path.substring(0, path.indexOf("webapps"));
     String fileName = file.getOriginalFilename();
     String fileNameStr = (new Date().getTime())+"__"+fileName;
     File targetFile = new File(path+"webapps/InspectorImgs/headImg", fileNameStr);
     if(!targetFile.exists()){  
         targetFile.mkdirs();  
     }
     //保存  
     try {  
         file.transferTo(targetFile);
       CompressPicDemo.getCompressPicDemo();
		//等比例压缩
         CompressPicDemo.compressPic(targetFile, 150.0, 150.0);
     } catch (Exception e) {  
         Log.getLogger().error(e.getMessage(),e);  
     }
     writer.print("InspectorImgs/headImg/"+fileNameStr);
		writer.flush();
		writer.close();
 }
 /**
	 * 多文件上传
	 */
@RequestMapping("uploadPic")  
@ApiIgnore
@ResponseBody  
public Json uploadPic(@RequestParam(value = "file", required = false) MultipartFile file,
		 HttpServletRequest request,HttpServletResponse response) throws Exception {  
	 try {
		 String path = request.getSession().getServletContext().getRealPath("/");
	     path=path.substring(0, path.indexOf("webapps"));
	     String fileName = file.getOriginalFilename(); 
	     String fileNameStr =fileName; 
	     File targetFile = new File(path+"webapps/InspectorImgs/files", fileNameStr);  
	     if(!targetFile.exists()){  
	         targetFile.mkdirs();
	     }  
	         file.transferTo(targetFile);
	         return new Json(200,"上传成功！",fileNameStr);
	} catch (Exception e) {
		Log.getLogger().error(e.getMessage(), e);
	      return new Json(500,null,null);
	}
} 
/**
 * 删除文件
 */
@RequestMapping(value = "delfile", method = RequestMethod.GET)
@ResponseBody
public Json delfile(@RequestParam("id") Integer id,HttpServletRequest request)
		throws Exception {
		try {
			Attachments attachments=attachmentsService.selectid(id);
				if(attachmentsService.delete(id)==1){
					//同时删除本地文件
					 String path = request.getSession().getServletContext().getRealPath("/");
				     path=path.substring(0, path.indexOf("webapps"));
					File file=new File(path+"webapps/InspectorImgs/files/"+attachments.getAttachment());
			         if(file.exists()&&file.isFile()){
			             file.delete();
			         }
					return new Json(200,"删除成功！",null);
			}else{
				return new Json(201,"删除失败！",null);
		}
		}catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
}
/**
 * 附件下载(公共)
 */
@RequestMapping(value="download")
public ResponseEntity<byte[]> download(@RequestParam("filename") String filename,HttpServletRequest request,
		Model model)throws Exception {
   //下载文件路径
	String path = request.getSession().getServletContext().getRealPath("/");
    path=path.substring(0, path.indexOf("webapps"));
   File file = new File(path+"webapps/InspectorImgs/files", filename);
   HttpHeaders headers = new HttpHeaders();  
   //下载显示的文件名，解决中文名称乱码问题  
   String downlaodFilename = new String(filename.getBytes("utf-8"), "ISO8859-1");
   //通知浏览器以attachment（下载方式）打开
   headers.setContentDispositionFormData("attachment", downlaodFilename); 
   //application/octet-stream ： 二进制流数据（最常见的文件下载）。
   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
   return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
           headers, HttpStatus.OK);
}
/**
	 * 百度富文本图片上传(公共)
	 */
@RequestMapping(value="UmeditorFile")  
		public ModelAndView UmeditorFile() {  
				return new ModelAndView("umeditor/imageUp");
}
//主页通知公告
@RequestMapping("/annclist")
@ResponseBody
public List<Announcement> annclist(@RequestBody User user){
	try{
	/*if(user.getRid()==1){
		List<Announcement> annc=announcementService.select3();
		return annc;
	}else{*/
	List<Announcement> annc=announcementService.select2(user.getUid());
	return annc;
	/*}*/
	}catch(Exception e){
		 Log.getLogger().error(e.getMessage(),e);  
		 return null; 
	}
		
}
}