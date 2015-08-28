package org.platform.system.client.dao.news;

import java.util.List;

import org.platform.system.entity.news.NewsContent;

/**
 * 资讯内容客户端数据操作接口。
 * 
 * @author 钱佳明。
 *
 */
public interface NewsContentClientDao {

	/**
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            资讯内容编号。
	 * @return 资讯内容数据。
	 */
	public NewsContent get(Integer id);

	/**
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            所属栏目编号。
	 * @param start
	 *            开始记录。
	 * @param limit
	 *            限制记录。
	 * @return 资讯内容数据。
	 */
	public List<NewsContent> list(Integer id, Integer start, Integer limit);

}
