package com.inspector.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dept.model.Dept;
import com.dept.service.DeptService;
import com.dept.service.EmergencyService;
import com.home.model.Score;
import com.home.model.User;
import com.home.service.ScoreService;
import com.home.service.UserService;
import com.inspector.model.AssistDeptTree;
import com.inspector.model.Inspector;
import com.inspector.model.InspectorMessage;
import com.inspector.model.InspectorName;
import com.inspector.model.InspectorOpinion;
import com.inspector.model.InspectorProgress;
import com.inspector.model.InspectorRecord;
import com.inspector.service.InspectorMessageService;
import com.inspector.service.InspectorNameService;
import com.inspector.service.InspectorOpinionService;
import com.inspector.service.InspectorProgressService;
import com.inspector.service.InspectorRecordService;
import com.inspector.service.InspectorService;
import com.sys.model.Attachments;
import com.sys.model.MessageRemind;
import com.sys.model.Messages;
import com.sys.service.AttachmentsService;
import com.sys.service.MessageRemindService;
import com.sys.service.MessagesService;
import com.util.FilterRules;
import com.util.HTMLSpirit;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;
import com.wechat.controller.WechatController;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("inspector")
public class InspectorController {

	@Autowired
	private InspectorService inspectorService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private InspectorRecordService inspectorRecordService;// 修改记录 全部
	@Autowired
	private InspectorOpinionService inspectorOpinionService;// 督办意见 督查员
	@Autowired
	private InspectorProgressService inspectorProgressService;// 填报进展 单位部门
	@Autowired
	private InspectorMessageService inspectorMessageService;// 留言讨论 全部
	@Autowired
	private MessagesService messagesService;
	@Autowired
	private MessageRemindService messageRemindService;
	@Autowired
	private EmergencyService emergencyService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private InspectorNameService inspectorNameService;
	@Autowired
	private AttachmentsService attachmentsService;

	/*
	 * 督查事项列表
	 */

	@RequestMapping("inspectorList")
	@ResponseBody
	public DataGrid inspectorList(
			@RequestParam(value = "filterRules", required = false) String filterRules,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "display", required = false) Integer display,
			HttpServletRequest request) {
		try {
			List<FilterRules> frs = new ArrayList<FilterRules>();
			if (filterRules != null) {
				JSONArray json = JSONArray.fromObject(filterRules);
				if (json.size() > 0) {
					for (int i = 0; i < json.size(); i++) {
						JSONObject job = json.getJSONObject(i);
						frs.add(new FilterRules((String) job.get("field"),
								(String) job.get("op"), (String) job
										.get("value")));
					}
				}
			}
			Inspector ins = new Inspector();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < frs.size(); i++) {
				FilterRules fr = frs.get(i);
				if (fr.getField().equals("iid"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setIid(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("source"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setSource(fr.getValue());
				if (fr.getField().equals("body"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setBody(fr.getValue());
				if (fr.getField().equals("requirements"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setRequirements(fr.getValue());
				if (fr.getField().equals("responsibilityname"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setResponsibilityname(fr.getValue());
				if (fr.getField().equals("type"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setType(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("frequency"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setFrequency(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("startTime"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setStartTime(sdf.parse(fr.getValue()));
				if (fr.getField().equals("endTime"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setEndTime(sdf.parse(fr.getValue()));
				if (fr.getField().equals("state"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setState(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("leadershipname"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setLeadershipname(fr.getValue());
				if (fr.getField().equals("applyCause"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						ins.setApplyCause(Integer.parseInt(fr.getValue()));
			}
			if (sort != null) {
				String[] newsort = sort.split(",");
				String[] neworder = order.split(",");
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < newsort.length; i++) {
					if (i == 0)
						sb.append(" order by ");
					if (newsort[i].equals("iid"))
						newsort[i] = "iid";
					if (newsort[i].equals("source"))
						newsort[i] = "source";
					if (newsort[i].equals("body"))
						newsort[i] = "body";
					if (newsort[i].equals("requirements"))
						newsort[i] = "requirements";
					if (newsort[i].equals("startTime"))
						newsort[i] = "start_time";
					if (newsort[i].equals("endTime"))
						newsort[i] = "end_time";
					if (newsort[i].equals("type"))
						newsort[i] = "type";
					if (newsort[i].equals("frequency"))
						newsort[i] = "frequency";
					if (newsort[i].equals("state"))
						newsort[i] = "state";
					if (newsort[i].equals("applyCause"))
						newsort[i] = "apply_cause";
					if (newsort[i].equals("delayDay"))
						newsort[i] = "delay_day";
					if (newsort[i].equals("responsibilityname")) {
						newsort[i] = "responsibilityname";
						if (i == 0)
							sb.append("dept." + newsort[i] + " " + neworder[i]);
						else
							sb.append(",dept." + newsort[i] + " " + neworder[i]);
					} else if (newsort[i].equals("leadershipname")) {
						newsort[i] = "name";
						if (i == 0)
							sb.append("u." + newsort[i] + " " + neworder[i]);
						else
							sb.append(",u." + newsort[i] + " " + neworder[i]);
					} else {
						if (i == 0)
							sb.append("ins." + newsort[i] + " " + neworder[i]);
						else
							sb.append(",ins." + newsort[i] + " " + neworder[i]);
					}
				}
				ins.setOrderby(sb.toString());
			} else
				ins.setOrderby("order by ins.create_time desc");
			DataGrid datagrid = DataGrid.init();
			User user = (User) request.getSession().getAttribute("user");
			// 如果是督查员身份，那么可以查看全部督查事项
			// 否则只能查看登录账号所属部门事项
			Integer did = null;
			if (user.getRid() != 1) {
				did = user.getDid();
				ins.setDisplay(display);
				// 如果是部门负责人
				// 查询是否一人管理多部门
				if (deptService.countPri(user.getUid()) > 1) {
					did = null;
					ins.setDid(did);
					StringBuffer sb = new StringBuffer();
					List<Dept> dept = deptService.principal(user.getUid());
					sb.append(" and ins.state!=1  and (");
					for (int i = 0; i < dept.size(); i++) {
						if (display == null || display == 1) {
							if (i == 0)
								sb.append("ins.responsibility="
										+ dept.get(i).getId()
										+ " or  FIND_IN_SET("
										+ dept.get(i).getId()
										+ ",ins.assist_dept)");
							else
								sb.append(" or ins.responsibility="
										+ dept.get(i).getId()
										+ " or  FIND_IN_SET("
										+ dept.get(i).getId()
										+ ",ins.assist_dept) ");
						} else if (display == 2) {
							if (i == 0)
								sb.append(" ins.responsibility="
										+ dept.get(i).getId());
							else
								sb.append(" or ins.responsibility="
										+ dept.get(i).getId());
						} else if (display == 3) {
							if (i == 0)
								sb.append("FIND_IN_SET(" + dept.get(i).getId()
										+ ",ins.assist_dept)");
							else
								sb.append(" or FIND_IN_SET("
										+ dept.get(i).getId()
										+ ",ins.assist_dept) ");
						}
					}
					sb.append(")");
					ins.setMuchdept(sb.toString());
				}
			}
			if (user.getDid() == 100001 || user.getRid() == 1)
				did = null;
			ins.setDid(did);
			PagedResult<Inspector> pagedResult = inspectorService.display(ins,
					page, rows);
			if (pagedResult.getDataList() != null
					&& pagedResult.getDataList().size() != 0) {
				Calendar cal = Calendar.getInstance();
				for (int i = 0; i < pagedResult.getDataList().size(); i++) {
					Inspector inspector = pagedResult.getDataList().get(i);
					if (inspector.getState() == 2 || inspector.getState() == 4) {
						// 进行中或超期
						if (inspector.getFrequency() == 1) {
							// 反馈频率 日
							pagedResult.getDataList().get(i).setNextDay(-1);
						} else if (inspector.getFrequency() == 2) {
							// 反馈频率 周
							// 查询今天是周几 计算到周五的天数 如果是周六 那么将计算到下周五的天数
							int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
							if (week <= 5) {
								week = 5 - week;
							} else if (week == 6) {
								week = 6;
							} else if (week == 7) {
								week = 5;
							}
							// 计算到完成时限剩余天数
							int days = (int) ((inspector.getEndTime().getTime() - new Date()
									.getTime()) / (1000 * 3600 * 24));
							if (days > 0 && days < 7) {
								pagedResult.getDataList().get(i)
										.setNextDay(days);
							} else {
								pagedResult.getDataList().get(i)
										.setNextDay(week);
							}
						} else if (inspector.getFrequency() == 3) {
							// 反馈频率 月
							// 查询今天是几号 计算到25号的天数 如果>25 那么将计算到下月25号的天数
							int day = cal.get(Calendar.DATE);
							if (day <= 25) {
								day = 25 - day;
							} else {
								Calendar ncal = Calendar.getInstance();
								ncal.add(Calendar.MONTH, +1);
								ncal.set(Calendar.DAY_OF_MONTH, 25);
								day = (int) Math
										.abs((ncal.getTime().getTime() - cal
												.getTime().getTime())
												/ (24 * 60 * 60 * 1000)) + 1;
							}
							int days = (int) ((inspector.getEndTime().getTime() - new Date()
									.getTime()) / (1000 * 3600 * 24));
							if (days > 0 && days < 30) {
								pagedResult.getDataList().get(i)
										.setNextDay(days);
							} else {
								pagedResult.getDataList().get(i)
										.setNextDay(day);
							}
						}
					}
					if (inspector.getState() == 5 || inspector.getState() == 3) {
						InspectorName inspectorName = inspectorNameService
								.selectid(inspector.getIid());
						pagedResult
								.getDataList()
								.get(i)
								.setResponsibilityname(
										inspectorName.getResponsibility());// 责任单位
						pagedResult.getDataList().get(i)
								.setAssistDept(inspectorName.getAssistDept());// 协助单位
						pagedResult.getDataList().get(i)
								.setLeadershipname(inspectorName.getCharge());// 分管领导
					} else {
						// 部门(负责人) 主管领导
						String assistDept = inspector.getAssistDept();
						StringBuffer sb = new StringBuffer();
						StringBuffer leadership = new StringBuffer();
						List<String> leaderships = new ArrayList<String>();
						if (!assistDept.equals("") && assistDept != null) {
							String[] dept = assistDept.split(",");
							for (int z = 0; z < dept.length; z++) {
								Dept d = deptService.selectByPrimaryKey(Integer
										.parseInt(dept[z]));
								String name = d.getDepartmentname();
								String priname = userService.selectuid(
										d.getPrincipal()).getName();
								if (z == 0)
									sb.append(name + "（" + priname + "）");
								else
									sb.append("," + name + "（" + priname + "）");
								leaderships.add(userService.selectuid(
										d.getLeadership()).getName());
							}
						}
						Dept dept = deptService.selectByPrimaryKey(inspector
								.getResponsibility());
						String zeren = dept.getDepartmentname()
								+ "（"
								+ userService.selectuid(dept.getPrincipal())
										.getName() + "）";
						leaderships.add(userService.selectuid(
								dept.getLeadership()).getName());
						HashSet hs = new HashSet(leaderships);
						if (hs != null && hs.size() != 0) {
							Iterator<String> it = hs.iterator();
							while (it.hasNext()) {
								String name = it.next();
								if (!name.equals("无"))
									leadership.append(name + " ");
							}
						}
						pagedResult.getDataList().get(i)
								.setResponsibilityname(zeren);// 责任单位
						pagedResult.getDataList().get(i)
								.setAssistDept(sb.toString());// 协助单位
						pagedResult.getDataList().get(i)
								.setLeadershipname(leadership.toString());// 分管领导
					}
				}
			}
			datagrid.setTotal(pagedResult.getTotal());
			datagrid.setRows(pagedResult.getDataList());
			return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}

	/*
	 * 督查事项入口
	 */
	@RequestMapping(value = "data")
	public ModelAndView data(
			@RequestParam(value = "state", required = false) Integer state,
			@RequestParam(value = "display", required = false) Integer display,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.addObject("state", state);
		mv.addObject("display", display);
		mv.addObject("role", user.getRid());
		mv.setViewName("inspector/inspector");
		return mv;
	}

	/*
	 * 申请延期页
	 */
	@RequestMapping(value = "delayPage")
	public ModelAndView delayPage(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/createDelay");
		return mv;
	}

	/**
	 * 申请延期
	 */
	@RequestMapping("delay")
	@ResponseBody
	public Json delay(@RequestBody Inspector inspector,
			HttpServletRequest request) {
		try {
			inspector.setApplyCause(2);// 待审核状态
			if (inspectorService.update(inspector) == 1)
				return new Json(200, "操作成功！", inspector.getIid());
			else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 分管领导延期操作
	 */
	@RequestMapping("updateDelay")
	@ResponseBody
	public Json updateDelay(@RequestParam("iid") Integer iid,
			@RequestParam("applyCause") Integer applyCause,
			HttpServletRequest request) {
		try {
			Inspector ins = new Inspector(iid, applyCause);
			if (inspectorService.update(ins) == 1)
				return new Json(200, "操作成功！", null);
			else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 督查员延期操作
	 */
	@RequestMapping("insupdateDelay")
	@ResponseBody
	public Json insupdateDelay(@RequestParam("iid") Integer iid,
			@RequestParam("delayDay") Integer delayDay,
			HttpServletRequest request) {
		try {
			// 通过 延长相应天数
			Inspector ins = new Inspector();
			ins.setIid(iid);
			ins.setApplyCause(3);// 已延期
			ins.setState(2);// 状态修改为进行中
			Inspector inspector = inspectorService.selectid(iid);
			Date endtime = inspector.getEndTime();
			Calendar cal = Calendar.getInstance();
			cal.setTime(endtime);
			cal.add(Calendar.DATE, delayDay);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ins.setEndTime(sdf.parse(sdf.format(cal.getTime())));
			if (inspectorService.update(ins) == 1) {
				// 同时将扣分失效
				scoreService.lose(new Score(deptService.selectByPrimaryKey(
						inspector.getResponsibility()).getPrincipal(), iid));
				return new Json(200, "操作成功！", null);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/*
	 * 延期详情页
	 */
	@RequestMapping(value = "delayDetails")
	public ModelAndView delayDetails(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Inspector ins = inspectorService.selectid(iid);
		mv.addObject("ins", ins);
		mv.addObject("leadership",
				deptService.selectLeadership(ins.getResponsibility()).getUid());
		User user = (User) request.getSession().getAttribute("user");
		mv.addObject("user", user);
		mv.setViewName("inspector/delayDetails");
		return mv;
	}

	/*
	 * 修改记录详情页
	 */
	@RequestMapping(value = "recordDetails")
	public ModelAndView recordDetails(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/recordDetails");
		return mv;
	}

	@RequestMapping("recordList")
	@ResponseBody
	public DataGrid recordList(@RequestParam(value = "iid") Integer iid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		try {
			DataGrid datagrid = new DataGrid();
			PagedResult<InspectorRecord> pagedResult = inspectorRecordService
					.selectiid(iid, page, rows);
			datagrid.setTotal(pagedResult.getTotal());
			datagrid.setRows(pagedResult.getDataList());
			return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 添加留言讨论
	 */
	@RequestMapping("createMessage")
	@ResponseBody
	public Json createMessage(@RequestBody InspectorMessage inspectorMessage,
			HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			inspectorMessage.setCreateBy(user.getName());// 创建者
			inspectorMessage.setUid(user.getUid());// 创建者ID，用于查询权限
			inspectorMessage.setCreateTime(new Date());// 发送时间
			if (inspectorMessageService.create(inspectorMessage) == 1)
				return new Json(200, "操作成功！", null);
			else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/*
	 * 留言详情页
	 */
	@RequestMapping(value = "messages")
	public ModelAndView messages(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/messages");
		return mv;
	}

	@RequestMapping("messagesList")
	@ResponseBody
	public DataGrid messagesList(@RequestParam(value = "iid") Integer iid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		try {
			DataGrid datagrid = new DataGrid();
			PagedResult<InspectorMessage> pagedResult = inspectorMessageService
					.selectiid(iid, page, rows);
			datagrid.setTotal(pagedResult.getTotal());
			datagrid.setRows(pagedResult.getDataList());
			return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}

	}

	/*
	 * 填报进展页
	 */
	@RequestMapping(value = "createProgressPage")
	public ModelAndView createProgressPage(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/createProgress");
		return mv;
	}

	/**
	 * 填报进展
	 */
	@RequestMapping("createProgress")
	@ResponseBody
	public Json createProgress(
			@RequestBody InspectorProgress inspectorProgress,
			HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			Dept dept = deptService.selectByPrimaryKey(user.getDid());
			Inspector inspector = inspectorService.selectid(inspectorProgress
					.getIid());
			inspectorProgress.setCreateBy(deptService.selectByPrimaryKey(
					inspector.getResponsibility()).getDepartmentname());
			inspectorProgress.setDid(user.getDid());
			inspectorProgress.setCreateTime(new Date());// 创建时间
			if (inspectorProgressService.create(inspectorProgress) == 1)
				return new Json(200, "操作成功！", inspectorProgress.getIid());
			else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/*
	 * 填报进展详情页
	 */
	@RequestMapping(value = "progress")
	public ModelAndView progress(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/progress");
		return mv;
	}

	@RequestMapping("progressList")
	@ResponseBody
	public DataGrid progressList(@RequestParam(value = "iid") Integer iid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		try {
			DataGrid datagrid = new DataGrid();
			PagedResult<InspectorProgress> pagedResult = inspectorProgressService
					.selectiid(iid, page, rows);
			datagrid.setTotal(pagedResult.getTotal());
			datagrid.setRows(pagedResult.getDataList());
			return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}

	}

	/*
	 * 更新督办意见页
	 */
	@RequestMapping(value = "createOpinionPage")
	public ModelAndView createOpinionPage(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/createOpinion");
		return mv;
	}

	/**
	 * 更新督办意见
	 */
	@RequestMapping("createOpinion")
	@ResponseBody
	public Json createOpinion(@RequestBody InspectorOpinion inspectorOpinion,
			HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			inspectorOpinion.setCreateBy(user.getName());// 创建者
			inspectorOpinion.setCreateTime(new Date());// 创建时间
			if (inspectorOpinionService.create(inspectorOpinion) == 1)
				return new Json(200, "操作成功！", inspectorOpinion.getIid());
			else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/*
	 * 督办意见详情页
	 */
	@RequestMapping(value = "opinions")
	public ModelAndView opinions(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("iid", iid);
		mv.setViewName("inspector/opinions");
		return mv;
	}

	@RequestMapping("opinionsList")
	@ResponseBody
	public DataGrid opinionsList(@RequestParam(value = "iid") Integer iid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		try {
			DataGrid datagrid = new DataGrid();
			PagedResult<InspectorOpinion> pagedResult = inspectorOpinionService
					.selectiid(iid, page, rows);
			datagrid.setTotal(pagedResult.getTotal());
			datagrid.setRows(pagedResult.getDataList());
			return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}

	}

	/*
	 * 督查事项详情页
	 */

	@RequestMapping("inspectorDetails")
	@ResponseBody
	public ModelAndView inspectorDetails(@RequestParam("iid") Integer iid,
			@RequestParam(value = "flag", required = false) Integer flag,
			HttpServletRequest request) {
		try {
			ModelAndView mv = new ModelAndView();
			User user = (User) request.getSession().getAttribute("user");
			Inspector ins = inspectorService.selectid(iid);
			String assistDept = ins.getAssistDept();
			StringBuffer sb = new StringBuffer();
			StringBuffer leadership = new StringBuffer();
			List<String> leaderships = new ArrayList<String>();
			// 进展flag
			boolean progress = false;
			// 延期flag
			boolean delay = false;
			if (!assistDept.equals("") && assistDept != null) {
				String[] dept = assistDept.split(",");
				for (int i = 0; i < dept.length; i++) {
					Dept d = deptService.selectByPrimaryKey(Integer
							.parseInt(dept[i]));
					if (user.getUid() == d.getPrincipal())
						progress = true;
					String name = d.getDepartmentname();
					String priname = userService.selectuid(d.getPrincipal())
							.getName();
					if (i == 0)
						sb.append(name + "(" + priname + ")");
					else
						sb.append("," + name + "(" + priname + ")");
					leaderships.add(userService.selectuid(d.getLeadership())
							.getName());
				}
			}
			Dept dept = deptService.selectByPrimaryKey(ins.getResponsibility());
			mv.addObject("responsibilityPrincipal",
					userService.selectuid(dept.getPrincipal()).getName());
			if (user.getUid() == dept.getPrincipal()) {
				progress = true;
				delay = true;
			}
			leaderships.add(userService.selectuid(dept.getLeadership())
					.getName());
			HashSet hs = new HashSet(leaderships);
			if (hs != null && hs.size() != 0) {
				Iterator<String> it = hs.iterator();
				while (it.hasNext()) {
					String name = it.next();
					if (!name.equals("无"))
						leadership.append(name + " ");
				}
			}
			if (ins.getState() == 5 || ins.getState() == 3) {
				InspectorName inspectorName = inspectorNameService.selectid(ins
						.getIid());
				mv.addObject("resname", inspectorName.getResponsibility());
				mv.addObject("assname", inspectorName.getAssistDept());
				mv.addObject("chaname", inspectorName.getCharge());
				mv.addObject("leaname", inspectorName.getLeadership());
			}
			mv.addObject("progress", progress);
			mv.addObject("delay", delay);
			mv.addObject("ins", ins);
			mv.addObject("role", user.getRid());
			mv.addObject("leadership", leadership.toString());
			mv.addObject("assistdept", sb.toString());
			mv.addObject("flag", flag);
			mv.addObject("files",
					attachmentsService.display(new Attachments(1, iid)));
			mv.setViewName("inspector/details");
			return mv;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 督查事项创建页
	 */
	@RequestMapping("createInspectorPage")
	public ModelAndView createInspectorPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> supervisor = new HashMap<String, String>();
		List<Dept> dept = deptService.selectname(null);
		if (dept != null && dept.size() != 0) {
			for (int i = 0; i < dept.size(); i++) {
				Dept d = dept.get(i);
				if (d.getDepartmentname().equals("集团本部")
						|| d.getDepartmentname().equals("子公司")
						|| d.getDepartmentname().equals("未设置"))
					dept.remove(i);
				supervisor
						.put(String.valueOf(d.getId()), d.getLeadershipname());
			}
		}
		mv.addObject("supervisor", JSONObject.fromObject(supervisor));
		mv.addObject("leadership", userService.headdid());
		mv.addObject("dept", dept);
		mv.setViewName("inspector/create");
		return mv;
	}

	/**
	 * 主管领导
	 */
	@RequestMapping("selectSupervisor")
	@ResponseBody
	public Map<String, String> selectSupervisor(HttpServletRequest request) {
		Map<String, String> supervisor = new HashMap<String, String>();
		List<Dept> dept = deptService.selectname(null);
		if (dept != null && dept.size() != 0) {
			for (int i = 0; i < dept.size(); i++) {
				Dept d = dept.get(i);
				supervisor
						.put(String.valueOf(d.getId()), d.getLeadershipname());
			}
		}
		return supervisor;
	}

	/**
	 * 督查事项创建
	 */
	@RequestMapping("createInspector")
	@ResponseBody
	public Json createInspector(@RequestBody Inspector inspector,
			HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			inspector.setCreateBy(user.getName());// 创建者
			inspector.setCreateTime(new Date());// 创建时间
			if (inspector.getLeadership() == null)
				inspector.setLeadership(0);// 设置协办领导
			Integer id = inspectorService.create(inspector);
			if (id != null) {
				if (inspector.getFiles().length != 0) {
					List<Attachments> attachments = new ArrayList<Attachments>();
					for (int i = 0; i < inspector.getFiles().length; i++)
						attachments.add(new Attachments(1, id, inspector
								.getFiles()[i]));
					// 上传附件
					attachmentsService.creates(attachments);
				}
				// 同时添加部门看板
				// List<Emergency> emergencies=new ArrayList<Emergency>();
				// emergencies.add(new Emergency(inspector.getResponsibility(),
				// 4, 1, id));
				// if(!inspector.getAssistDept().equals("")&&inspector.getAssistDept()!=null){
				// String assistdept=inspector.getAssistDept();
				// String[] dept=assistdept.split(",");
				// for(int i=0;i<dept.length;i++)emergencies.add(new
				// Emergency(Integer.parseInt(dept[i]), 4, 1, id));
				// }
				// if(emergencyService.creates(emergencies)!=0){
				return new Json(200, "操作成功！", id);
				// }else return new Json(201,"操作失败！",null);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 督查事项发送消息
	 */
	@RequestMapping("InspectorMes")
	@ResponseBody
	public Json InspectorMes(@RequestParam("iid") Integer iid,
			@RequestParam("flag") Integer flag, HttpServletRequest request) {
		try {
			String body = "";
			String after = "";
			if (flag == 1)
				body = "发起";
			else if (flag == 2)
				body = "修改";
			else if (flag == 3)
				body = "留言";
			else if (flag == 4) {
				body = "更新";
				after = "督办意见";
			} else if (flag == 5)
				body = "启动";
			else if (flag == 6)
				body = "取消";
			else if (flag == 7)
				body = "完成";
			Inspector ins = inspectorService.selectid(iid);
			List<User> res = userService.selectdid(ins.getResponsibility());
			String assistDept = ins.getAssistDept();
			List<Integer> id = new ArrayList<Integer>();
			// 协办领导
			if (ins.getLeadership() != null && ins.getLeadership() != 0)
				id.add(ins.getLeadership());
			// 一人负责管理多部门
			Dept dept = deptService.selectByPrimaryKey(ins.getResponsibility());
			User pri = userService.selectuid(dept.getPrincipal());
			// 责任单位
			if (res != null && res.size() != 0)
				for (int i = 0; i < res.size(); i++)
					if (pri.getUid() != res.get(i).getUid())
						id.add(res.get(i).getUid());
			// 负责人计数
			if (deptService.countPri(pri.getUid()) >= 1)
				if (pri.getDid() != ins.getResponsibility())
					id.add(pri.getUid());
			// 协助单位
			if (assistDept != null && !assistDept.equals("")) {
				String[] ass = assistDept.split(",");
				if (ass != null && ass.length != 0) {
					for (int i = 0; i < ass.length; i++) {
						Integer xiezhu = Integer.parseInt(ass[i]);
						List<User> users = userService.selectdid(xiezhu);
						// 一人负责管理多部门
						Dept d = deptService.selectByPrimaryKey(xiezhu);
						User p = userService.selectuid(d.getPrincipal());
						if (users != null && users.size() != 0)
							for (int j = 0; j < users.size(); j++)
								if (p.getUid() != users.get(j).getUid())
									id.add(users.get(j).getUid());
						// 负责人计数
						if (deptService.countPri(p.getUid()) >= 1)
							if (p.getDid() != xiezhu)
								id.add(p.getUid());
					}
				}
			}
			User user = (User) request.getSession().getAttribute("user");
			if (id.size() != 0) {
				// 去重
				id = removeDuplicate(id);
				Integer mid = messagesService.create(new Messages(user
						.getName() + body + "了" + ins.getSource() + after, 1,iid));
				if (mid != 0) {
					List<MessageRemind> mrs = new ArrayList<MessageRemind>();
					Date date = new Date();
					if (id.size() != 0) {
						for (int i = 0; i < id.size(); i++) {
							MessageRemind mr = new MessageRemind();
							mr.setMid(mid);
							mr.setState(0);
							mr.setUid(id.get(i));
							mr.setReadingTime(date);
							mrs.add(mr);
							// 推送消息
							if(flag==1){
							User u = userService.selectuid(id.get(i));
							if (u.getWechat() != null
									&& !u.getWechat().equals("")) {
								WechatController.sendIns(ins.getSource(),
										HTMLSpirit.delHTMLTag(ins.getBody())
												.replaceAll("&nbsp;", " "),
										"进行中", null, u.getWechat().trim(),ins.getIid());
							}
						}
					}
					}
					if (messageRemindService.creates(mrs) != 0) {
						return new Json(200, "操作成功！", mid);
					} else
						return new Json(201, "操作失败！", null);
				} else
					return new Json(201, "操作失败！", null);
			} else
				return new Json(200, "操作成功！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 进展、延期发送消息
	 */
	@RequestMapping("progressMes")
	@ResponseBody
	public Json progressMes(@RequestParam("iid") Integer iid,
			@RequestParam("flag") Integer flag, HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			Inspector ins = inspectorService.selectid(iid);
			List<Integer> id = new ArrayList<Integer>();
			String body = "";
			String after = "";
			if (flag == 1) {
				body = deptService.selectByPrimaryKey(ins.getResponsibility())
						.getDepartmentname() + "填报";
				after = "进展";
			} else if (flag == 2) {
				body = user.getName() + "申请";
				after = "延期";
				// 发送给责任单位分管领导
				id.add(deptService.selectLeadership(ins.getResponsibility())
						.getUid());
			}
			List<User> users = userService.selectridins();
			if (users != null && users.size() != 0)
				for (int i = 0; i < users.size(); i++)
					id.add(users.get(i).getUid());
			if (id.size() != 0) {
				// 去重
				id = removeDuplicate(id);
				Integer mid = messagesService.create(new Messages(body + "了"
						+ ins.getSource() + after, 1,iid));
				if (mid != 0) {
					List<MessageRemind> mrs = new ArrayList<MessageRemind>();
					Date date = new Date();
					if (id.size() != 0) {
						for (int i = 0; i < id.size(); i++) {
							MessageRemind mr = new MessageRemind();
							mr.setMid(mid);
							mr.setState(0);
							mr.setUid(id.get(i));
							mr.setReadingTime(date);
							mrs.add(mr);
						}
					}
					if (messageRemindService.creates(mrs) != 0) {
						return new Json(200, "操作成功！", mid);
					} else
						return new Json(201, "操作失败！", null);
				} else
					return new Json(201, "操作失败！", null);
			} else
				return new Json(200, "操作成功！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 事项修改页
	 */
	@RequestMapping("updateInspectorPage")
	public ModelAndView updateInspectorPage(@RequestParam("iid") Integer iid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<Dept> dept = deptService.selectall();
		if (dept != null && dept.size() != 0) {
			for (int i = 0; i < dept.size(); i++) {
				Dept d = dept.get(i);
				if (d.getDepartmentname().equals("集团本部")
						|| d.getDepartmentname().equals("子公司")
						|| d.getDepartmentname().equals("未设置"))
					dept.remove(i);
			}
		}
		mv.addObject("leadership", userService.headdid());
		mv.addObject("dept", dept);
		Inspector ins = inspectorService.selectid(iid);
		String startTime = null, endTime = null;
		if (ins.getStartTime() != null)
			startTime = ins.getStartTime().toLocaleString().split(" ")[0];
		if (ins.getEndTime() != null)
			endTime = ins.getEndTime().toLocaleString().split(" ")[0];
		mv.addObject("startTime", startTime);
		mv.addObject("endTime", endTime);
		mv.addObject("inspector", ins);
		mv.addObject("files",
				attachmentsService.display(new Attachments(1, iid)));
		mv.setViewName("inspector/update");
		return mv;
	}

	/**
	 * 事项修改
	 */
	@RequestMapping("updateInspector")
	@ResponseBody
	public Json updateInspector(@RequestBody Inspector inspector,
			HttpServletRequest request) {
		try {
			if (inspectorService.update(inspector, request) == 1) {
				if (inspector.getFiles().length != 0) {
					List<Attachments> attachments = new ArrayList<Attachments>();
					for (int i = 0; i < inspector.getFiles().length; i++)
						attachments.add(new Attachments(1, inspector.getIid(),
								inspector.getFiles()[i]));
					// 上传附件
					attachmentsService.creates(attachments);
				}
				return new Json(200, "操作成功！", null);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 协助单位多项选择树
	 */
	@RequestMapping("assistDeptTree")
	@ResponseBody
	public List<AssistDeptTree> assistDeptTree(HttpServletRequest request) {
		List<AssistDeptTree> tree = new ArrayList<AssistDeptTree>();
		List<Dept> depts = deptService.display();
		if (depts != null && depts.size() != 0) {
			for (int i = 0; i < depts.size(); i++) {
				AssistDeptTree adt = new AssistDeptTree();
				Dept topDept = depts.get(i);
				adt.setId(topDept.getId());
				adt.setText(topDept.getDepartmentname());
				if (topDept.getDept() != null && topDept.getDept().size() != 0)
					adt.setChildren(Depts(topDept.getDept()));
				tree.add(adt);
			}
		}
		return tree;
	}

	/**
	 * 协助单位多项选择树递归
	 */
	public List<AssistDeptTree> Depts(List<Dept> depts) {
		List<AssistDeptTree> tree = new ArrayList<AssistDeptTree>();
		if (depts != null && depts.size() != 0) {
			for (int i = 0; i < depts.size(); i++) {
				AssistDeptTree adt = new AssistDeptTree();
				Dept topDept = depts.get(i);
				if (!topDept.getDepartmentname().equals("未设置")) {
					adt.setId(topDept.getId());
					adt.setText(topDept.getDepartmentname());
					List<Dept> ds = deptService.selecttopid(topDept.getId());
					if (ds != null && ds.size() != 0)
						for (int j = 0; j < ds.size(); j++)
							adt.setChildren(Depts(ds));
					tree.add(adt);
				}
			}
		}
		return tree;
	}

	/**
	 * 删除事项
	 */
	@RequestMapping("delInspector")
	@ResponseBody
	public Json delInspector(
			@RequestParam(value = "state", required = false) Integer state,
			@RequestParam("iid") Integer iid, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/");
			path = path.substring(0, path.indexOf("webapps"));
			if (inspectorService.delete(iid) == 1) {
				inspectorMessageService.delete(iid);// 留言删除
				inspectorOpinionService.delete(iid);// 意见删除
				inspectorProgressService.delete(iid);// 进展删除
				inspectorRecordService.delete(iid);// 修改记录删除
				inspectorNameService.delete(iid);// 记录删除
				emergencyService.deleteins(iid);// 部门看板删除
				List<Attachments> attachments = attachmentsService
						.display(new Attachments(1, iid));
				attachmentsService.delete(new Attachments(1, iid));
				if (attachments != null && attachments.size() != 0) {
					for (int j = 0; j < attachments.size(); j++) {
						// 同时删除本地文件
						File file = new File(path
								+ "webapps/InspectorImgs/files/"
								+ attachments.get(j).getAttachment());
						if (file.exists() && file.isFile()) {
							file.delete();
						}
					}
				}
				return new Json(200, "操作成功！", null);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 启动事项
	 */
	@RequestMapping("startInspector")
	@ResponseBody
	public Json startInspector(@RequestParam("state") Integer state,
			@RequestParam("iid") Integer iid, HttpServletRequest request) {
		try {
			if (inspectorService.state(state, iid) == 1) {
				return new Json(200, "操作成功！", iid);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 中止事项
	 */
	@RequestMapping("offInspector")
	@ResponseBody
	public Json offInspector(@RequestParam("state") Integer state,
			@RequestParam("iid") Integer iid, HttpServletRequest request) {
		try {
			if (inspectorService.state(state, iid) == 1) {
				// 记录该事项的主要负责人
				Inspector ins = inspectorService.selectid(iid);
				// 责任单位
				Dept res = deptService.selectByPrimaryKey(ins
						.getResponsibility());
				List<String> leaderships = new ArrayList<String>();
				StringBuffer leadership = new StringBuffer();
				String responsibility = res.getDepartmentname() + "("
						+ userService.selectuid(res.getPrincipal()).getName()
						+ ")";
				// 协助单位
				String assistDept = ins.getAssistDept();
				StringBuffer sb = new StringBuffer();
				if (!assistDept.equals("") && assistDept != null) {
					String[] dept = assistDept.split(",");
					for (int i = 0; i < dept.length; i++) {
						Dept d = deptService.selectByPrimaryKey(Integer
								.parseInt(dept[i]));
						String name = d.getDepartmentname();
						String priname = userService
								.selectuid(d.getPrincipal()).getName();
						if (i == 0)
							sb.append(name + "(" + priname + ")");
						else
							sb.append("," + name + "(" + priname + ")");
						leaderships.add(userService
								.selectuid(d.getLeadership()).getName());
					}
				}
				// 主管领导 去重
				leaderships.add(userService.selectuid(res.getLeadership())
						.getName());
				HashSet hs = new HashSet(leaderships);
				if (hs != null && hs.size() != 0) {
					Iterator<String> it = hs.iterator();
					while (it.hasNext()) {
						String name = it.next();
						if (!name.equals("无"))
							leadership.append(name + " ");
					}
				}
				// 协办领导
				String leader = userService.selectuid(ins.getLeadership())
						.getName();
				inspectorNameService.create(new InspectorName(ins.getIid(),
						responsibility, sb.toString(), leadership.toString(),
						leader));
				return new Json(200, "操作成功！", iid);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	/**
	 * 完成事项
	 */
	@RequestMapping("completeInspector")
	@ResponseBody
	public Json completeInspector(@RequestParam("state") Integer state,
			@RequestParam("iid") Integer iid, HttpServletRequest request) {
		try {
			if (inspectorService.state(state, iid) == 1) {
				// 记录该事项的主要负责人
				Inspector ins = inspectorService.selectid(iid);
				// 责任单位
				Dept res = deptService.selectByPrimaryKey(ins
						.getResponsibility());
				List<String> leaderships = new ArrayList<String>();
				StringBuffer leadership = new StringBuffer();
				String responsibility = res.getDepartmentname() + "("
						+ userService.selectuid(res.getPrincipal()).getName()
						+ ")";
				// 协助单位
				String assistDept = ins.getAssistDept();
				StringBuffer sb = new StringBuffer();
				if (!assistDept.equals("") && assistDept != null) {
					String[] dept = assistDept.split(",");
					for (int i = 0; i < dept.length; i++) {
						Dept d = deptService.selectByPrimaryKey(Integer
								.parseInt(dept[i]));
						String name = d.getDepartmentname();
						String priname = userService
								.selectuid(d.getPrincipal()).getName();
						if (i == 0)
							sb.append(name + "(" + priname + ")");
						else
							sb.append("," + name + "(" + priname + ")");
						leaderships.add(userService
								.selectuid(d.getLeadership()).getName());
					}
				}
				// 主管领导 去重
				leaderships.add(userService.selectuid(res.getLeadership())
						.getName());
				HashSet hs = new HashSet(leaderships);
				if (hs != null && hs.size() != 0) {
					Iterator<String> it = hs.iterator();
					while (it.hasNext()) {
						String name = it.next();
						if (!name.equals("无"))
							leadership.append(name + " ");
					}
				}
				// 协办领导
				String leader = userService.selectuid(ins.getLeadership())
						.getName();
				inspectorNameService.create(new InspectorName(ins.getIid(),
						responsibility, sb.toString(), leadership.toString(),
						leader));
				return new Json(200, "操作成功！", iid);
			} else
				return new Json(201, "操作失败！", null);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return new Json(500, null, null);
		}
	}

	// List去重
	public static List removeDuplicate(List list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		return list;
	}
}