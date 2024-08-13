package com.cxstock.biz.ziliao;

import com.cxstock.biz.ziliao.dto.SpwtDTO;
import com.cxstock.utils.pubutil.Page;

import java.util.List;

public interface SpwtBiz {

	/**
	 * 分页查询用户列表
	 */
	public void findPageKh(Page page);

	/**
	 * 保存/修改用户
	 */
	public void saveOrUpdateKh(SpwtDTO dto);

	/**
	 * 删除用户
	 */
	public void deleteKh(Integer khid);

	/**
	 *  客户下拉列表
	 */
	@SuppressWarnings("unchecked")
	public List findKhComb();


}
