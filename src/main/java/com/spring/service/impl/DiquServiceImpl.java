package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.DiquMapper;
import com.spring.entity.Diqu;
import com.spring.service.DiquService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("DiquService")
public class DiquServiceImpl extends ServiceBase<Diqu> implements DiquService {
    @Resource
    private DiquMapper dao;

    @Override
    protected DiquMapper getDao() {
        return dao;
    }
}
