package com.fh.controller.itemBank.itembank;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.service.itemBank.itembank.ItemBankService;

/** 
 * 类名称：ItemBankController
 * 创建人：FH 
 * 创建时间：2017-07-05
 */
@Controller
@RequestMapping(value="/itembank")
public class ItemBankController extends BaseController {

	
	String menuUrl = "itembank/list.do"; //菜单地址(权限用)
	@Resource(name="itembankService")
	private ItemBankService itembankService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, "新增ItemBank");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("IT_ID", this.get32UUID());	//主键
		itembankService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		logBefore(logger, "删除ItemBank");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			itembankService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, "修改ItemBank");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		itembankService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page){
		logBefore(logger, "列表ItemBank");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	varLists = itembankService.listAll(pd);	//列出ItemBankAll列表
			List<PageData>	varList = itembankService.list(page);	//列出ItemBank列表

			List<PageData>	rankListThree = new ArrayList<PageData>();
//			总的id数存在这里
			List<Integer> rank1 = new LinkedList<Integer>();
			List<Integer> rank2 = new LinkedList<Integer>();
			List<Integer> rank3 = new LinkedList<Integer>();
//这里遍历总题库，取出ID和RANK对应的value值，然后分别保存在定义好的list文件中
			for(int i=0;i<varLists.size();i++){
				int rank = (int)varLists.get(i).get("RANK");
				String id = (String) varLists.get(i).get("IT_ID");
				if (rank == 1) {
					rank1.add(Integer.parseInt(id));
				}else if (rank == 2) {
					rank2.add(Integer.parseInt(id));
				}else {
					rank3.add(Integer.parseInt(id));
				}
			}
//			这个实现对获取到的id进行随机抽取的方法
			Set<Integer> set1 = RandomWithIterator.getRandom(15-1,rank1.size()-1);
			Set<Integer> set2 = RandomWithIterator.getRandom(15-1,rank2.size()-1);
			Set<Integer> set3 = RandomWithIterator.getRandom(10-1,rank3.size()-1);
			//随机抽取的编号存在这个list中
			List<Integer> list1 = new ArrayList<Integer> ();
			List<Integer> list2 = new ArrayList<Integer> ();
			List<Integer> list3 = new ArrayList<Integer> ();
			List<Integer> listThree = new ArrayList<Integer>();
           //此中存储的数据库的ID
			list1 = RandomWithIterator.getID(set1,rank1);
			list2 = RandomWithIterator.getID(set2,rank2);
			list3 = RandomWithIterator.getID(set3,rank3);
			listThree.addAll(list1);
			listThree.addAll(list2);
			listThree.addAll(list3);
//这里实现获取到的数据库中ID与总题库中的ID进行匹对，进而获取map，存储在一个新的pagedata格式的list中。
			for (int i = 0; i <listThree.size(); i++) {
				for (int j = 0; j < varLists.size(); j++) {
					if ((listThree.get(i)).toString().equals(varLists.get(j).get("IT_ID")) ) {
						rankListThree.add(varLists.get(j));
						break;
					}
				}
			}

			mv.setViewName("itemBank/itembank/itembank_list");
			mv.addObject("varList", rankListThree);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());

		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		logBefore(logger, "去新增ItemBank页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("itemBank/itembank/itembank_edit");
			mv.addObject("msg", "save");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		logBefore(logger, "去修改ItemBank页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = itembankService.findById(pd);	//根据ID读取
			mv.setViewName("itemBank/itembank/itembank_edit");
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() {
		logBefore(logger, "批量删除ItemBank");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "dell")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				itembankService.deleteAll(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, "导出ItemBank到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("题目");	//1
			titles.add("A选项");	//2
			titles.add("B选项");	//3
			titles.add("C选项");	//4
			titles.add("D选项");	//5
			titles.add("判断选项，1正确。0错误");	//6
			titles.add("级别，1单选，2多选，3判断");	//7
			titles.add("答案");	//8
			dataMap.put("titles", titles);
			List<PageData> varOList = itembankService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("TOPIC"));	//1
				vpd.put("var2", varOList.get(i).getString("OPTION_A"));	//2
				vpd.put("var3", varOList.get(i).getString("OPTION_B"));	//3
				vpd.put("var4", varOList.get(i).getString("OPTION_C"));	//4
				vpd.put("var5", varOList.get(i).getString("OPTION_D"));	//5
				vpd.put("var6", varOList.get(i).get("FLAG").toString());	//6
				vpd.put("var7", varOList.get(i).get("RANK").toString());	//7
				vpd.put("var8", varOList.get(i).getString("ANSWER"));	//8
				varList.add(vpd);
			}
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView();
			mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
