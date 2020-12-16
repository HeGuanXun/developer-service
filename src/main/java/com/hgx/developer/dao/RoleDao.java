package com.hgx.developer.dao;
import java.util.List;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.Role;
import org.apache.ibatis.annotations.Param;
/**
 * Role的Dao接口
 * @author
 */
public interface RoleDao {

	/**
	 * 获得数据的总行数
	 */
	long getRoleRowCount(Assist assist);
	
	/**
	 * 获得Role数据集合
	 */
	List<Role> selectRole(Assist assist);
	/**
	 * 通过Role的id获得对象
	 */
	Role selectRoleById(Integer id);
	
	/**
	 * 获得一个Role对象
	 */
	Role selectRoleObjSingle(Role obj);
	
	/**
	 * 获得一个Role对象集合
	 */
	List<Role> selectRoleByObj(Role obj);


	/**
	 * 插入Role中属性值不为null的数据到数据库
	 */
	int insertNotNullRole(Role value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertRoleByBatch(List<Role> value);
	/**
	 * 通过id删除
	 */
	int deleteRoleById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullRoleById(Role role);
}