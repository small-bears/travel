package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.XinwenfenleiMapper;
import com.spring.entity.Xinwenfenlei;
import com.spring.service.XinwenfenleiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("XinwenfenleiService")
public class XinwenfenleiServiceImpl extends ServiceBase<Xinwenfenlei> implements XinwenfenleiService {
    @Resource
    private XinwenfenleiMapper dao;

    @Override
    protected XinwenfenleiMapper getDao() {
        return dao;
    }
}
