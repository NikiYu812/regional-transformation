package controller;

import java.io.*;  
import java.sql.*;  
  
import javax.servlet.*;  
import javax.servlet.http.*;  

import model.dao.dbDAO;
  
public class loginServlet extends HttpServlet {  
    // 防止用户直接输入网址访问此loginServlet  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        PrintStream out = new PrintStream(response.getOutputStream());  
        response.setContentType("text/html;charSet=utf-8");  
        out.print("请正常打开此页");  
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException {  
        String errmsg = "";  
        //获取用户输入的东西  
        String buildingNo1 = request.getParameter("buildingNo1");  
        String buildingNo2 = request.getParameter("buildingNo2");
        String buildingNo = buildingNo1+"栋"+buildingNo2+"号";
        String seqId = request.getParameter("seqId");  
        try {  
            //构造操作数据库的语句  
            dbDAO db = new dbDAO();    
            ResultSet rs = db  
                    .query("select * from rt_housinginfo where buildingNo = ?",  
                            buildingNo);  
            //根据不同的查询结果的，返回不同的结果到View层  
            if (rs.next()) {  
            	HttpSession session = request.getSession(); 
            	
            	session.setAttribute("buildingNo", buildingNo);
            	session.setAttribute("originalTenant", rs.getString("originalTenant"));
            	session.setAttribute("presentTenant", rs.getString("presentTenant"));
            	session.setAttribute("idCardNo", rs.getString("idCardNo"));
            	session.setAttribute("tel", rs.getString("tel"));
            	session.setAttribute("state", rs.getString("state"));
            	session.setAttribute("seqId", rs.getString("seqId"));
            	
                request.getRequestDispatcher("/lot1.jsp").forward(  
                        request, response);   
            } else {  
                errmsg = "房号不存在！";  
                request.setAttribute("errmsg", errmsg);  
                request.getRequestDispatcher("/login.jsp").forward(request,  
                        response);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
} 
