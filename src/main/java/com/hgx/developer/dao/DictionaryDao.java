package com.hgx.developer.dao;
import java.util.List;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.Dictionary;
import org.apache.ibatis.annotations.Param;
/**
 * Dictionary的Dao接口
 * @author
 */
public interface DictionaryDao {

	/**
	 * 获得数据的总行数
	 */
	long getDictionaryRowCount(Assist assist);
	
	/**
	 * 获得Dictionary数据集合
	 */
	List<Dictionary> selectDictionary(Assist assist);
	/**
	 * 通过Dictionary的id获得对象
	 */
	Dictionary selectDictionaryById(Integer id);
	
	/**
	 * 获得一个Dictionary对象
	 */
	Dictionary selectDictionaryObjSingle(Dictionary obj);
	
	/**
	 * 获得一个Dictionary对象集合
	 */
	List<Dictionary> selectDictionaryByObj(Dictionary obj);


	/**
	 * 插入Dictionary中属性值不为null的数据到数据库
	 */
	int insertNotNullDictionary(Dictionary value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertDictionaryByBatch(List<Dictionary> value);
	/**
	 * 通过id删除
	 */
	int deleteDictionaryById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullDictionaryById(Dictionary dictionary);
}