package com.hgx.developer.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.developer.service.UserService;
import com.hgx.developer.model.User;
import com.hgx.developer.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "用户",tags = "用户")
@RequestMapping(value = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<User>> getList(User user) {
		 return HttpJsonResult.ok(userService.getList(user));
	}

	@ApiOperation("根据id获取user信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<User> getById(Integer id) {
		return HttpJsonResult.ok(userService.getUserById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(User user) {
		if(user.getId()!=null){
			try {
				userService.updateNotNullById(user);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			userService.saveNotNull(user);
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
			userService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
