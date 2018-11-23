package com.hwua.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.hwua.biz.ItemsBiz;
import com.hwua.dao.ItemsMapper;
import com.hwua.entity.Items;

@Service("itemsBiz")
public class ItemsBizImpl implements ItemsBiz {
	@Autowired
	private ItemsMapper imapper;

	public List<Items> getItemsList() {
		// TODO Auto-generated method stub
		return imapper.getItemsList();
	}

	public Items getItemById(int id) {
		// TODO Auto-generated method stub
		return imapper.selectByPrimaryKey(id);
	}

	public boolean updateItem(Items items) {
		int num=imapper.updateByPrimaryKeySelective(items);
		return (num>0)?true:false;
	}

	public boolean delItem(Integer id) {
		int num=imapper.deleteByPrimaryKey(id);
		return (num>0)?true:false;
	}

	public boolean addItem(Items items) {
		int num=imapper.insert(items);
		return (num>0)?true:false;
	}

	@Override
	public boolean delItem(String[] ids) {
		int row=0;
		int num=0;
		for(int i=0;i<ids.length;i++) {
			row=imapper.deleteByPrimaryKey(new Integer(ids[i]));
			if(row>0) {
				num++;
			}
		}
		
		return (num == ids.length)?true:false;
	}
	 

}
