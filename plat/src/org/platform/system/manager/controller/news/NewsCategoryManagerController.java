package org.platform.system.manager.controller.news;

import org.platform.system.entity.news.NewsCategory;
import org.platform.system.manager.dao.news.NewsCategoryManagerDao;
import org.platform.system.manager.service.news.NewsCategoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资讯栏目管理控制器。
 * 
 * @author 钱佳明。
 *
 */
@Controller
@RequestMapping(value = "manager/newsCategory/")
public class NewsCategoryManagerController implements NewsCategoryManagerDao {

	/**
	 * 资讯栏目管理服务。
	 */
	@Autowired
	public NewsCategoryManagerService newsCategoryManagerService;

	/**
	 * 插入资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doInsert", produces = "text/html;charset=utf-8")
	public String insert(NewsCategory newsCategory) {
		return newsCategoryManagerService.insert(newsCategory);
	}

	/**
	 * 更新资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doUpdate", produces = "text/html;charset=utf-8")
	public String update(NewsCategory newsCategory) {
		return newsCategoryManagerService.update(newsCategory);
	}

	/**
	 * 删除资讯栏目数据。
	 * 
	 * @param ids
	 *            资讯栏目编号集。
	 * @return 操作结果。
	 */
	@ResponseBody
	@RequestMapping(value = "doDelete", produces = "text/html;charset=utf-8")
	public String delete(
			@RequestParam(value = "ids", required = true) String ids) {
		return newsCategoryManagerService.delete(ids);
	}

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @param id
	 *            资讯栏目编号。
	 * @return 资讯栏目数据。
	 */
	@ResponseBody
	@RequestMapping(value = "doGet", produces = "text/html;charset=utf-8")
	public String get(@RequestParam(value = "id", required = true) Integer id) {
		return newsCategoryManagerService.get(id);
	}

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @return 资讯栏目数据。
	 */
	@ResponseBody
	@RequestMapping(value = "doGetAll", produces = "text/html;charset=utf-8")
	public String getAll() {
		return newsCategoryManagerService.getAll();
	}

	/**
	 * 返回资讯栏目列表数据。
	 * 
	 * @param start
	 *            开始记录。
	 * @param limit
	 *            限制记录。
	 * @param filter
	 *            过滤条件。
	 * @return 资讯栏目列表数据。
	 */
	@ResponseBody
	@RequestMapping(value = "doQuery", produces = "text/html;charset=utf-8")
	public String query(
			@RequestParam(value = "start", required = true) Integer start,
			@RequestParam(value = "limit", required = true) Integer limit,
			@RequestParam(value = "filter", required = false) String filter) {
		return newsCategoryManagerService.query(start, limit, filter);
	}

	/**
	 * 返回资讯栏目数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯栏目数据总数。
	 */
	@ResponseBody
	@RequestMapping(value = "doCount", produces = "text/html;charset=utf-8")
	public Long count(
			@RequestParam(value = "filter", required = false) String filter) {
		return newsCategoryManagerService.count(filter);
	}

}
