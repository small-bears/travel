package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.LvyouxianluMapper;
import com.spring.entity.Lvyouxianlu;
import com.spring.service.LvyouxianluService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("LvyouxianluService")
public class LvyouxianluServiceImpl extends ServiceBase<Lvyouxianlu> implements LvyouxianluService {
    @Resource
    private LvyouxianluMapper dao;

    @Override
    protected LvyouxianluMapper getDao() {
        return dao;
    }
}
