package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.JingdianxinxiMapper;
import com.spring.entity.Jingdianxinxi;
import com.spring.service.JingdianxinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("JingdianxinxiService")
public class JingdianxinxiServiceImpl extends ServiceBase<Jingdianxinxi> implements JingdianxinxiService {
    @Resource
    private JingdianxinxiMapper dao;

    @Override
    protected JingdianxinxiMapper getDao() {
        return dao;
    }
}
