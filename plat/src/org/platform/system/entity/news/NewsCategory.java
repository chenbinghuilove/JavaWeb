package org.platform.system.entity.news;

import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * 资讯栏目。包含编号、名称、关键字、描述、可见性、优先级、修改日期。
 * 
 * @author 钱佳明。
 *
 */
@Repository
public class NewsCategory {

	/**
	 * 编号。
	 */
	private Integer id;

	/**
	 * 名称。
	 */
	private String name;

	/**
	 * 关键字。
	 */
	private String keywords;

	/**
	 * 描述。
	 */
	private String description;

	/**
	 * 可见性。
	 */
	private Boolean visible;

	/**
	 * 优先级。
	 */
	private Integer priority;

	/**
	 * 修改日期。
	 */
	private Date editDate;

	/**
	 * 构造一个空的资讯栏目对象。
	 */
	public NewsCategory() {

	}

	/**
	 * 构造一个具有编号的资讯栏目对象。
	 * 
	 * @param id
	 *            编号。
	 */
	public NewsCategory(Integer id) {
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
	 * 返回名称。
	 * 
	 * @return 名称。
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称。
	 * 
	 * @param name
	 *            名称。
	 */
	public void setName(String name) {
		this.name = name;
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
	 * 返回可见性。
	 * 
	 * @return 可见性。
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * 设置可见性。
	 * 
	 * @param visible
	 *            可见性。
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * 返回优先级。
	 * 
	 * @return 优先级。
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * 设置优先级。
	 * 
	 * @param priority
	 *            优先级。
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
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
