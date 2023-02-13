package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.YudingMapper;
import com.spring.entity.Yuding;
import com.spring.service.YudingService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("YudingService")
public class YudingServiceImpl extends ServiceBase<Yuding> implements YudingService {
    @Resource
    private YudingMapper dao;

    @Override
    protected YudingMapper getDao() {
        return dao;
    }
}
