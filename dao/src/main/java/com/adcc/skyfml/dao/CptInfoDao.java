package com.adcc.skyfml.dao;


import com.adcc.skyfml.model.CptInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Author1:ZhangJianPing  Time:11-9-4,下午8:50
 * Author2:hexun          Date:14-6-20
 * Author3:GuoXY          Date:14-6-23
 */
public interface CptInfoDao extends JpaRepository<CptInfo, Long> {

    // 1、父类已实现的方法直接使用就行（不止这些，有待挖掘）
//    public void delete(CptInfo cptInfo);
//    public void deleteAll();
//    public List<CptInfo> findAll();
//    long count();

    // 2、JPA按方法命名规则自动识别的，自动生成相应的SQL
    // 按ID字段查找对象
    public CptInfo findById(int id);
    // 按CPT_NAME字段查找对象
    public CptInfo findByCptName(String cptname);
    public void deleteById(int id);

    // 3、自定义SQL
    // 自定义查询语句
    // 下面sql里的表名和字段都要使用我们自己定义的实体名
    @Query("select u from CptInfo u where u.cptName like :un")
    public List<CptInfo> findByCptnameLike(@Param("un") String cptnamelike);
}