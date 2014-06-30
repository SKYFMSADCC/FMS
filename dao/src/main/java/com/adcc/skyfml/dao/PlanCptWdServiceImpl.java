package com.adcc.skyfml.dao;

import com.adcc.skyfml.model.PlanCptWd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Author1:ZhangJianPing  Time:11-9-14,下午5:10
 * Author2:hexun          Date:14-6-20
 * Author3:GuoXY          Date:14-6-23
 */
@Service("planCptWdService")
public class PlanCptWdServiceImpl implements PlanCptWdService {
    @Autowired
    private PlanCptWdDao planCptWdDao;

    // 新增
    // 自动提交事务
    @Transactional
    public PlanCptWd save(PlanCptWd planCptWd) {
        System.out.println("--------------\n" + planCptWd);
        return planCptWdDao.save(planCptWd);
    }

    @Transactional
    public Iterable<PlanCptWd> save(Iterable<PlanCptWd> planCptWdIter) {
        return planCptWdDao.save(planCptWdIter);
    }

    // 新增 + 更新
    @Transactional
    public PlanCptWd update(PlanCptWd planCptWd) {
        return planCptWdDao.saveAndFlush(planCptWd);
    }

    @Override
    public long count() {
        return planCptWdDao.count();
    }

    @Transactional
    @Override
    public void delete(PlanCptWd planCptWd) {
        planCptWdDao.delete(planCptWd);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        planCptWdDao.deleteById(id);
    }

    @Override
    public PlanCptWd findByCptName(String cptname) { return planCptWdDao.findByCptName(cptname); }

    @Transactional
    @Override
    public void deleteAll() { planCptWdDao.deleteAll(); }

    @Override
    public Iterable<PlanCptWd> findAll() { return planCptWdDao.findAll(); }

    @Override
    public PlanCptWd findById(int id) {
        return planCptWdDao.findById(id);
    }

    @Override
    public List<PlanCptWd> findByCptnameLike(String cptnamelike) {
        return planCptWdDao.findByCptnameLike(cptnamelike);
    }
}
