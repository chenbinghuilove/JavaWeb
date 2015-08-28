package org.platform.system.manager.dao.news;

import org.platform.system.entity.news.NewsCategory;
import org.platform.system.manager.dao.ManagerDao;

/**
 * 资讯栏目管理数据操作对象接口。
 * 
 * @author 钱佳明。
 *
 */
public interface NewsCategoryManagerDao extends ManagerDao {

	/**
	 * 插入资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	public String insert(NewsCategory newsCategory);

	/**
	 * 更新资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	public String update(NewsCategory newsCategory);

	/**
	 * 删除资讯栏目数据。
	 * 
	 * @param ids
	 *            资讯栏目编号集。
	 * @return 操作结果。
	 */
	public String delete(String ids);

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @param id
	 *            资讯栏目编号。
	 * @return 资讯栏目数据。
	 */
	public String get(Integer id);

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @return 资讯栏目数据。
	 */
	public String getAll();

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
	public String query(Integer start, Integer limit, String filter);

	/**
	 * 返回资讯栏目数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯栏目数据总数。
	 */
	public Long count(String filter);

}
