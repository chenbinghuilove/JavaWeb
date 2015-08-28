package org.platform.system.manager.controller.news;

import org.platform.system.entity.news.NewsContent;
import org.platform.system.manager.dao.news.NewsContentManagerDao;
import org.platform.system.manager.service.news.NewsContentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资讯内容管理控制器。
 * 
 * @author 钱佳明。
 *
 */
@Controller
@RequestMapping(value = "manager/newsContent/")
public class NewsContentManagerController implements NewsContentManagerDao {

	/**
	 * 资讯内容管理服务。
	 */
	@Autowired
	public NewsContentManagerService newsContentManagerService;

	/**
	 * 插入资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doInsert", produces = "text/html;charset=utf-8")
	public String insert(NewsContent newsContent) {
		return newsContentManagerService.insert(newsContent);
	}

	/**
	 * 更新资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doUpdate", produces = "text/html;charset=utf-8")
	public String update(NewsContent newsContent) {
		return newsContentManagerService.update(newsContent);
	}

	/**
	 * 删除资讯内容数据。
	 * 
	 * @param ids
	 *            资讯内容编号集。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doDelete", produces = "text/html;charset=utf-8")
	public String delete(
			@RequestParam(value = "ids", required = true) String ids) {
		return newsContentManagerService.delete(ids);
	}

	/**
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            资讯内容编号。
	 * @return 资讯内容数据。
	 */
	@ResponseBody
	@RequestMapping(value = "doGet", produces = "text/html;charset=utf-8")
	public String get(@RequestParam(value = "id", required = true) Integer id) {
		return newsContentManagerService.get(id);
	}

	/**
	 * 返回资讯内容列表数据。
	 * 
	 * @param start
	 *            开始记录。
	 * @param limit
	 *            限制记录。
	 * @param filter
	 *            过滤条件。
	 * @return 资讯内容列表数据。
	 */
	@ResponseBody
	@RequestMapping(value = "doQuery", produces = "text/html;charset=utf-8")
	public String query(
			@RequestParam(value = "start", required = true) Integer start,
			@RequestParam(value = "limit", required = true) Integer limit,
			@RequestParam(value = "filter", required = false) String filter) {
		return newsContentManagerService.query(start, limit, filter);
	}

	/**
	 * 返回资讯内容数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯内容数据总数。
	 */
	@ResponseBody
	@RequestMapping(value = "doCount", produces = "text/html;charset=utf-8")
	public Long count(
			@RequestParam(value = "filter", required = false) String filter) {
		return null;
	}

}
