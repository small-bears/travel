package com.spring.controller;

import com.spring.dao.XinwenxinxiMapper;
import com.spring.entity.Xinwenxinxi;
import com.spring.service.XinwenxinxiService;
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
 * 新闻信息 */
@Controller
public class XinwenxinxiController extends BaseController
{
    @Autowired
    private XinwenxinxiMapper dao;
    @Autowired
    private XinwenxinxiService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/xinwenxinxi_list")
    public String list()
    {

        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int    pagesize = Request.getInt("pagesize" , 12); // 获取前台一页多少行数据
        Example example = new Example(Xinwenxinxi.class); //  创建一个扩展搜索类
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
        List<Xinwenxinxi> list = service.selectPageExample(example , page , pagesize);   // 获取当前页的行数


                    assign("xinwenfenleiList" , new CommDAO().select("SELECT * FROM xinwenfenlei ORDER BY id desc"));
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
            if(!Request.get("biaoti").equals("")) {
            where += " AND biaoti LIKE '%"+Request.get("biaoti")+"%' ";
        }
                if(!Request.get("fenlei").equals("")) {
            where += " AND fenlei ='"+Request.get("fenlei")+"' ";
        }
                if(!Request.get("tianjiaren").equals("")) {
            where += " AND tianjiaren LIKE '%"+Request.get("tianjiaren")+"%' ";
        }
                if(!Request.get("dianjilv_start").equals("")) {
            where += " AND dianjilv >='"+Request.get("dianjilv_start")+"' ";
        }
        if(!Request.get("dianjilv_end").equals("")) {
            where += " AND dianjilv <= '"+Request.get("dianjilv_end")+"' ";
        }
                if(!Request.get("neirong").equals("")) {
            where += " AND neirong LIKE '%"+Request.get("neirong")+"%' ";
        }
            return where;
    }

    /**
     * 添加人列表
     */
    @RequestMapping("/xinwenxinxi_list_tianjiaren")
    public String listtianjiaren()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }
        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int    pagesize = Request.getInt("pagesize" , 12); // 获取前台一页多少行数据

        
        Example example = new Example(Xinwenxinxi.class);  //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();           // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：添加人=当前登录用户
        String where = " tianjiaren='"+request.getSession().getAttribute("username")+"' ";
        where += getWhere();

        criteria.andCondition(where);   // 将条件写入
        if(sort.equals("desc")){        // 注释同list
            example.orderBy(order).desc(); // 注释同list
        }else{
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1 , page); // 注释同list

            List<Xinwenxinxi> list = service.selectPageExample(example , page , pagesize);
                        assign("xinwenfenleiList" , new CommDAO().select("SELECT * FROM xinwenfenlei ORDER BY id desc"));        assign("totalCount" , request.getAttribute("totalCount"));
        assign("list" , list);
                assign("orderby" , order);
        assign("sort" , sort);
        return json();   // 将数据写给前端
    }

    /**
    *  前台列表页
    *
    */
    @RequestMapping("/xinwenxinxilist")
    public String index()
    {
            String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Xinwenxinxi.class);
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
                    List<Xinwenxinxi> list = service.selectPageExample(example , page , 12);
            
                assign("mapxinwenfenlei3" , new CommDAO().select("SELECT id,fenleimingcheng FROM xinwenfenlei"));        assign("totalCount" , request.getAttribute("totalCount"));
        assign("list" , list);
        assign("where" , where);
        assign("orderby" , order);
        assign("sort" , sort);
        return json();
    }



        @RequestMapping("/xinwenxinxi_add")
    public String add()
    {
        _var = new LinkedHashMap(); // 重置数据

                    assign("xinwenfenleiList" , new CommDAO().select("SELECT * FROM xinwenfenlei ORDER BY id desc"));
        return json();   // 将数据写给前端
    }

    @RequestMapping("/xinwenxinxi_updt")
    public String updt()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Xinwenxinxi mmm = service.find(id);
        assign("mmm" , mmm);
        assign("updtself" , 0);

                    assign("xinwenfenleiList" , new CommDAO().select("SELECT * FROM xinwenfenlei ORDER BY id desc"));
        return json();   // 将数据写给前端
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/xinwenxinxiinsert")
    public String insert()
    {
        _var = new LinkedHashMap(); // 重置数据
        String tmp="";
        Xinwenxinxi post = new Xinwenxinxi();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setBiaoti(Request.get("biaoti"));

        post.setFenlei(Request.get("fenlei"));

        post.setTupian(Request.get("tupian"));

        post.setTianjiaren(Request.get("tianjiaren"));

        post.setDianjilv(Request.getInt("dianjilv"));

        post.setNeirong(util.DownloadRemoteImage.run(Request.get("neirong")));

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
    @RequestMapping("/xinwenxinxiupdate")
    public String update()
    {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Xinwenxinxi post = new Xinwenxinxi();
        // 将前台表单数据填充到实体类
        if(!Request.get("biaoti").equals(""))
        post.setBiaoti(Request.get("biaoti"));
                if(!Request.get("fenlei").equals(""))
        post.setFenlei(Request.get("fenlei"));
                if(!Request.get("tupian").equals(""))
        post.setTupian(Request.get("tupian"));
                if(!Request.get("tianjiaren").equals(""))
        post.setTianjiaren(Request.get("tianjiaren"));
                if(!Request.get("dianjilv").equals(""))
        post.setDianjilv(Request.getInt("dianjilv"));
            if(!Request.get("neirong").equals(""))
        post.setNeirong(util.DownloadRemoteImage.run(Request.get("neirong")));
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
    @RequestMapping("/xinwenxinxi_detail")
    public String detail()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Xinwenxinxi map = service.find(id);  // 根据前台url 参数中的id获取行数据
        assign("map" , map);  // 把数据写到前台
            return json();   // 将数据写给前端
    }
    /**
     *  前台详情
     */
    @RequestMapping("/xinwenxinxidetail")
    public String detailweb()
    {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Xinwenxinxi map = service.find(id);
        Query.execute("UPDATE xinwenxinxi SET dianjilv=dianjilv+1 WHERE id="+request.getParameter("id")+"");


                
                if(!checkLogin()){
            assign("isCollect" , false);
        }else{
            assign("isCollect" , Query.make("shoucangjilu").where("username",session.getAttribute("username")).where("biao" , "xinwenxinxi").where("xwid",id).count()>0);
        }

        
        assign("map" , map);
        return json();   // 将数据写给前端
    }
        /**
    *  删除
    */
    @RequestMapping("/xinwenxinxi_delete")
    public String delete()
    {
        _var = new LinkedHashMap(); // 重置数据
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据
        HashMap map = Query.make("xinwenxinxi").find(id);

                service.delete(id);// 根据id 删除某行数据
                return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
