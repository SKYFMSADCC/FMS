package com.adcc.skyfml.dao;

import com.adcc.skyfml.model.PlanCptWd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * <P>FileName: PlanCptWdDao.java
 * @author GuoXY
 * <P>CreateTime: 2014-06-24
 * <P>Description: 飞行计划航路点风温信息表对象
 * <P>Version: v1.0
 * <P>History:
 */
public interface PlanCptWdDao extends JpaRepository<PlanCptWd, Long> {

    // 2、JPA按方法命名规则自动识别的，自动生成相应的SQL
    // 按ID字段查找对象
    public PlanCptWd findById(int id);
    // 按CPT_NAME字段查找对象
    public PlanCptWd findByCptName(String cptname);
    public void deleteById(int id);

    // 3、自定义SQL
    // 自定义查询语句
    // 下面sql里的表名和字段都要使用我们自己定义的实体名
    @Query("select u from PlanCptWd u where u.cptName like :un")
    public List<PlanCptWd> findByCptnameLike(@Param("un") String cptnamelike);
}