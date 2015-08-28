package org.platform.system.client.service.news;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.platform.system.client.dao.news.NewsCategoryClientDao;
import org.platform.system.entity.news.NewsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资讯栏目客户端服务。
 * 
 * @author 钱佳明。
 *
 */
@Service
public class NewsCategoryClientService implements NewsCategoryClientDao {

	/**
	 * Session工厂。
	 */
	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * 返回资讯栏目数据。
	 * 
	 * @param id
	 *            资讯栏目编号。
	 * @return 资讯栏目数据。
	 */
	public NewsCategory get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			NewsCategory newsCategory = (NewsCategory) session.get(
					NewsCategory.class, id);
			transaction.commit();
			return newsCategory;
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
	 * 返回资讯栏目数据。
	 * 
	 * @return 资讯栏目数据。
	 */
	@SuppressWarnings("unchecked")
	public List<NewsCategory> list() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from NewsCategory newsCategory where newsCategory.visible = true";
			Query query = session.createQuery(hql);
			List<NewsCategory> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

}
