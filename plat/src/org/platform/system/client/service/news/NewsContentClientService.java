package org.platform.system.client.service.news;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.platform.system.client.dao.news.NewsContentClientDao;
import org.platform.system.entity.news.NewsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资讯内容客户端服务。
 * 
 * @author 钱佳明。
 *
 */
@Service
public class NewsContentClientService implements NewsContentClientDao {

	/**
	 * Session工厂。
	 */
	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * 返回资讯内容数据。
	 * 
	 * @param id
	 *            资讯内容编号。
	 * @return 资讯内容数据。
	 */
	public NewsContent get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			NewsContent newsContent = (NewsContent) session.get(
					NewsContent.class, id);
			transaction.commit();
			return newsContent;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

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
	@SuppressWarnings("unchecked")
	public List<NewsContent> list(Integer id, Integer start, Integer limit) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from NewsContent newsContent where newsContent.newsCategory.id = "
					+ id + " order by newsContent.editDate desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			List<NewsContent> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

}
