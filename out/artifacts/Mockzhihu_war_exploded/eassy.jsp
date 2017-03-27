<%@ page import="top.karls.models.Question" %>
<%@ page import="top.karls.models.Answer" %>
<%@ include file="header.jsp" %>
<%
    String id = request.getParameter("id");
    if (id == null || id.equals("")) {
        response.sendError(404);
        return;
    }
    Question q = Question.getQuestionById(Integer.parseInt(id));
    if (q == null) {
        response.sendError(404);
        return;
    }
%>

<div class="fm-eassy-content" id="fm-eassy-content">
    <div id="fm-eassy">
        <div id="fm-eassy-title"><%= q.getTitle()%>
        </div>
        <div id="fm-eassy-author"><%= q.getName()%>
        </div>
        <div id="fm-eassy-content">
            <%= q.getContent()%>
        </div>
    </div>
    <form id="fm-eassy-comment" method="post" action="/service/addAnswer">
        <div>写评论</div>
        <input type="hidden" name="qid" value="<%= q.getId()%>"/>
        <textarea cols="80" rows="5" name="content" id="fm-eassy-comments"></textarea>
        <button type="submit">提交</button>
    </form>
    <hr>
    <div id="fm-eassy-comment">
        <%
            Answer[] answers = q.getAnswers();
            if (answers == null || answers.length == 0) {
                out.println("No more");
            } else {
                for (Answer a : answers) {
        %>
        <div id="fm-eassy-comment-list">
            <div class="fm-eassy-comment-author"><a href="#"><%= a.getName()%></a></div>
            <div class="fm-eassy-comment-content"><%= a.getContent()%></div>
            <hr>
        </div>
        <% }
        } %>

    </div>

</div>


<%@ include file="footer.jsp" %>
