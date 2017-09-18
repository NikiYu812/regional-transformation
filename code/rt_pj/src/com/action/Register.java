package com.action;

import java.io.IOException;  
//Ϊ��Servlet�ܹ���ֵ��ǰ̨��JspҪʹ��request.getRequestDispatcher("").forward();�������˷���Ҫ����봦��IO�쳣  
import javax.servlet.*;  
import javax.servlet.http.*;  
//Ҫʹ��Servlet�����������������  
  
public class Register extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 5801145538911137198L;

	protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException {  
        //�̶����֣�˵���յ�Get��������ֵ����ô������ʹ���ҳ�治�õ�Getȥ��ֵ�����Ҳ�����շ����ڴ�  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");  
        //����index.jsp��������ֵ����Postͬ  
        request.setAttribute("username", username);  
        request.setAttribute("password", password);  
        //�����׼����ֵ����WEB-INF/ok.jsp�У���Postͬ  
        try {  
            request.getRequestDispatcher("WEB-INF/ok.jsp").forward(request,  
                    response);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        //ָ�����䷽����Postͬ  
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException {  
        //�̶����֣�˵���յ�Post��������ֵ����ô����  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");  
        request.setAttribute("username", username);  
        request.setAttribute("password", password);  
        try {  
            request.getRequestDispatcher("WEB-INF/ok.jsp").forward(request,  
                    response);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
} 
