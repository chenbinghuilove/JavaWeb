package org.platform.system.manager.service.news;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.platform.system.entity.news.NewsCategory;
import org.platform.system.manager.dao.news.NewsCategoryManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资讯栏目管理服务。
 * 
 * @author 钱佳明。
 *
 */
@Service
public class NewsCategoryManagerService implements NewsCategoryManagerDao {

	/**
	 * Session工厂。
	 */
	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * 插入资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	public String insert(NewsCategory newsCategory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Date nowDate = new Date();
			newsCategory.setEditDate(nowDate);
			session.save(newsCategory);
			transaction.commit();
			return DO_SUCCESS;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return DO_FAILURE;
		} finally {
			session.close();
		}
	}

	/**
	 * 更新资讯栏目数据。
	 * 
	 * @param newsCategory
	 *            资讯栏目。
	 * @return 操作结果。
	 */
	public String update(NewsCategory newsCategory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Date nowDate = new Date();
			newsCategory.setEditDate(nowDate);
			session.update(newsCategory);
			transaction.commit();
			return DO_SUCCESS;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return DO_FAILURE;
		} finally {
			session.close();
		}
	}

	/**
	 * 删除资讯栏目数据。
	 * 
	 * @param ids
	 *            资讯栏目编号集。
	 * @return 操作结果。
	 */
	public String delete(String ids) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "delete from NewsCategory newsCategory where newsCategory.id in("
					+ ids + ")";
			Query query = session.createQuery(hql);
			int count = query.executeUpdate();
			JSONObject deleteJSON = new JSONObject();
			deleteJSON.put("success", true);
			deleteJSON.put("msg", "成功删除" + count + "条数据!");
			transaction.commit();
			return deleteJSON.toString();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return DO_FAILURE;
		} finally {
			session.close();
		}
	}

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @param id
	 *            资讯栏目编号。
	 * @return 资讯栏目数据。
	 */
	public String get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			NewsCategory newsCategory = (NewsCategory) session.get(
					NewsCategory.class, id);
			if (newsCategory == null) {
				return LOAD_FAILURE;
			}
			JSONObject newsCategoryJSON = new JSONObject();
			JSONObject newsCategoryObject = new JSONObject();
			newsCategoryObject.put("id", newsCategory.getId());
			newsCategoryObject.put("name", newsCategory.getName());
			newsCategoryObject.put("keywords", newsCategory.getKeywords());
			newsCategoryObject
					.put("description", newsCategory.getDescription());
			newsCategoryObject.put("visible", newsCategory.getVisible());
			newsCategoryObject.put("priority", newsCategory.getPriority());
			newsCategoryObject.put("editDate", newsCategory.getEditDate());
			newsCategoryJSON.put("success", true);
			newsCategoryJSON.put("data", newsCategoryObject);
			transaction.commit();
			return newsCategoryJSON.toString();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return LOAD_FAILURE;
		} finally {
			session.close();
		}
	}

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @return 资讯栏目数据。
	 */
	@SuppressWarnings("unchecked")
	public String getAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from NewsCategory newsCategory";
			Query query = session.createQuery(hql);
			List<NewsCategory> list = query.list();
			JSONObject newsCategoryJSON = new JSONObject();
			JSONArray newsCategoryArray = new JSONArray();
			for (int index = 0; index < list.size(); index++) {
				NewsCategory newsCategory = list.get(index);
				JSONObject newsCategoryObject = new JSONObject();
				newsCategoryObject.put("id", newsCategory.getId());
				newsCategoryObject.put("name", newsCategory.getName());
				newsCategoryObject.put("keywords", newsCategory.getKeywords());
				newsCategoryObject.put("description",
						newsCategory.getDescription());
				newsCategoryObject.put("visible", newsCategory.getVisible());
				newsCategoryObject.put("priority", newsCategory.getPriority());
				newsCategoryObject.put("editDate", newsCategory.getEditDate());
				newsCategoryArray.put(newsCategoryObject);
			}
			newsCategoryJSON.put("root", newsCategoryArray);
			transaction.commit();
			return newsCategoryJSON.toString();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return LOAD_FAILURE;
		} finally {
			session.close();
		}
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
	@SuppressWarnings("unchecked")
	public String query(Integer start, Integer limit, String filter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from NewsCategory newsCategory";
			if (filter != null) {
				hql += " where newsCategory.name like '%" + filter + "%'";
				hql += " or newsCategory.keywords like '%" + filter + "%'";
				hql += " or newsCategory.description like '%" + filter + "%'";
			}
			hql += " order by newsCategory.priority desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			List<NewsCategory> list = query.list();
			JSONObject newsCategoryJSON = new JSONObject();
			JSONArray newsCategoryArray = new JSONArray();
			for (int index = 0; index < list.size(); index++) {
				NewsCategory newsCategory = list.get(index);
				JSONObject newsCategoryObject = new JSONObject();
				newsCategoryObject.put("id", newsCategory.getId());
				newsCategoryObject.put("name", newsCategory.getName());
				newsCategoryObject.put("keywords", newsCategory.getKeywords());
				newsCategoryObject.put("description",
						newsCategory.getDescription());
				newsCategoryObject.put("visible", newsCategory.getVisible());
				newsCategoryObject.put("priority", newsCategory.getPriority());
				newsCategoryObject.put("editDate", newsCategory.getEditDate());
				newsCategoryArray.put(newsCategoryObject);
			}
			hql = "select count(*) from NewsCategory";
			query = session.createQuery(hql);
			long count = (long) ((Long) (query.iterate().next())).intValue();
			newsCategoryJSON.put("total", count);
			newsCategoryJSON.put("root", newsCategoryArray);
			transaction.commit();
			return newsCategoryJSON.toString();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return LOAD_FAILURE;
		} finally {
			session.close();
		}
	}

	/**
	 * 返回资讯栏目数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯栏目数据总数。
	 */
	public Long count(String filter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "select count(*) from NewsCategory";
			Query query = session.createQuery(hql);
			transaction.commit();
			return (long) ((Long) (query.iterate().next())).intValue();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return 0L;
		} finally {
			session.close();
		}
	}

}
