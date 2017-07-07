package com.fh.service.itemBank.itembank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("itembankService")
public class ItemBankService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("ItemBankMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("ItemBankMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("ItemBankMapper.edit", pd);
	}
	
//	/*
//	*列表
//	*/
//	public List<PageData> list(Page page)throws Exception{
//		List<PageData> list = (List<PageData>)dao.findForList("ItemBankMapper.datalistPage", page);
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Integer> litInt = new LinkedList<Integer>();
//		List<Integer> litInt1 = new LinkedList<Integer>();
//		List<Integer> litInt2 = new LinkedList<Integer>();
//		List<Integer> litInt3 = new LinkedList<Integer>();
//
//		for (int i =0 ;i < list.size(); i++){
//
//				map = list.get(i);
//			if (map.get(6) == 0) {
//				litInt.add((Integer) map.get(6));
//			}
//
//		}
//		return null;
//	}
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{

		return (List<PageData>)dao.findForList("ItemBankMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ItemBankMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ItemBankMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ItemBankMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

