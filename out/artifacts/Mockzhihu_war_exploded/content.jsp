<%@ page import="top.karls.models.Question" %>
<div class="fm-content" id="fm-content">
    <form action="/service/addQuestion" class="fm-question" method="post">
        <span>问题标题:<input type="text" name="title" id="fm-question-title"></span>
        <span>具体描诉:<textarea cols="80" rows="5" name="content" id="fm-question-content"></textarea></span>
        <button class="fm-question-button" type="submit">提问</button>
    </form>

    <%
        Question[] questions = Question.getAllQuestions();
        if (questions == null) {
            out.println("<div>No more!</div>");
        } else {
            for (Question q : questions) {
    %>
    <div class="fm-content-list">
        <h3><a href="/eassy.jsp?id=<%= q.getId()%>" id="fm-content-href1"><%= q.getTitle()%>
        </a></h3>
        <div class="fm-content-username" id="fm-content-username1"><%= q.getName()%></div>
        <div class="fm-content-anwers" id="fm-content-anwers1">
            <%= q.getContent() %>
        </div>
    </div>
    <% }
    } %>
</div>

