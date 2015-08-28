package org.platform.system.entity.news;

import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * 资讯内容。包含编号、所属栏目、标题、作者、导读、关键字、描述、内容、浏览量、修改日期。
 * 
 * @author 钱佳明。
 *
 */
@Repository
public class NewsContent {

	/**
	 * 编号。
	 */
	private Integer id;

	/**
	 * 所属栏目。
	 */
	private NewsCategory newsCategory;

	/**
	 * 标题。
	 */
	private String title;

	/**
	 * 作者。
	 */
	private String author;

	/**
	 * 导读。
	 */
	private String lead;

	/**
	 * 关键字。
	 */
	private String keywords;

	/**
	 * 描述。
	 */
	private String description;

	/**
	 * 内容。
	 */
	private String content;

	/**
	 * 浏览量。
	 */
	private Integer browse;

	/**
	 * 修改日期。
	 */
	private Date editDate;

	/**
	 * 构造一个空的资讯内容对象。
	 */
	public NewsContent() {
	}

	/**
	 * 构造一个具有编号的资讯内容对象。
	 * 
	 * @param id
	 *            编号。
	 */
	public NewsContent(Integer id) {
		setId(id);
	}

	/**
	 * 返回编号。
	 * 
	 * @return 编号。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置编号。
	 * 
	 * @param id
	 *            编号。
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 返回所属栏目。
	 * 
	 * @return 所属栏目。
	 */
	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	/**
	 * 设置所属栏目。
	 * 
	 * @param newsCategory
	 *            所属栏目。
	 */
	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}

	/**
	 * 返回标题。
	 * 
	 * @return 标题。
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置标题。
	 * 
	 * @param title
	 *            标题。
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回作者。
	 * 
	 * @return 作者。
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 设置作者。
	 * 
	 * @param author
	 *            作者。
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 返回导读。
	 * 
	 * @return 导读。
	 */
	public String getLead() {
		return lead;
	}

	/**
	 * 设置导读。
	 * 
	 * @param lead
	 *            导读。
	 */
	public void setLead(String lead) {
		this.lead = lead;
	}

	/**
	 * 返回关键字。
	 * 
	 * @return 关键字。
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * 设置关键字。
	 * 
	 * @param keywords
	 *            关键字。
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * 返回描述。
	 * 
	 * @return 描述。
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述。
	 * 
	 * @param description
	 *            描述。
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 返回内容。
	 * 
	 * @return 内容。
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容。
	 * 
	 * @param content
	 *            内容。
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 返回浏览量。
	 * 
	 * @return 浏览量。
	 */
	public Integer getBrowse() {
		return browse;
	}

	/**
	 * 设置浏览量。
	 * 
	 * @param browse
	 *            浏览量。
	 */
	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	/**
	 * 返回修改日期。
	 * 
	 * @return 修改日期。
	 */
	public Date getEditDate() {
		return editDate;
	}

	/**
	 * 设置修改日期。
	 * 
	 * @param editDate
	 *            修改日期。
	 */
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

}
