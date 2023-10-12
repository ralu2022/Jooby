<%@ page import="com.jooby.app.model.User" %>
<%@ page import="com.jooby.app.repository.JdbcUserRepository" %>


<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String userType = request.getParameter("userType");


    User user = new User(userName,password,userType);

    JdbcUserRepository userRepo = new JdbcUserRepository();

    userRepo.userLogin(user);

%>

<meta http-equiv="Refresh" content="0; url='/Jooby/amainpage.jsp"/>