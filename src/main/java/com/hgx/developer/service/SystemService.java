package com.hgx.developer.service;
import java.util.List;
import com.hgx.developer.model.System;

/**
 * System的服务接口
 * @author
 */
public interface SystemService {
	/**
	 * 获得所以数据集
	 */
	List<System> getList(System system);

	/**
	 * 获取System信息
	 */
	System getSystemById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(System system);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(System system);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
