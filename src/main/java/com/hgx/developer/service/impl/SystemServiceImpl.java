package com.hgx.developer.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.developer.service.SystemService;
import com.hgx.developer.dao.SystemDao;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.System;
/**
 * System的服务接口的实现类
 * @author
 */
@Service
public class SystemServiceImpl implements SystemService {

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private SystemDao systemDao;

	@Override
	public List<System> getList(System system) {
		return systemDao.selectSystem(null);
	}
	@Override
	public System getSystemById(Integer id) {
		return systemDao.selectSystemById(id);
	}

	@Override
	public String saveNotNull(System system) {
		if (system == null) {
			return Assist.resultFormat(Assist.C500, "system不能为null");
		}
		int result = systemDao.insertNotNullSystem(system);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(System system) {
		if (system == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = systemDao.updateNotNullSystemById(system);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id) {
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = systemDao.deleteSystemById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}