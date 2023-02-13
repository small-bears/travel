package com.spring.controller;

import com.spring.dao.YudingMapper;
import com.spring.entity.Yuding;
import com.spring.service.YudingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;
import dao.CommDAO;

import com.spring.entity.Lvyouxianlu;
import com.spring.service.LvyouxianluService;

/**
 * 预定 */
@Controller
public class YudingController extends BaseController
{
    @Autowired
    private YudingMapper dao;
    @Autowired
    private YudingService service;

    @Autowired
    private LvyouxianluService serviceRead;
    /**
     *  后台列表页
     *
     */
    @RequestMapping("/yuding_list")
    public String list()
    {

        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int    pagesize = Request.getInt("pagesize" , 12); // 获取前台一页多少行数据
        Example example = new Example(Yuding.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();          // 创建一个扩展搜索条件类
        String where = " 1=1 ";   // 创建初始条件为：1=1
        where += getWhere();      // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where);   // 将条件写进上面的扩展条件类中
        if(sort.equals("desc")){        // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc();  // 把sql 语句设置成倒序
        }else{
            example.orderBy(order).asc();   // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1 , page);  // 取两个数的最大值，防止page 小于1
        List<Yuding> list = service.selectPageExample(example , page , pagesize);   // 获取当前页的行数


        
        // 将列表写给界面使用
        assign("totalCount" , request.getAttribute("totalCount"));
        assign("list" , list);
        assign("orderby" , order);  // 把当前排序结果写进前台
        assign("sort" , sort);      // 把当前排序结果写进前台
        return json();   // 将数据写给前端
    }

    public String getWhere()
    {
        _var = new LinkedHashMap(); // 重置数据
        String where = " ";
        // 判断URL 参数lvyouxianluid是否大于0
        if( Request.getInt("lvyouxianluid") > 0 ) {
            // 大于0 则写入条件
            where += " AND lvyouxianluid='"+Request.getInt("lvyouxianluid")+"' ";
        }
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
            if(!Request.get("xianlubianhao").equals("")) {
            where += " AND xianlubianhao LIKE '%"+Request.get("xianlubianhao")+"%' ";
        }
                if(!Request.get("xianlumingcheng").equals("")) {
            where += " AND xianlumingcheng LIKE '%"+Request.get("xianlumingcheng")+"%' ";
        }
                if(!Request.get("tujingdi").equals("")) {
            where += " AND tujingdi LIKE '%"+Request.get("tujingdi")+"%' ";
        }
            return where;
    }

    /**
     * 预订人列表
     */
    @RequestMapping("/yuding_list_yudingren")
    public String listyudingren()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }
        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int    pagesize = Request.getInt("pagesize" , 12); // 获取前台一页多少行数据

        
        Example example = new Example(Yuding.class);  //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();           // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：预订人=当前登录用户
        String where = " yudingren='"+request.getSession().getAttribute("username")+"' ";
        where += getWhere();

        criteria.andCondition(where);   // 将条件写入
        if(sort.equals("desc")){        // 注释同list
            example.orderBy(order).desc(); // 注释同list
        }else{
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1 , page); // 注释同list

            List<Yuding> list = service.selectPageExample(example , page , pagesize);
                    assign("totalCount" , request.getAttribute("totalCount"));
        assign("list" , list);
                assign("orderby" , order);
        assign("sort" , sort);
        return json();   // 将数据写给前端
    }




        @RequestMapping("/yuding_add")
    public String add()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");  // 根据id 获取 旅游线路模块中的数据
        Lvyouxianlu readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        assign("readMap" , readMap);

        
        return json();   // 将数据写给前端
    }

    @RequestMapping("/yuding_updt")
    public String updt()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Yuding mmm = service.find(id);
        assign("mmm" , mmm);
        assign("updtself" , 0);

        
        return json();   // 将数据写给前端
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/yudinginsert")
    public String insert()
    {
        _var = new LinkedHashMap(); // 重置数据
        String tmp="";
        Yuding post = new Yuding();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setLvyouxianluid(Request.getInt("lvyouxianluid"));

        post.setXianlubianhao(Request.get("xianlubianhao"));

        post.setXianlumingcheng(Request.get("xianlumingcheng"));

        post.setChufadi(Request.get("chufadi"));

        post.setTujingdi(Request.get("tujingdi"));

        post.setZhongdian(Request.get("zhongdian"));

        post.setJiage(Request.getDouble("jiage"));

        post.setDingdanhao(Request.get("dingdanhao"));

        post.setYudingshijian(Request.get("yudingshijian"));

        post.setYudingrenxingming(Request.get("yudingrenxingming"));

        post.setLianxifangshi(Request.get("lianxifangshi"));

        post.setZhuangtai(Request.get("zhuangtai"));

        post.setBeizhu(Request.get("beizhu"));

        post.setYudingren(Request.get("yudingren"));

        post.setAddtime(Info.getDateStr());
    
        post.setLvyouxianluid(Request.getInt("lvyouxianluid"));
        post.setIszf("否");

        

                service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update yuding set zhuangtai");




        if(isAjax()){
            return jsonResult(post);

        }
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/yudingupdate")
    public String update()
    {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Yuding post = new Yuding();
        // 将前台表单数据填充到实体类
        if(!Request.get("lvyouxianluid").equals(""))
        post.setLvyouxianluid(Request.getInt("lvyouxianluid"));
            if(!Request.get("xianlubianhao").equals(""))
        post.setXianlubianhao(Request.get("xianlubianhao"));
                if(!Request.get("xianlumingcheng").equals(""))
        post.setXianlumingcheng(Request.get("xianlumingcheng"));
                if(!Request.get("chufadi").equals(""))
        post.setChufadi(Request.get("chufadi"));
                if(!Request.get("tujingdi").equals(""))
        post.setTujingdi(Request.get("tujingdi"));
                if(!Request.get("zhongdian").equals(""))
        post.setZhongdian(Request.get("zhongdian"));
                if(!Request.get("jiage").equals(""))
        post.setJiage(Request.getDouble("jiage"));
            if(!Request.get("dingdanhao").equals(""))
        post.setDingdanhao(Request.get("dingdanhao"));
                if(!Request.get("yudingshijian").equals(""))
        post.setYudingshijian(Request.get("yudingshijian"));
                if(!Request.get("yudingrenxingming").equals(""))
        post.setYudingrenxingming(Request.get("yudingrenxingming"));
                if(!Request.get("lianxifangshi").equals(""))
        post.setLianxifangshi(Request.get("lianxifangshi"));
                if(!Request.get("zhuangtai").equals(""))
        post.setZhuangtai(Request.get("zhuangtai"));
                if(!Request.get("beizhu").equals(""))
        post.setBeizhu(Request.get("beizhu"));
                if(!Request.get("yudingren").equals(""))
        post.setYudingren(Request.get("yudingren"));
                if(!Request.get("addtime").equals(""))
        post.setAddtime(Request.get("addtime"));
        
        post.setId(Request.getInt("id"));
                service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        
        if(isAjax()){
            return jsonResult(post);
        }
        
        return showSuccess("保存成功" , Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }
        /**
    *  删除
    */
    @RequestMapping("/yuding_delete")
    public String delete()
    {
        _var = new LinkedHashMap(); // 重置数据
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据
        HashMap map = Query.make("yuding").find(id);

                service.delete(id);// 根据id 删除某行数据
                return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
