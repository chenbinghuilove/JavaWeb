package org.platform.system.manager.dao.news;

import org.platform.system.entity.news.NewsContent;
import org.platform.system.manager.dao.ManagerDao;

/**
 * 资讯内容管理数据操作对象接口。
 * 
 * @author 钱佳明。
 *
 */
public interface NewsContentManagerDao extends ManagerDao {

	/**
	 * 插入资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	public String insert(NewsContent newsContent);

	/**
	 * 更新资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	public String update(NewsContent newsContent);

	/**
	 * 删除资讯内容数据。
	 * 
	 * @param ids
	 *            资讯内容编号集。
	 * @return 操作结果。
	 */
	public String delete(String ids);

	/**
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            资讯内容编号。
	 * @return 资讯内容数据。
	 */
	public String get(Integer id);

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
	public String query(Integer start, Integer limit, String filter);

	/**
	 * 返回资讯内容数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯内容数据总数。
	 */
	public Long count(String filter);

}
