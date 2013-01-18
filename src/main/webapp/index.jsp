<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
<jsp:useBean id="openDate" class="java.util.Date"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  
  <title>zetta1985-sample</title>
  
  <link rel="stylesheet" type="text/css" href="${ctx}/styles/reset.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/styles/layout.css"/>
  
  <link rel="stylesheet" type="text/css" href="${ctx}/scripts/jquery/css/redmond/jquery-ui-1.8.10.custom.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/scripts/jquery/css/ui.jqgrid.css"/>
  
  <script src="${ctx}/scripts/config-require.js?context=${ctx}"></script>
  <script src="${ctx}/scripts/requireplugins-jquery-1.4.4.js"></script>
  
  <script src="${ctx}/scripts/jquery/jquery-ui-1.8.10.custom.min.js"></script>
  <script src="${ctx}/scripts/jquery/jquery.layout-latest-min.js"></script>
  
  <script src="${ctx}/scripts/jquery/jquery.tmpl.min.js"></script>
  <script src="${ctx}/scripts/jquery/jquery.tmplPlus.min.js"></script>
  <script src="${ctx}/scripts/jquery/i18n/grid.locale-en.js"></script>
  <script src="${ctx}/scripts/jquery/jquery.jqGrid.min.js"></script>
  
  <script src="${ctx}/scripts/app/main.js?openDate=${openDate.time}"></script>
</head>
<body>
<div id="head_wrapper" class="ui-layout-north">
  <h1 id="page_title">Sample</h1>
  <div id="appengine_banner" class="banner">
    <img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" />
  </div>
</div>
<div id="menu_wrapper" class="ui-layout-west">
  <ul id="menu">
    <li><a href="#" id="menu_contact">Contact</a></li>
  </ul>
</div>
<div id="content_wrapper" class="ui-layout-center">
  <div id="content"></div>
</div>
<div id="footer_wrapper" class="ui-layout-south">
  <span id="openDate"></span>
</div>
</body>
</html>
