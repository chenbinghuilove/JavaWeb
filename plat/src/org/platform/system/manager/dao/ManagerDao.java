package org.platform.system.manager.dao;

/**
 * 管理数据操作对象接口。
 * 
 * @author 钱佳明。
 *
 */
public interface ManagerDao {

	/**
	 * 数据提交操作成功字段。
	 */
	public static final String DO_SUCCESS = "{success:true,msg:'数据提交成功!'}";

	/**
	 * 数据提交操作失败字段。
	 */
	public static final String DO_FAILURE = "{failure:true,msg:'数据提交失败!请重试!'}";

	/**
	 * 数据读取操作成功字段。
	 */
	public static final String LOAD_SUCCESS = "{success:true,msg:'数据读取成功!'}";

	/**
	 * 数据读取操作失败字段。
	 */
	public static final String LOAD_FAILURE = "{failure:true,msg:'数据读取失败!请重试!'}";

}
