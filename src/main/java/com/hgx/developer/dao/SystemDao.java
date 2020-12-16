package com.hgx.developer.dao;
import java.util.List;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.System;
import org.apache.ibatis.annotations.Param;
/**
 * System的Dao接口
 * @author
 */
public interface SystemDao {

	/**
	 * 获得数据的总行数
	 */
	long getSystemRowCount(Assist assist);
	
	/**
	 * 获得System数据集合
	 */
	List<System> selectSystem(Assist assist);
	/**
	 * 通过System的id获得对象
	 */
	System selectSystemById(Integer id);
	
	/**
	 * 获得一个System对象
	 */
	System selectSystemObjSingle(System obj);
	
	/**
	 * 获得一个System对象集合
	 */
	List<System> selectSystemByObj(System obj);


	/**
	 * 插入System中属性值不为null的数据到数据库
	 */
	int insertNotNullSystem(System value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertSystemByBatch(List<System> value);
	/**
	 * 通过id删除
	 */
	int deleteSystemById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullSystemById(System system);
}