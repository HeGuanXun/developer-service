package com.hgx.developer.service;
import java.util.List;
import com.hgx.developer.model.Role;

/**
 * Role的服务接口
 * @author
 */
public interface RoleService {
	/**
	 * 获得所以数据集
	 */
	List<Role> getList(Role role);

	/**
	 * 获取Role信息
	 */
	Role getRoleById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Role role);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Role role);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
