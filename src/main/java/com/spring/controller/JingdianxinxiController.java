package com.spring.controller;

import com.spring.dao.JingdianxinxiMapper;
import com.spring.entity.Jingdianxinxi;
import com.spring.service.JingdianxinxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;
import dao.CommDAO;


/**
 * 景点信息 */
@Controller
public class JingdianxinxiController extends BaseController
{
    @Autowired
    private JingdianxinxiMapper dao;
    @Autowired
    private JingdianxinxiService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/jingdianxinxi_list")
    public String list()
    {

        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int    pagesize = Request.getInt("pagesize" , 12); // 获取前台一页多少行数据
        Example example = new Example(Jingdianxinxi.class); //  创建一个扩展搜索类
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
        List<Jingdianxinxi> list = service.selectPageExample(example , page , pagesize);   // 获取当前页的行数


                    assign("diquList" , new CommDAO().select("SELECT * FROM diqu ORDER BY id desc"));
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
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
            if(!Request.get("jingdianbianhao").equals("")) {
            where += " AND jingdianbianhao LIKE '%"+Request.get("jingdianbianhao")+"%' ";
        }
                if(!Request.get("jingdianmingcheng").equals("")) {
            where += " AND jingdianmingcheng LIKE '%"+Request.get("jingdianmingcheng")+"%' ";
        }
                if(!Request.get("suoshudiqu").equals("")) {
            where += " AND suoshudiqu ='"+Request.get("suoshudiqu")+"' ";
        }
            return where;
    }


    /**
    *  前台列表页
    *
    */
    @RequestMapping("/jingdianxinxilist")
    public String index()
    {
            String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Jingdianxinxi.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " 1=1 ";
                where += getWhere();
        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
                    List<Jingdianxinxi> list = service.selectPageExample(example , page , 12);
            
                assign("mapdiqu4" , new CommDAO().select("SELECT id,diqumingcheng FROM diqu"));        assign("totalCount" , request.getAttribute("totalCount"));
        assign("list" , list);
        assign("where" , where);
        assign("orderby" , order);
        assign("sort" , sort);
        return json();
    }



        @RequestMapping("/jingdianxinxi_add")
    public String add()
    {
        _var = new LinkedHashMap(); // 重置数据

                    assign("diquList" , new CommDAO().select("SELECT * FROM diqu ORDER BY id desc"));
            assign("difangmeishiList" , new CommDAO().select("SELECT * FROM difangmeishi ORDER BY id desc"));
        return json();   // 将数据写给前端
    }

    @RequestMapping("/jingdianxinxi_updt")
    public String updt()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jingdianxinxi mmm = service.find(id);
        assign("mmm" , mmm);
        assign("updtself" , 0);

                    assign("diquList" , new CommDAO().select("SELECT * FROM diqu ORDER BY id desc"));
            assign("difangmeishiList" , new CommDAO().select("SELECT * FROM difangmeishi ORDER BY id desc"));
        return json();   // 将数据写给前端
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/jingdianxinxiinsert")
    public String insert()
    {
        _var = new LinkedHashMap(); // 重置数据
        String tmp="";
        Jingdianxinxi post = new Jingdianxinxi();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setJingdianbianhao(Request.get("jingdianbianhao"));

        post.setJingdianmingcheng(Request.get("jingdianmingcheng"));

        post.setSuoshudiqu(Request.get("suoshudiqu"));

        post.setTupian(Request.get("tupian"));

        post.setKaifangshijian(Request.get("kaifangshijian"));

        post.setFujinmeishi(Request.get("fujinmeishi"));

        post.setDizhi(Request.get("dizhi"));

        post.setPiaojia(Request.getDouble("piaojia"));

        post.setLiulanliang(Request.getInt("liulanliang"));

        post.setMiaoshu(util.DownloadRemoteImage.run(Request.get("miaoshu")));

        post.setAddtime(Info.getDateStr());
    

        

                service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        

        if(isAjax()){
            return jsonResult(post);

        }
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/jingdianxinxiupdate")
    public String update()
    {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Jingdianxinxi post = new Jingdianxinxi();
        // 将前台表单数据填充到实体类
        if(!Request.get("jingdianbianhao").equals(""))
        post.setJingdianbianhao(Request.get("jingdianbianhao"));
                if(!Request.get("jingdianmingcheng").equals(""))
        post.setJingdianmingcheng(Request.get("jingdianmingcheng"));
                if(!Request.get("suoshudiqu").equals(""))
        post.setSuoshudiqu(Request.get("suoshudiqu"));
                if(!Request.get("tupian").equals(""))
        post.setTupian(Request.get("tupian"));
                if(!Request.get("kaifangshijian").equals(""))
        post.setKaifangshijian(Request.get("kaifangshijian"));
                if(!Request.get("fujinmeishi").equals(""))
        post.setFujinmeishi(Request.get("fujinmeishi"));
                if(!Request.get("dizhi").equals(""))
        post.setDizhi(Request.get("dizhi"));
                if(!Request.get("piaojia").equals(""))
        post.setPiaojia(Request.getDouble("piaojia"));
            if(!Request.get("liulanliang").equals(""))
        post.setLiulanliang(Request.getInt("liulanliang"));
            if(!Request.get("miaoshu").equals(""))
        post.setMiaoshu(util.DownloadRemoteImage.run(Request.get("miaoshu")));
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
     *  后台详情
     */
    @RequestMapping("/jingdianxinxi_detail")
    public String detail()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jingdianxinxi map = service.find(id);  // 根据前台url 参数中的id获取行数据
        assign("map" , map);  // 把数据写到前台
            return json();   // 将数据写给前端
    }
    /**
     *  前台详情
     */
    @RequestMapping("/jingdianxinxidetail")
    public String detailweb()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jingdianxinxi map = service.find(id);
        Query.execute("UPDATE jingdianxinxi SET liulanliang=liulanliang+1 WHERE id="+request.getParameter("id")+"");


                
                if(!checkLogin()){
            assign("isCollect" , false);
        }else{
            assign("isCollect" , Query.make("shoucangjilu").where("username",session.getAttribute("username")).where("biao" , "jingdianxinxi").where("xwid",id).count()>0);
        }

        
        assign("map" , map);
        return json();   // 将数据写给前端
    }
        /**
    *  删除
    */
    @RequestMapping("/jingdianxinxi_delete")
    public String delete()
    {
        _var = new LinkedHashMap(); // 重置数据
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据
        HashMap map = Query.make("jingdianxinxi").find(id);

                service.delete(id);// 根据id 删除某行数据
                return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
