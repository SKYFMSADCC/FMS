package com.adcc.skyfml.dao;

import com.adcc.skyfml.model.PlanCptWd;
import java.util.List;


/**
 * Author1:ZhangJianPing  Time:11-9-14,下午5:10
 * Author2:hexun          Date:14-6-20
 * Author3:GuoXY          Date:14-6-23
 */
public interface PlanCptWdService {
    // 增加
    public PlanCptWd save(PlanCptWd planCptWd);
    public Iterable<PlanCptWd> save(Iterable<PlanCptWd> planCptWdIter);
    // 更新
    public PlanCptWd update(PlanCptWd planCptWd);
    // 计算总记录数
    long count();
    // 按给定对象删除
    public void delete(PlanCptWd planCptWd);
    // 按对象ID删除
    public void deleteById(int id);
    // 清空表数据
    public void deleteAll();

    // 查询所有记录
    public Iterable<PlanCptWd> findAll();
    // 按ID查找
    public PlanCptWd findById(int id);
    // 按属性CPTNAME所对象的字段查找
    public PlanCptWd findByCptName(String cptname);
    // 自定义查询
    public List<PlanCptWd> findByCptnameLike(String cptnamelike);
}
