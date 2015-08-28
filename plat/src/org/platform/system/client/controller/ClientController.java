package org.platform.system.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.platform.system.client.service.news.NewsCategoryClientService;
import org.platform.system.client.service.news.NewsContentClientService;
import org.platform.system.entity.news.NewsCategory;
import org.platform.system.entity.news.NewsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 客户端控制器。
 * 
 * @author 钱佳明。
 *
 */
@Controller
public class ClientController {

	/**
	 * 资讯栏目客户端服务。
	 */
	@Autowired
	public NewsCategoryClientService newsCategoryClientService;

	/**
	 * 资讯内容客户端服务。
	 */
	@Autowired
	public NewsContentClientService newsContentClientService;

	/**
	 * 返回首页。
	 * 
	 * @param map
	 *            数据集。
	 * @return 首页。
	 */
	@RequestMapping(value = "home")
	public String showIndex(Map<String, Object> map) {
		List<NewsCategory> newsCategoryList = newsCategoryClientService.list();
		List<NewsContent> newsContentList = new ArrayList<NewsContent>();
		for (int index = 0; index < newsCategoryList.size(); index++) {
			Integer id = newsCategoryList.get(index).getId();
			newsContentList.addAll(newsContentClientService.list(id, 0, 10));
		}
		map.put("newsCategoryList", newsCategoryList);
		map.put("newsContentList", newsContentList);
		return "index";
	}

	/**
	 * 返回列表页。
	 * 
	 * @param map
	 *            数据集。
	 * @param id
	 *            资讯栏目编号。
	 * @return 列表页。
	 */
	@RequestMapping(value = "list")
	public String showList(Map<String, Object> map,
			@RequestParam(value = "id", required = true) Integer id) {
		map.put("newsCategory", newsCategoryClientService.get(id));
		map.put("newsCategoryList", newsCategoryClientService.list());
		map.put("newsContentList", newsContentClientService.list(id, 0, 10));
		return "list";
	}

	/**
	 * 返回内容页。
	 * 
	 * @param map
	 *            数据集。
	 * @param id
	 *            资讯内容编号。
	 * @return 内容页。
	 */
	@RequestMapping(value = "content")
	public String showContent(Map<String, Object> map,
			@RequestParam(value = "id", required = true) Integer id) {
		map.put("newsCategoryList", newsCategoryClientService.list());
		map.put("newsContent", newsContentClientService.get(id));
		return "content";
	}

}
