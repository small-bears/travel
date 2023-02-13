package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.MeishifenleiMapper;
import com.spring.entity.Meishifenlei;
import com.spring.service.MeishifenleiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("MeishifenleiService")
public class MeishifenleiServiceImpl extends ServiceBase<Meishifenlei> implements MeishifenleiService {
    @Resource
    private MeishifenleiMapper dao;

    @Override
    protected MeishifenleiMapper getDao() {
        return dao;
    }
}
