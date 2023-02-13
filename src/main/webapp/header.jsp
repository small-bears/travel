<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.*"%>
<%@page import="net.jntoo.db.*"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    

<div>
        <div class="header">

            <div class="container clearfix"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

                <div class="fr">
                    <c:choose>
<c:when test="${sessionScope.username != null && '' !=  sessionScope.username }">

                    欢迎${sessionScope.username}登录，
                    您得权限：${sessionScope.cx}
                    <a href="main.do"> 个人中心</a>
                    <a href="logout.do" onclick="return confirm('你确定退出？')"> 退出</a>
                    </c:when><c:otherwise>
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#loginModel">
    
                        登录
                    
</button>
                                        </c:otherwise></c:choose>
                </div>
                <div class="">
                    欢迎光临
                </div>
            
<!-- container定宽，并剧中结束 --></div>
        </div>
        <nav class="navbar navbar-default-lan">
            <div class="container container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        旅游信息推荐系统设计与实现
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav" id="navbar-str">
                        <li>
<a href="./">首页
</a>
</li>
<li class="dropdown">
<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">旅游新闻
<span class="caret"></span>
</a>
<ul class="dropdown-menu">
                    <ssm:sql var="mapxinwenfenlei1" type="select">SELECT id,fenleimingcheng FROM xinwenfenlei</ssm:sql>
<c:forEach items="${mapxinwenfenlei1}" var="m"><c:set var="m" value="${m}" scope="request" />
<li><a href="xinwenxinxilist.do?fenlei=${m.id}">${m.fenleimingcheng}</a></li>
</c:forEach>
</ul>
</li>
<li class="dropdown">
<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">景区信息
<span class="caret"></span>
</a>
<ul class="dropdown-menu">
                    <ssm:sql var="mapdiqu2" type="select">SELECT id,diqumingcheng FROM diqu</ssm:sql>
<c:forEach items="${mapdiqu2}" var="m"><c:set var="m" value="${m}" scope="request" />
<li><a href="jingdianxinxilist.do?suoshudiqu=${m.id}">${m.diqumingcheng}</a></li>
</c:forEach>
</ul>
</li>
<li>
<a href="lvyouxianlulist.do">旅游线路
</a>
</li>
<li>
<a href="liuyanbanadd.do">在线留言
</a>
</li>
<li>
<a href="yonghuadd.do">注册
</a>
</li>
<li>
<a href="login.do">管理
</a>
</li>                    </ul>
                                    </div>
            </div>
        </nav>
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="0" id="loginModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="0">登录</h4>
            </div>
            <div class="modal-body">
                <div class="pa10">
                    
            <form action="authLogin.do?ac=login&a=a" method="post"><!-- form 标签开始 -->
    
                <div class="form-group">
    
    
                    <input type="text" class="form-control" name="username" placeholder="输入帐号"/>
                
</div>
                <div class="form-group">
    
    
                    <input type="password" class="form-control" name="pwd" placeholder="密码"/>
                
</div>
                <div class="form-group">
    
    
                    <select class="form-control" name="cx">

                        <option value="用户">用户</option>                    
</select>
                
</div>
                <div class="form-group">
    
    
                    <div class="input-group">
    
                        <input type="text" class="form-control" name="pagerandom" placeholder="输入验证码"/>
                        
                    
    <span class="input-group-addon"><img src="captcha.do" style="width: 60px;height: 20px;max-width: none; max-height: none;" onclick="this.src='captcha.do?rand='+new Date().getTime()"/></span>
</div>
                
</div>
                <div class="form-group">
    <div class="row">
        <label style="text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                    <button type="submit" class="btn btn-primary">
    登录
</button>
                
        </div>
        
    </div>
</div>
            
<!--form标签结束--></form>
        
                </div>
            </div>
        </div>
    </div>
</div>

    </div>



