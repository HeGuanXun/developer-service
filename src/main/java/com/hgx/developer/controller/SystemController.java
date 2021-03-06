package com.hgx.developer.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.developer.service.SystemService;
import com.hgx.developer.model.System;
import com.hgx.developer.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "系统",tags = "系统")
@RequestMapping(value = "/system")
@RestController
public class SystemController {

	@Autowired
	private SystemService systemService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<System>> getList(System system) {
		 return HttpJsonResult.ok(systemService.getList(system));
	}

	@ApiOperation("根据id获取system信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<System> getById(Integer id) {
		return HttpJsonResult.ok(systemService.getSystemById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(System system) {
		if(system.getId()!=null){
			try {
				systemService.updateNotNullById(system);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			systemService.saveNotNull(system);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("新增失败！"+e);
		}
		return HttpJsonResult.ok("新增成功！");
	}

	@ApiOperation("删除")
	@GetMapping(value = "/deleteById")
	public HttpJsonResult<String> deleteById(Integer id) {
		try {
			systemService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
