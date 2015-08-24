<%@page import="com.mysql.fabric.Response"%>
<%@page import="java.util.Date"%>
<%@page import="com.hand.entity.customer"%>
<%@page import="com.hand.dao.impl.customerDaoImpl"%>
<%@page import="com.hand.dao.customerDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.hand.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="style1.css">
</head>
<body>
<div class="container">
    <div class="head">
       <a class="btn btn-primary" href="<%= request.getContextPath() %>/LogoutServlet18">退出</a>
    </div>
   <div class="body">
       <div class="menu">
           <ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
               <li role="presentation" class=""><a href="#">Customer管理<span class="glyphicon glyphicon-chevron-right"></span></a> </li>
               <li role="presentation"><a href="#">Film设置<span class="glyphicon glyphicon-chevron-right"></span></a> </li>
           </ul>
       </div>
       <div class="kehuguanli">
           <div class="cust">
             <h3>  客户管理</h3>
           </div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<div>客户列表</div>
						<button type="button" class="btn btn-primary col-md-offset-4" data-toggle="modal" data-target="#exampleModal"data-whatever="@mdo">新建</button>
     

					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<tr class="active">
										<th>操作</th>
										<th>Frist Name</th>
										<th>Last Name</th>
										<th>Address</th>
										<th>Email</th>
										<th>Customer_ID</th>
										<th>LastUpdate</th>
									</tr>
								</thead>
								<tbody>
									<%!Connection conn = null;

	public static final int pagesize = 50;
	int pagecount;
	int curpage = 1;%>
									<%
										try {
											conn = ConnectionFactory.getInstance().makeConnection();
											conn.setAutoCommit(false);

											customerDao customerDao = new customerDaoImpl();
											customer cus = new customer();
											ResultSet data = null;
											data = customerDao.get(conn, cus);
											conn.commit();

											data.last();
											int size = data.getRow();
											pagecount = (size % pagesize == 0) ? (size / pagesize) : (size / pagesize + 1);
											String tmp = request.getParameter("curpage");
											if (tmp == null) {
												tmp = "1";
											}
											curpage = Integer.parseInt(tmp);
											if (curpage >= pagecount)
												curpage = pagecount;
											boolean flag = data.absolute((curpage - 1) * pagesize + 1);
											out.println(curpage);
											int count = 0;

											do {
												if (count >= pagesize)
													break;
												long customer_id = data.getLong("customer_id");
												String first_name = data.getString("first_name");
												String last_name = data.getString("last_name");
												String address = data.getString("address");
												String email = data.getString("email");
												Date LastUpdate = data.getDate("last_update");
												count++;
									%>
									<tr class="success">
										<td><a href="#">编辑</a>/<a href="#">删除</a></td>
										<td><input disabled type="text" name="first_name"
											value="<%=data.getString("first_name")%>" /></td>
										<td><input disabled type="text" name="last_name"
											value="<%=data.getString("last_name")%>" /></td>
										<td><input disabled type="text" name="address"
											value="<%=data.getString("address")%>" /></td>
										<td><input disabled type="text" name="email"
											value="<%=data.getString("email")%>" /></td>
										<td><input disabled type="text" name="customer_id"
											value="<%=data.getLong("customer_id")%>" /></td>
										<td><input disabled type="text" name="last_update"
											value="<%=data.getDate("last_update")%>" /></td>
									</tr>

									<%
										} while (data.next());
									%>
									<%
										conn.close();
									%>
									<%
										} catch (Exception e) {
											e.printStackTrace();

										}
									%>
								</tbody>
							</table>
						</div>
					</div>
					<div class="panel-footer">
						<div class="fenpage">
							<nav class="bottom_nav">
							<ul class="pagination">
								<li><a href="index.jsp?curpage=1">&laquo;</a></li>
								<%
									for (int i = 1; i < pagecount; i++) {
								%>
								<li><a href="index.jsp?curpage=<%=i%>"><%=i%></a></li>
								<%
									}
								%>
								<li><a href="index.jsp?curpage=<%=pagecount%>">&raquo;</a>
								</li>
							</ul>
							</nav>
						</div>
					</div>
				</div>

			</div>
   </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModal"
             aria-hidden="true">
         <div class="modal-dialog">
             <div class="modal-content">
                 <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                     </button>
                     <h4 class="modal-title" id="exampleModalLable">New Massage</h4>
                 </div>
                 <div class="modal-body">
                <form class="form-horizontal" role="form" action="#" Method="post" name="loginForm">
                    <div class="form-group">
                        <label class="col-md-4 control-label">Frist Name：</label>
                        <div class="col-md-4">
                            <input type="text" name="uname" class="form-control" placeholder="Frist Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Last Name：</label>
                        <div class="col-md-4">
                            <input type="password" name="pword" class="form-control" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Email：</label>
                        <div class="col-md-4">
                            <input type="password" name="pword" class="form-control" placeholder="Email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Address：</label>
                        <div class="dropdown">
                            <button class="btn btn-default" id="dlabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Address
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                <li><a class="active">1</a></li>
                                <li><a>2</a></li>
                                <li><a>3</a></li>
                                <li><a>4</a></li>
                                <li><a>5</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-4">
                            <button type="submit" class="btn btn-default">新建</button>
                            <button type="submit" class="btn btn-default">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
             </div>
         </div>
     </div>
<script src="jquery-2.1.4.min.js"></script>
<script src="bootstrap.min.js"></script>
</body>
</html>