package com.spring.controller;

import dao.CommDAO;
import net.jntoo.db.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Request;

import java.util.HashMap;

@Controller
public class PaymentController extends BaseController{
    /**
     * 处理支付
     * @return String
     */
    @RequestMapping("/payment")
    public String payment()
    {
        String id,biao;
        if(request.getParameter("out_trade_no")!=null)
        {
            String[] out_trade_no = request.getParameter("out_trade_no").split("\\-");
            id = out_trade_no[2];
            biao = out_trade_no[1];

        }else{
            id =request.getParameter("id");
            biao =request.getParameter("biao");
        }

        String sql = "update " + biao + " set iszf='是' where id='" + id + "'";
        new CommDAO().commOper(sql);
        HashMap order = Query.make(biao).find(id);



        if("yuding".equals(biao))
        {
            Query.execute("update yuding set zhuangtai='预定成功' where id='"+order.get("id")+"'");


        }

        String referer = Request.get("referer").equals("") ? "sy.do" : Request.get("referer");
        return showSuccess("支付成功",referer);
    }
}
