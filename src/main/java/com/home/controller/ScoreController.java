package com.home.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

import com.dept.model.Dept;
import com.dept.service.DeptService;
import com.home.model.Score;
import com.home.model.User;
import com.home.service.ScoreService;
import com.home.service.UserService;
import com.util.FilterRules;
import com.util.Log;
import com.util.json.Json;
import com.util.page.DataGrid;
import com.util.page.PagedResult;


import springfox.documentation.annotations.ApiIgnore;


@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("score")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	
	
	/**
	 * 分数入口
	 */
	@RequestMapping(value="data")
	public ModelAndView data(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
	//	User user=(User)request.getSession().getAttribute("user");
	//	mv.addObject("dept",deptService.selectall());
	//	mv.addObject("user", user);
		mv.setViewName("home/score");
		return mv;
	}
	
	/**
	 *分数数据
	 */
	@RequestMapping(value="scoreList",method=RequestMethod.POST)
	@ResponseBody
	public DataGrid scoreList(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,HttpServletRequest request){
		try {
			DataGrid datagrid=new DataGrid();
			PagedResult<Dept> pagedResult=deptService.selectscoreName(null,page,rows);
			//当月考核分
			if(pagedResult.getDataList()!=null&&pagedResult.getDataList().size()!=0){
				for(int i=0;i<pagedResult.getDataList().size();i++){
					//默认查询当月分数
					Date date=new Date();
					Integer month=date.getMonth()+1;
					Integer year=Integer.parseInt(date.toLocaleString().substring(0, 4));
					//计算当月有效分数
					if(pagedResult.getDataList().get(i).getPrincipal()!=null){
					Integer monthscore=100+scoreService.monthscore(pagedResult.getDataList().get(i).getPrincipal(), year, month,1)-
							scoreService.monthscore(pagedResult.getDataList().get(i).getPrincipal(), year, month,0);
				 if(monthscore<0)monthscore=0;
					pagedResult.getDataList().get(i).setScore(monthscore);
				}else{
					pagedResult.getDataList().get(i).setScore(100);
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
	/**
	 * 个人分数页
	 */
	@RequestMapping(value="scoreDetails")
	public ModelAndView scoreDetails(@RequestParam(value="year",required=false) Integer year,
			@RequestParam(value="month",required=false) Integer month,@RequestParam("uid") Integer uid,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		//默认查询当月分数
		Date date=new Date();
		if(month==null)month=date.getMonth()+1;
		if(year==null)year=Integer.parseInt(date.toLocaleString().substring(0, 4));
		List<Integer> years=new ArrayList<Integer>();
		for(int i=year;i>year-10;i--)years.add(i);
		Collections.sort(years);
		//计算当月有效分数
//		Integer monthscore=100+scoreService.monthscore(uid, year, month,1)-
//				scoreService.monthscore(uid, year, month,0);
//		if(monthscore>100)monthscore=100;
//		mv.addObject("monthscore", monthscore);
		mv.addObject("years", years);
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("uid", uid);
		mv.addObject("rid", user.getRid());
		mv.setViewName("home/scoreDetails");
		return mv;
	}
	/**
	 *个人分数数据
	 */
	@RequestMapping(value="scoreUser",method=RequestMethod.POST)
	@ResponseBody
	public DataGrid scoreUser(
			@RequestParam(value = "filterRules", required = false) String filterRules,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@RequestParam("year") Integer year,@RequestParam("month") Integer month,
			@RequestParam("uid") Integer uid,HttpServletRequest request){
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
			Score score=new Score();
			for (int i = 0; i < frs.size(); i++) {
				FilterRules fr = frs.get(i);
				if (fr.getField().equals("id"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						score.setId(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("source"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						score.setSource(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("addSub"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						score.setAddSub(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("state"))
					if (fr.getValue() != null && !fr.getValue().equals(""))
						score.setState(Integer.parseInt(fr.getValue()));
				if (fr.getField().equals("score")) {
					if (fr.getValue() != null && !fr.getValue().equals("")) {
						if (fr.getOp().equals("equal"))
							score.setNumflag(1);
						else if (fr.getOp().equals("lessorequal"))
							score.setNumflag(2);
						else if (fr.getOp().equals("greaterorequal"))
							score.setNumflag(3);
						score.setScore(new BigDecimal(fr.getValue()).intValue());
					}
				}
			}
			if (sort != null) {
				String[] newsort = sort.split(",");
				String[] neworder = order.split(",");
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < newsort.length; i++) {
					if (i == 0)
						sb.append(" order by ");
					if (newsort[i].equals("id"))
						newsort[i] = "id";
					if (newsort[i].equals("source"))
						newsort[i] = "source";
					if (newsort[i].equals("addSub"))
						newsort[i] = "add_sub";
					if (newsort[i].equals("score"))
						newsort[i] = "score";
					if (newsort[i].equals("state"))
						newsort[i] = "state";
						if (i == 0)
							sb.append(newsort[i] + " " + neworder[i]);
						else
							sb.append("," + newsort[i] + " " + neworder[i]);
					} 
				score.setOrderby(sb.toString());
				}else
					score.setOrderby("order by state desc");
			score.setYear(year);
			score.setMonth(month);
			score.setUid(uid);
			DataGrid datagrid=DataGrid.init();
			PagedResult<Score> pagedResult=scoreService.display(score,page,rows);
				 datagrid.setTotal(pagedResult.getTotal());
				 datagrid.setRows(pagedResult.getDataList());
			 	return datagrid;
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(), e);
			return null;
		}
	}
	/**
	 * 修改页
	 */
	@RequestMapping("updateScorePage")
	public ModelAndView updateScorePage(@RequestParam("id") Integer id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("score",scoreService.selectid(id));
		mv.setViewName("home/updateScore");
		return mv;
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateScore")
	@ResponseBody
	public Json updateScore(@RequestBody Score score,HttpServletRequest request){
		try {
			if(scoreService.update(score)==1)
				return new Json(200,"操作成功！",null);
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
	/**
	 * 添加页
	 */
	@RequestMapping("createScorePage")
	public ModelAndView createScorePage(@RequestParam("uid") Integer uid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("uid", uid);
		mv.setViewName("home/createScore");
		return mv;
	}
	/**
	 * 创建
	 */
	@RequestMapping("createScore")
	@ResponseBody
	public Json createScore(@RequestBody Score score,HttpServletRequest request){
		try {
			score.setSource(3);
			score.setSourceId(0);
			score.setState(1);
			Date date=new Date();
			score.setMonth(date.getMonth()+1);
			score.setYear(Integer.parseInt(date.toLocaleString().substring(0, 4)));
			if(scoreService.create(score)==1)
				return new Json(200,"操作成功！",null);
			else return new Json(201,"操作失败！",null);
		} catch (Exception e) {
			  Log.getLogger().error(e.getMessage(),e);  
		         return new Json(500,null,null);
		}
	}
}