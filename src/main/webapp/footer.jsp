<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.*"%>
<%@page import="net.jntoo.db.*"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    

<div class="footer mt10">
                ${likeList = Query.make("youqinglianjie").order("id desc").select();""}

        <div class="copyrightnr link">
            友情链接 
            <c:forEach items="${likeList}" var="v"><c:set var="v" value="${v}" scope="request" />
            <a href="${v.wangzhi}" target="_blank">${v.wangzhanmingcheng}</a>  
            </c:forEach>
        </div>
        
        <div class="copyrightnr">
            地址：xxxxxxxxxxxxx　　电话：0000-00000000　　手机：12312312312
            <br></br>
            版权所有：旅游信息推荐系统设计与实现 　　ICP备********号        </div>
    </div>



