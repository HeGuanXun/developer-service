package com.hgx.developer.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.developer.service.RoleService;
import com.hgx.developer.model.Role;
import com.hgx.developer.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "角色",tags = "角色")
@RequestMapping(value = "/role")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Role>> getList(Role role) {
		 return HttpJsonResult.ok(roleService.getList(role));
	}

	@ApiOperation("根据id获取role信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Role> getById(Integer id) {
		return HttpJsonResult.ok(roleService.getRoleById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Role role) {
		if(role.getId()!=null){
			try {
				roleService.updateNotNullById(role);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			roleService.saveNotNull(role);
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
			roleService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
