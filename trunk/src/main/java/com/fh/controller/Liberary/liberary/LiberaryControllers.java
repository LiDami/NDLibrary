package com.fh.controller.Liberary.liberary;

import com.fh.controller.base.BaseController;
import com.fh.controller.itemBank.itembank.RandomWithIterator;
import com.fh.entity.Page;
import com.fh.service.Liberary.liberary.LiberaryService;
import com.fh.service.bookBrr.bookbrr.BookBrrService;
import com.fh.service.enterKno.enterkno.EnterKnoService;
import com.fh.service.informa.informa.InformaService;
import com.fh.service.itemBank.itembank.ItemBankService;
import com.fh.service.numberRes.numberres.NumberResService;
import com.fh.service.question.question.QuestionService;
import com.fh.service.reader.reader.ReaderService;
import com.fh.service.scoreResult.scoreresult.ScoreResultService;
import com.fh.service.success.success.SuccessService;
import com.fh.util.AppUtil;
import com.fh.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@RequestMapping(value="/api/all")
public class LiberaryControllers extends BaseController {

	private Map<String,Object> dataMap = new HashMap<String,Object>();
	@Autowired
	private LiberaryService liberaryService;
	@Autowired
	private BookBrrService bookBrrService;
	@Autowired
	private ItemBankService itemBankService;
	@Autowired
	private EnterKnoService enterKnoService;
	@Autowired
	private InformaService informaService;
	@Autowired
	private NumberResService numberResService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private ScoreResultService scoreResultService;
	@Autowired
	private SuccessService successService;

//	本馆概况
	@RequestMapping(value = "/liberary")
	@ResponseBody
	public Object liberary(Page page)throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = liberaryService.list(page);
		dataMap.put("varList",varList);
		return AppUtil.returnObject(new PageData(),dataMap);

	}

//	书刊借阅
	@RequestMapping(value="/bookbrr")
	@ResponseBody
	public Object queryAllss(Page page)throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = bookBrrService.list(page);	//列出BookBrr列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);

	}
//	入馆须知
	@RequestMapping(value="/enterkno")
	@ResponseBody
	public Object enter(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = enterKnoService.list(page);    //列出EnterKno列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	信息交流
	@RequestMapping(value="/informa")
	@ResponseBody
	public Object informa(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = informaService.list(page);    //列出information列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//随机试题库
	@RequestMapping(value="/itembank")
	@ResponseBody
	public Object intembank(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData>	varLists = itemBankService.listAll(pd);	//列出ItemBankAll列表
//		List<PageData>	varList = itemBankService.list(page);	//列出ItemBank列表

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

//		List<PageData> varList = itemBankService.list(page);    //列出Liberary列表
		dataMap.put("varList", rankListThree);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	数字资源
	@RequestMapping(value="/numberres")
	@ResponseBody
	public Object numberres(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = numberResService.list(page);    //列出numberRes列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	常见问题
	@RequestMapping(value="/question")
	@ResponseBody
	public Object question(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = questionService.list(page);    //列出question列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	读者服务
	@RequestMapping(value="/reader")
	@ResponseBody
	public Object reader(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = readerService.list(page);    //列出reader列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	分数结果
	@RequestMapping(value="/scoreresult")
	@ResponseBody
	public Object scoreresult(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = scoreResultService.list(page);    //列出scoreresult列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
//	考试成功后信息
	@RequestMapping(value="/success")
	@ResponseBody
	public Object success(Page page)throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = successService.list(page);    //列出Liberary列表
		dataMap.put("varList", varList);
		return AppUtil.returnObject(new PageData(), dataMap);
	}
}
