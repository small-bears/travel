<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert("${message}");
    <c:choose>
    <c:when test="${jumpUrl eq 'javascript:history(-1);'}">

    history.go(-1);
    </c:when>
    <c:otherwise>
    location.href='${jumpUrl}';
    </c:otherwise>

    </c:choose>
</script>
