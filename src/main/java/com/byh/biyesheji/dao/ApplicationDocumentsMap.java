package com.byh.biyesheji.dao;

import com.byh.biyesheji.entity.ApplicationDocuments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ApplicationDocuments)表数据库访问层
 *
 * @author sunming
 * @since 2024-03-16 11:00:50
 */
public interface ApplicationDocumentsMap extends CrudDao<ApplicationDocuments>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ApplicationDocuments queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param applicationDocuments 查询条件
     * @return 总行数
     */
    long count(ApplicationDocuments applicationDocuments);

    /**
     * 新增数据
     *
     * @param applicationDocuments 实例对象
     * @return 影响行数
     */
    int insert(ApplicationDocuments applicationDocuments);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ApplicationDocuments> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ApplicationDocuments> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ApplicationDocuments> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ApplicationDocuments> entities);

    /**
     * 修改数据
     *
     * @param applicationDocuments 实例对象
     * @return 影响行数
     */
    int update(ApplicationDocuments applicationDocuments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据条件查询数据，并且排序
     * @param applicationDocuments
     * @return
     */
    List<ApplicationDocuments>  queryAll(ApplicationDocuments applicationDocuments);

}

