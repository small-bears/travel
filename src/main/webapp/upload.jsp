<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="javascript">
    function Get(name){
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null) return unescape(r[2]);
        return null;
    }
    var str=location.toString();
    var file = "${url}";
    var Result = Get("Result");
    var callback = Get("callback");
    if(Result!= null){
        window.parent.document.getElementById(Result).value=file;
    }else{
        window.parent.window[callback](file);
    }
	document.write("上传成功");
</script>
