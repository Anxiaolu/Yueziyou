<%@ page language="java" contentType="text/html" 
         pageEncoding="UTF-8" 
         import="java.sql.*,javax.sql.*,javax.naming.*"%>
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>   
<h2>Results</h2>
    <%
    Context initContext = new InitialContext();
    Context envContext  = (Context)initContext.lookup("java:/comp/env");
    DataSource ds = (DataSource)envContext.lookup("jdbc/yueziyou");
    Connection conn = ds.getConnection();
    String sql = "select * from category";
    PreparedStatement st = conn.prepareStatement(sql);
    ResultSet rs = st.executeQuery();
    while(rs.next()){
        out.println("barcode:"+rs.getString(2)+" name:"+rs.getString(3)+"<br>");
    }
    if(rs!=null){
        try{
            rs.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        rs = null;
    }
    if(st!=null){
        try{
            st.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    if(conn!=null){
        try{
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    %>
</body>  
</html>
	