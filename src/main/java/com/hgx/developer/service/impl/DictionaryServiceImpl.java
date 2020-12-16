package com.hgx.developer.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.developer.service.DictionaryService;
import com.hgx.developer.dao.DictionaryDao;
import com.hgx.developer.utils.Assist;
import com.hgx.developer.model.Dictionary;
/**
 * Dictionary的服务接口的实现类
 * @author
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	public List<Dictionary> getList(Dictionary dictionary) {
		return dictionaryDao.selectDictionary(null);
	}
	@Override
	public Dictionary getDictionaryById(Integer id) {
		return dictionaryDao.selectDictionaryById(id);
	}

	@Override
	public String saveNotNull(Dictionary dictionary) {
		if (dictionary == null) {
			return Assist.resultFormat(Assist.C500, "dictionary不能为null");
		}
		if(dictionary.getCreateBy() == null || dictionary.getCreateTime() == null || dictionary.getUpdateBy() == null || dictionary.getUpdateTime() == null  ){
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = dictionaryDao.insertNotNullDictionary(dictionary);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Dictionary dictionary) {
		if (dictionary == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = dictionaryDao.updateNotNullDictionaryById(dictionary);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id) {
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = dictionaryDao.deleteDictionaryById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}