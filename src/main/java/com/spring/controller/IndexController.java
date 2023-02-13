package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.*;
import java.util.*;
import dao.CommDAO;
import net.jntoo.db.Query;
import com.alibaba.fastjson.*;

/**
 * 首页控制器
 */
@Controller
public class IndexController extends BaseController{

    // 首页
    @RequestMapping(value = {"/" , "index"})
    public String Index()
    {
                    
            ArrayList<HashMap> bhtList = Query.make("lunbotu").order("id desc").limit(5).select();
            assign("bhtList" , bhtList);
            
            
            ArrayList<HashMap> jingdianxinxilist1 = Query.make("jingdianxinxi").limit(4).order("liulanliang desc").select();
            assign("jingdianxinxilist1" , jingdianxinxilist1);
            
            
            ArrayList<HashMap> difangmeishilist2 = Query.make("difangmeishi").limit(4).order("id desc").select();
            assign("difangmeishilist2" , difangmeishilist2);
            
            
            ArrayList<HashMap> lvyouxianlulist3 = Query.make("lvyouxianlu").limit(4).order("id desc").select();
            assign("lvyouxianlulist3" , lvyouxianlulist3);
            
            
            ArrayList<HashMap> xinwenxinxilist4 = Query.make("xinwenxinxi").limit(4).order("id desc").select();
            assign("xinwenxinxilist4" , xinwenxinxilist4);
                            if(isAjax())
        {
            return json();
        }
        return "index";
        
    }



}
