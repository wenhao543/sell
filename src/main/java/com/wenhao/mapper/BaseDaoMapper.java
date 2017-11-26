package com.wenhao.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
/**
 * 公共映射mapper
 * @author Victor.xu
 *
 */
public interface BaseDaoMapper{
	/**
	 * 根据主键查询
	 * @param <T>
	 * @param object
	 * @return
	 */
	Object selectByPrimaryKey(Object object) throws DataAccessException;
	
	/**
	 * 根据条件查询记录条数
	 * @param object
	 * @return
	 */
	int selectCount(Object object) throws DataAccessException;
	
	/**
	 * 分页查询
	 * @param object
	 * @return
	 */
	List<Object> selectByPage(Object object) throws DataAccessException;
	
	/**
	 * 插入
	 * @param object
	 * @return
	 */
	int insert(Object object) throws DataAccessException;
	
	/**
	 * 根据主键更新
	 * @param object
	 * @return
	 */
	int update(Object object) throws DataAccessException;
	
	/**
	 * 根据主键删除
	 * @param object
	 * @return
	 */
	int delete(Object object) throws DataAccessException;
}
