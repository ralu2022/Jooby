<%@ page import="com.jooby.app.repository.JdbcJobListingEmployersRepository" %>


<%
    int employerID = Integer.parseInt(request.getParameter("employerID"));
    int jobListingID = Integer.parseInt(request.getParameter("jobListingID"));


    JdbcJobListingEmployersRepository repo = new JdbcJobListingEmployersRepository();

    repo.addJobListingToEmployer(employerID, jobListingID);

%>

<meta http-equiv="Refresh" content="0; url='/Jooby/index.jsp"/>