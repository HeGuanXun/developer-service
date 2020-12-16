package com.hgx.developer.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.developer.service.RoleService;
import com.hgx.developer.dao.RoleDao;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.Role;
/**
 * Role的服务接口的实现类
 * @author
 */
@Service
public class RoleServiceImpl implements RoleService {

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getList(Role role) {
		return roleDao.selectRole(null);
	}
	@Override
	public Role getRoleById(Integer id) {
		return roleDao.selectRoleById(id);
	}

	@Override
	public String saveNotNull(Role role) {
		if (role == null) {
			return Assist.resultFormat(Assist.C500, "role不能为null");
		}
		if(role.getRoleName() == null  ){
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = roleDao.insertNotNullRole(role);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Role role) {
		if (role == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = roleDao.updateNotNullRoleById(role);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id) {
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = roleDao.deleteRoleById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}