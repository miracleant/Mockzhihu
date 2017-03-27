package top.karls.controllers;

/**
 * Created by karlind on 10/23/16.
 */

import top.karls.models.Answer;
import top.karls.models.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddAnswer extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String content = request.getParameter("content");
        String qid = request.getParameter("qid");
        if (content == null || content.equals("")||qid==null||qid.equals("")){
            response.sendError(404);
            return;
        }
        int questionId = Integer.parseInt(qid);
        Question q = Question.getQuestionById(questionId);
        if(q==null){
            response.sendError(404);
            return;
        }
        Answer a = new Answer();
        a.setContent(content);
        a.setQuestion(q);
        a.setName((String) session.getAttribute("username"));
        a.add();
        response.sendRedirect("/eassy.jsp?id="+qid);
    }
}
