<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="util.Info" %>
<%@page import="dao.CommDAO" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML XMLNS:CC>
<HEAD><TITLE>支付宝 - 网上支付 安全快速！</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <META content=网上购物/网上支付/安全支付/安全购物/购物，安全/支付,安全/支付宝/安全,支付/安全，购物/支付,
          name=description 在线 付款,收款 网上,贸易 网上贸易.>
    <META content=网上购物/网上支付/安全支付/安全购物/购物，安全/支付,安全/支付宝/安全,支付/安全，购物/支付, name=keywords
          在线 付款,收款 网上,贸易 网上贸易.>
    <LINK href="images/layout.css"
          type=text/css rel=stylesheet>

    <SCRIPT language=JavaScript>
        <!--
        //校验输入框  -->
        function CheckForm() {
            if (document.alipayment.aliorder.value.length == 0) {
                alert("请输入图书名称.");
                document.alipayment.aliorder.focus();
                return false;
            }
            if (document.alipayment.alimoney.value.length == 0) {
                alert("请输入付款金额.");
                document.alipayment.alimoney.focus();
                return false;
            }
            var reg = new RegExp(/^\d*\.?\d{0,2}$/);
            if (!reg.test(document.alipayment.alimoney.value)) {
                alert("请正确输入付款金额");
                document.alipayment.alimoney.focus();
                return false;
            }
            if (Number(document.alipayment.alimoney.value) < 0.01) {
                alert("付款金额金额最小是0.01.");
                document.alipayment.alimoney.focus();
                return false;
            }
        }

        function glowit(which) {
            if (document.all.glowtext[which].filters[0].strength == 2)
                document.all.glowtext[which].filters[0].strength = 1
            else
                document.all.glowtext[which].filters[0].strength = 2
        }

        function glowit2(which) {
            if (document.all.glowtext.filters[0].strength == 2)
                document.all.glowtext.filters[0].strength = 1
            else
                document.all.glowtext.filters[0].strength = 2
        }

        function startglowing() {
            if (document.all.glowtext && glowtext.length) {
                for (i = 0; i < glowtext.length; i++)
                    eval('setInterval("glowit(' + i + ')",150)')
            } else if (glowtext)
                setInterval("glowit2(0)", 150)
        }

        if (document.all)
            window.onload = startglowing


    </SCRIPT>
</HEAD>
<style>
    <!--
    #glowtext {
        filter: glow(color=red, strength=2);
        width: 100%;
    }

    -->
</style>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=4>
<CENTER>

    <TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
        <TBODY>
        <TR>
            <TD class=title>支付宝即时到帐付款快速通道</TD>
        </TR>
        </TBODY>
    </TABLE>
    <BR>
    <FORM name=alipayment onSubmit="return CheckForm();" action=alipayto.asp
          method=post target="_blank">
        <table>
            <tr>
                <td>
                    <TABLE cellSpacing=0 cellPadding=0 width=740 border=0>
                        <TR>
                            <TD class=form-left>收款方：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right>xxxx&nbsp;</TD>
                        </TR>
                        <TR>
                            <TD colspan="3" align="center">
                                <HR width=600 SIZE=2 color="#999999">
                            </TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>订单号：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right><INPUT size=30 name=aliorder maxlength="200"
                                                        value=""><span>如：7月5日定货款。</span></TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>付款金额：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right><INPUT maxLength=10 size=30 name=alimoney
                                                        onFocus="if(Number(this.value)==0){this.value='';}" value=""
                                                        readonly="readonly"/>
                                <span>如：112.21</span></TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>备注：</TD>
                            <TD class=form-star></TD>
                            <TD class=form-right><TEXTAREA name=alibody rows=5 cols=40 wrap="physical"></TEXTAREA><BR>
                                （如联系方法，图书要求、数量等。100汉字内）
                            </TD>
                        </TR>
                        <TR>
                            <TD class=form-left>支付方式：</TD>
                            <TD class=form-star></TD>
                            <TD class=form-right>
                                <table>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="directPay" checked><img
                                                src="images/alipay_1.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="ICBCB2C"/><img
                                                src="images/ICBC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CMB"/><img
                                                src="images/CMB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CCB"/><img
                                                src="images/CCB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="BOCB2C"><img
                                                src="images/BOC_OUT.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="ABC"/><img
                                                src="images/ABC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="COMM"/><img
                                                src="images/COMM_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="SPDB"/><img
                                                src="images/SPDB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="GDB"><img
                                                src="images/GDB_OUT.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="CITIC"/><img
                                                src="images/CITIC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CEBBANK"/><img
                                                src="images/CEB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CIB"/><img
                                                src="images/CIB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="SDB"><img
                                                src="images/SDB_OUT.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="CMBC"/><img
                                                src="images/CMBC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="HZCBB2C"/><img
                                                src="images/HZCB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="SHBANK"/><img
                                                src="images/SHBANK_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="NBBANK "><img
                                                src="images/NBBANK_OUT.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="SPABANK"/><img
                                                src="images/SPABANK_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="BJRCB"/><img
                                                src="images/BJRCB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="ICBCBTB"/><img
                                                src="images/ENV_ICBC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CCBBTB"/><img
                                                src="images/ENV_CCB_OUT.gif" border="0"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="SPDBB2B"/><img
                                                src="images/ENV_SPDB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="ABCBTB"/><img
                                                src="images/ENV_ABC_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="fdb101"/><img
                                                src="images/FDB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="PSBC-DEBIT"/><img
                                                src="images/PSBC_OUT.gif" border="0"/></td>
                                    </tr>
                                </table>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=form-left></TD>
                            <TD class=form-star></TD>
                            <TD class=form-right>
                                <img src="images/button_sure.gif"
                                                      onClick="javascript:location.href='../payment.do?id=<%=request.getParameter("id")%>&biao=<%=request.getParameter("biao")%>&referer='+encodeURIComponent(document.referrer);">
                            </TD>
                        </TR>
                    </TABLE>
                </td>
                <td vAlign=top width=205 style="font-size:12px;font-family:'宋体'">
                    <span id="glowtext">小贴士：</span>
                    <fieldset>
                        <P class=STYLE1>本通道为<a href="http://www.jingmeiru.net" target="_blank"><strong>高考英语口语考试报名系统收款帐号：xxxx</strong></a>客户专用，采用支付宝付款。请在支付前与本网站达成一致。
                        </P>
                        <P class="style2">请务必与<a href="http://www.jingmeiru.net" target="_blank"><strong>高考英语口语考试报名系统收款帐号：xxxx</strong></a>确认好订单和货款后，再付款。可以在快速付款通道里的“标题”、“订单金额”、“付款方”和备注中填入相应的订单信息。
                        </P>
                        <P class="style2 style3">&nbsp;</P>
                    </fieldset>
                </td>
            </tr>
        </table>

    </FORM>

    <TABLE cellSpacing=1 width=760 border=0>
        <TR>
            <TD><FONT class=note-help>如果您点击“购买”按钮，即表示您已经接受“支付宝服务协议”，同意向卖家购买此物品。
                <BR>
                您有责任查阅完整的物品登录资料，包括卖家的说明和接受的付款方式。卖家必须承担物品信息正确登录的责任！
            </FONT>
            </TD>
        </TR>
    </TABLE>

    <TABLE cellSpacing=0 cellPadding=0 width=760 align=center border=0>
        <TR align=middle>
            <TD class="txt12 lh15"><A href="http://china.alibaba.com/"
                                      target=_blank>阿里巴巴旗下公司</A> | 支付宝版权所有 2004-2012
            </TD>
        </TR>
        <TR align=middle>
            <TD class="txt12 lh15"><IMG alt="支付宝通过“国际权威安全认证” "
                                        src="images/logo_vbvv.gif" border=0><BR>支付宝通过“国际权威安全
                认证”
            </TD>
        </TR>
    </TABLE>
</BODY>
</HTML>
