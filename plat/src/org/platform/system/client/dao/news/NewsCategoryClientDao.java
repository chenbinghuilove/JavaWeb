package org.platform.system.client.dao.news;

import java.util.List;

import org.platform.system.entity.news.NewsCategory;

/**
 * 资讯栏目客户端数据操作对象接口。
 * 
 * @author 钱佳明。
 *
 */
public interface NewsCategoryClientDao {

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @param id
	 *            资讯栏目编号。
	 * @return 资讯栏目数据。
	 */
	public NewsCategory get(Integer id);

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @return 资讯栏目数据。
	 */
	public List<NewsCategory> list();

}
