package com.adcc.skyfml.dao;

import com.adcc.skyfml.model.CptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Author1:ZhangJianPing  Time:11-9-14,下午5:10
 * Author2:hexun          Date:14-6-20
 * Author3:GuoXY          Date:14-6-23
 */
@Service("cptInfoService")
public class CptInfoServiceImpl implements CptInfoService {
    @Autowired
    private CptInfoDao cptInfoDao;

    // 新增
    // 自动提交事务
    @Transactional
    public CptInfo save(CptInfo cptInfo) {
        return cptInfoDao.save(cptInfo);
    }

    @Transactional
    public Iterable<CptInfo> save(Iterable<CptInfo> cptInfo) {
        return cptInfoDao.save(cptInfo);
    }

    // 新增 + 更新
    @Transactional
    public CptInfo update(CptInfo cptInfo) {
        return cptInfoDao.saveAndFlush(cptInfo);
    }

    @Override
    public long count() {
        return cptInfoDao.count();
    }

    @Transactional
    @Override
    public void delete(CptInfo cptInfo) {
        cptInfoDao.delete(cptInfo);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        cptInfoDao.deleteById(id);
    }

    @Override
    public CptInfo findByCptName(String cptname) { return cptInfoDao.findByCptName(cptname); }

    @Transactional
    @Override
    public void deleteAll() { cptInfoDao.deleteAll(); }

    @Override
    public Iterable<CptInfo> findAll() { return cptInfoDao.findAll(); }

    @Override
    public CptInfo findById(int id) {
        return cptInfoDao.findById(id);
    }

    @Override
    public List<CptInfo> findByCptnameLike(String cptnamelike) {
        return cptInfoDao.findByCptnameLike(cptnamelike);
    }
}
