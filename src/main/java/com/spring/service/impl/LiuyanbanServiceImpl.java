package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.LiuyanbanMapper;
import com.spring.entity.Liuyanban;
import com.spring.service.LiuyanbanService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("LiuyanbanService")
public class LiuyanbanServiceImpl extends ServiceBase<Liuyanban> implements LiuyanbanService {
    @Resource
    private LiuyanbanMapper dao;

    @Override
    protected LiuyanbanMapper getDao() {
        return dao;
    }
}
