package org.platform.system.manager.service.news;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.platform.system.entity.news.NewsContent;
import org.platform.system.manager.dao.news.NewsContentManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资讯内容管理服务。
 * 
 * @author 钱佳明。
 *
 */
@Service
public class NewsContentManagerService implements NewsContentManagerDao {

	/**
	 * Session工厂。
	 */
	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * 插入资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	public String insert(NewsContent newsContent) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Date nowDate = new Date();
			newsContent.setEditDate(nowDate);
			session.save(newsContent);
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
	 * 更新资讯内容数据。
	 * 
	 * @param newsContent
	 *            资讯内容。
	 * @return 操作结果。
	 */
	public String update(NewsContent newsContent) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Date nowDate = new Date();
			newsContent.setEditDate(nowDate);
			session.update(newsContent);
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
	 * 删除资讯内容数据。
	 * 
	 * @param ids
	 *            资讯内容编号集。
	 * @return 操作结果。
	 */
	public String delete(String ids) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "delete from NewsContent newsContent where newsContent.id in("
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
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            资讯内容编号。
	 * @return 资讯内容数据。
	 */
	public String get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			NewsContent newsContent = (NewsContent) session.get(
					NewsContent.class, id);
			if (newsContent == null) {
				return LOAD_FAILURE;
			}
			JSONObject newsContentJSON = new JSONObject();
			JSONObject newsContentObject = new JSONObject();
			newsContentObject.put("id", newsContent.getId());
			newsContentObject.put("newsCategory.id", newsContent
					.getNewsCategory().getId());
			newsContentObject.put("newsCategory.name", newsContent
					.getNewsCategory().getName());
			newsContentObject.put("title", newsContent.getTitle());
			newsContentObject.put("author", newsContent.getAuthor());
			newsContentObject.put("lead", newsContent.getLead());
			newsContentObject.put("keywords", newsContent.getKeywords());
			newsContentObject.put("description", newsContent.getDescription());
			newsContentObject.put("content", newsContent.getContent());
			newsContentObject.put("browse", newsContent.getBrowse());
			newsContentObject.put("editDate", newsContent.getEditDate());
			newsContentJSON.put("success", true);
			newsContentJSON.put("data", newsContentObject);
			transaction.commit();
			return newsContentJSON.toString();
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
	@SuppressWarnings("unchecked")
	public String query(Integer start, Integer limit, String filter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from NewsContent newsContent";
			if (filter != null) {
				hql += " where newsContent.title like '%" + filter + "%'";
				hql += " or newsContent.author like '%" + filter + "%'";
				hql += " or newsContent.lead like '%" + filter + "%'";
				hql += " or newsContent.keywords like '%" + filter + "%'";
				hql += " or newsContent.description like '%" + filter + "%'";
				hql += " or newsContent.content like '%" + filter + "%'";
			}
			hql += " order by newsContent.editDate desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			List<NewsContent> list = query.list();
			JSONObject newsContentJSON = new JSONObject();
			JSONArray newsContentArray = new JSONArray();
			for (int index = 0; index < list.size(); index++) {
				NewsContent newsContent = list.get(index);
				JSONObject newsContentObject = new JSONObject();
				newsContentObject.put("id", newsContent.getId());
				newsContentObject.put("newsCategory.id", newsContent
						.getNewsCategory().getId());
				newsContentObject.put("newsCategory.name", newsContent
						.getNewsCategory().getName());
				newsContentObject.put("title", newsContent.getTitle());
				newsContentObject.put("author", newsContent.getAuthor());
				newsContentObject.put("lead", newsContent.getLead());
				newsContentObject.put("keywords", newsContent.getKeywords());
				newsContentObject.put("description",
						newsContent.getDescription());
				if (newsContent.getContent().length() > 100) {
					newsContent.setContent(newsContent.getContent().substring(
							0, 100));
				}
				newsContentObject.put("content", newsContent.getContent());
				newsContentObject.put("browse", newsContent.getBrowse());
				newsContentObject.put("editDate", newsContent.getEditDate());
				newsContentArray.put(newsContentObject);
			}
			hql = "select count(*) from NewsContent";
			query = session.createQuery(hql);
			long count = (long) ((Long) (query.iterate().next())).intValue();
			newsContentJSON.put("total", count);
			newsContentJSON.put("root", newsContentArray);
			transaction.commit();
			return newsContentJSON.toString();
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
	 * 返回资讯内容数据总数。
	 * 
	 * @param filter
	 *            过滤条件。
	 * @return 资讯内容数据总数。
	 */
	public Long count(String filter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "select count(*) from NewsContent";
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
