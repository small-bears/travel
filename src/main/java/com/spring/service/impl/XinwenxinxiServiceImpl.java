package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.XinwenxinxiMapper;
import com.spring.entity.Xinwenxinxi;
import com.spring.service.XinwenxinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("XinwenxinxiService")
public class XinwenxinxiServiceImpl extends ServiceBase<Xinwenxinxi> implements XinwenxinxiService {
    @Resource
    private XinwenxinxiMapper dao;

    @Override
    protected XinwenxinxiMapper getDao() {
        return dao;
    }
}
