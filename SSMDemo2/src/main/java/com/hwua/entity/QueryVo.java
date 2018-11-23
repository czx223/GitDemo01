package com.hwua.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: QueryVo
 * @Description:TODO(绑定包装类)
 * @author: maple
 * @date: 2018年11月20日 下午3:53:02
 * 
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved.
 *             注意：本内容仅限于海文科信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class QueryVo {
	private Items items;
	private String[] ids; // 多个id
	private List<Items> itemsList = new ArrayList<Items>();

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

}
