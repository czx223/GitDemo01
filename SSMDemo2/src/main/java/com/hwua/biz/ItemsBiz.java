package com.hwua.biz;

import java.util.List;

import com.hwua.entity.Items;
import com.hwua.entity.QueryVo;

public interface ItemsBiz {
	
	/**
     * 
     * @Title: getItemsList  实现商品查询列表
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return  
     * @return: List<Items>      
     * @throws
     */
    List<Items> getItemsList();
    /**
     * 
     * @Title: getItemById   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param id
     * @param: @return  
     * @return: Items      
     * @throws
     */
    public Items getItemById(int id);
    /**
     * 
     * @Title: updateItem   
     * @Description: TODO(修改操作)   
     * @param: @param items
     * @param: @return  
     * @return: boolean      
     * @throws
     */
    public boolean updateItem(Items items);
    
    /**
     * 删除Item 通过id
     * @param id
     * @return
     * boolean 型
     */
    public boolean delItem(Integer id);
    
    
    
    /**
     * 删除多个item
     * @param ids
     * @return
     */
    public boolean delItem(String[] ids);

    
    /**
     * 添加Items
     * @param items
     * @return
     */
    public boolean addItem(Items items);
    
    
    
}
