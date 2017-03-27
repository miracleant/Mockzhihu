package top.karls.controllers;

/**
 * Created by karlind on 10/23/16.
 */
import top.karls.models.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddQuestion extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if(title==null||content==null||title.equals("")||content.equals("")){
            response.sendError(404);
            return ;
        }
        Question q = new Question();
        q.setName((String) session.getAttribute("username"));
        q.setTitle(title);
        q.setContent(content);
        boolean status = q.add();
        response.sendRedirect("/index.jsp");
    }
}
