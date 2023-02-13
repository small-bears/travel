package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.DifangmeishiMapper;
import com.spring.entity.Difangmeishi;
import com.spring.service.DifangmeishiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("DifangmeishiService")
public class DifangmeishiServiceImpl extends ServiceBase<Difangmeishi> implements DifangmeishiService {
    @Resource
    private DifangmeishiMapper dao;

    @Override
    protected DifangmeishiMapper getDao() {
        return dao;
    }
}
