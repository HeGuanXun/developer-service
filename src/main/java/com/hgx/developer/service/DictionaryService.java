package com.hgx.developer.service;
import java.util.List;
import com.hgx.developer.model.Dictionary;

/**
 * Dictionary的服务接口
 * @author
 */
public interface DictionaryService {
	/**
	 * 获得所以数据集
	 */
	List<Dictionary> getList(Dictionary dictionary);

	/**
	 * 获取Dictionary信息
	 */
	Dictionary getDictionaryById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Dictionary dictionary);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Dictionary dictionary);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
