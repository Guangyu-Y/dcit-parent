/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-04 08:03:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.sysadmin.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jCustomerUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/pages/sysadmin/customer/../../base.jsp", Long.valueOf(1514363111645L));
    _jspx_dependants.put("/WEB-INF/pages/sysadmin/customer/../../baselist.jsp", Long.valueOf(1514363111661L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/button.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/table.css\" media=\"all\"/>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/js/common.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/js/jquery-1.6.2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/js/datepicker/WdatePicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t  $(\"#ec_table tr:even\").css(\"background-color\",\"#F4F4F4\");\r\n");
      out.write("\t  $(\"#ec_table tr\").css(\"font-size\",\"25px\");\r\n");
      out.write("\t});\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \t<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/css/extreme/extremecomponents.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/css/extreme/extremesite.css\" />");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>客户信息更新</title>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction clearCities(id) {\r\n");
      out.write("\t\tvar city = document.getElementById(id);\r\n");
      out.write("\t\t//清空所有option\r\n");
      out.write("\t\tcity.length = 0;\r\n");
      out.write("\t\tcity.options[0] = new Option(\"--请选择--\", 0);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getCitys(parent_id,flag){\r\n");
      out.write("\t\tvar parent = parent_id;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\turl:\"GetCitys\",\r\n");
      out.write("\t\t\t\tdata:{parentid:parent},\r\n");
      out.write("\t\t\t\tdatatype:\"json\",\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tvar city=$(\"#selectcity\");\r\n");
      out.write("\t\t\t\t\tvar area=$(\"#selectarea\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t    \t\t//判断对象状态，readyState为对象执行状态，status为服务器返回码，如我们常见的404、500，200表示成功\r\n");
      out.write("\t\t    \t\tif (data.status == 400) {\r\n");
      out.write("\t\t    \t\t\t//得到服务器回应文本\r\n");
      out.write("\t\t  \t\t\t\tvar dat=data.data;\r\n");
      out.write("\t\t    \t\t\tvar str=\"\";\r\n");
      out.write("\t\t    \t\t\tfor(var i=0;i<dat.length;i++)\r\n");
      out.write("\t\t    \t\t\t{\r\n");
      out.write("\t\t    \t\t\t\tstr+=\"<option value='\"+dat[i].id+\"'>\"+dat[i].name+\"</option>\";\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t\tif(flag==\"city\"){\r\n");
      out.write("\t\t    \t\t\t\tclearCities(\"selectcity\");\r\n");
      out.write("\t\t    \t\t\t\t$(\"#selectcity\").append(str);\r\n");
      out.write("\t\t    \t\t\t\tclearCities(\"selectarea\");\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t\tif(flag==\"area\"){\r\n");
      out.write("\t\t    \t\t\t\tclearCities(\"selectarea\");\r\n");
      out.write("\t\t    \t\t\t\t$(\"#selectarea\").append(str);\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t\t\r\n");
      out.write("\t\t    \t\t}\r\n");
      out.write("\t\t    \t\t\r\n");
      out.write("\t\t    \t\tif (data.status == 200){\r\n");
      out.write("\t\t    \t\t\tif(flag==\"city\"){\r\n");
      out.write("\t\t    \t\t\t\tclearCities(\"selectcity\");\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t\tif(flag=\"area\"){\r\n");
      out.write("\t\t    \t\t\t\tclearCities(\"selectarea\");\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t}\r\n");
      out.write("\t\t    \t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"icform\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"menubar\">\r\n");
      out.write("<div id=\"middleMenubar\">\r\n");
      out.write("<div id=\"innerMenubar\">\r\n");
      out.write("  <div id=\"navMenubar\">\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li id=\"view\"><a href=\"#\" onclick=\"formSubmit('update','_self');this.blur();\">修改</a></li>\r\n");
      out.write("\t<li id=\"new\"><a href=\"#\" onclick=\"window.history.go(-1);this.blur();\">返回</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("   \r\n");
      out.write("  <div class=\"textbox-title\">\r\n");
      out.write("\t<img src=\"../../staticfile/skin/default/images/icon/currency_yen.png\"/>\r\n");
      out.write("    用户修改\r\n");
      out.write("  </div> \r\n");
      out.write("  \r\n");
      out.write("<div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"eXtremeTable\" >\r\n");
      out.write("<table id=\"ec_table\" class=\"tableRegion\" width=\"98%\" >\r\n");
      out.write("\t<input name=\"id\"  type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td style=\"width:10%\">客户名：</td>\r\n");
      out.write("\t\t<td><input name=\"chname\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.chname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>英文名：</td>\r\n");
      out.write("\t\t<td><input name=\"enname\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.enname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<input name=\"code\"  type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>年龄：</td>\r\n");
      out.write("\t\t<td><input name=\"age\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.age }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>性别：</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"sex\" style=\"width:130px\">\r\n");
      out.write("\t\t\t\t<option value=\"男\">男</option>\r\n");
      out.write("\t\t\t\t<option value=\"女\">女</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>学历：</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"education\" style=\"width:130px\">\r\n");
      out.write("\t\t\t\t<option value=\"高中\">高中</option>\r\n");
      out.write("\t\t\t\t<option value=\"大专\">大专</option>\r\n");
      out.write("\t\t\t\t<option value=\"大专\">本科</option>\r\n");
      out.write("\t\t\t\t<option value=\"大专\">硕士</option>\r\n");
      out.write("\t\t\t\t<option value=\"大专\">博士/博士后</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>证件号：</td>\r\n");
      out.write("\t\t<td><input name=\"cardno\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.cardno }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>证件类型：</td>\r\n");
      out.write("\t\t<td><select name=\"cardtype\" style=\"width:130px\">\r\n");
      out.write("\t\t\t\t<option value=\"身份证\">中华人民共和国第二代居民身份证</option>\r\n");
      out.write("\t\t\t\t<option value=\"港澳通行证\">港澳通行证</option>\r\n");
      out.write("\t\t\t\t<option value=\"护照\">护照</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>地区</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"province\" id=\"selectprovince\" style=\"width:30%\" onchange=\"getCitys(this.value,'city')\">\r\n");
      out.write("\t\t\t\t<option value=\"\">--请选择省份--</option>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<select name=\"city\" id=\"selectcity\" style=\"width:30%\" onchange=\"getCitys(this.value,'area')\">\r\n");
      out.write("\t\t\t\t<option value=\"\">--请选择城市--</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<select name=\"areaid\" id=\"selectarea\" style=\"width:30%\">\r\n");
      out.write("\t\t\t\t<option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.areaid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">--请选择区--</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"odd\">\r\n");
      out.write("\t\t<td>地址：</td>\r\n");
      out.write("\t\t<td><input name=\"address\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ customer.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/pages/sysadmin/customer/../../base.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/sysadmin/customer/../../base.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sysadmin/customer/../../base.jsp(3,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/pages/sysadmin/customer/jCustomerUpdate.jsp(143,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sysadmin/customer/jCustomerUpdate.jsp(143,4) '${provinces}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${provinces}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/sysadmin/customer/jCustomerUpdate.jsp(143,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("p");
    // /WEB-INF/pages/sysadmin/customer/jCustomerUpdate.jsp(143,4) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
