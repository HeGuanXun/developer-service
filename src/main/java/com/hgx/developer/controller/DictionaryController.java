package com.hgx.developer.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.developer.service.DictionaryService;
import com.hgx.developer.model.Dictionary;
import com.hgx.developer.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "字典表 ",tags = "字典表 ")
@RequestMapping(value = "/dictionary")
@RestController
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Dictionary>> getList(Dictionary dictionary) {
		 return HttpJsonResult.ok(dictionaryService.getList(dictionary));
	}

	@ApiOperation("根据id获取dictionary信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Dictionary> getById(Integer id) {
		return HttpJsonResult.ok(dictionaryService.getDictionaryById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Dictionary dictionary) {
		if(dictionary.getId()!=null){
			try {
				dictionaryService.updateNotNullById(dictionary);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			dictionaryService.saveNotNull(dictionary);
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
			dictionaryService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
