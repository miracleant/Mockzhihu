package top.karls.models;

import java.sql.*;
import java.util.*;
import top.karls.utils.*;
import java.util.Date;

/**
 * Created by karlind on 10/16/16.
 */
public class Question {
    private int id;
    private String title;
    private String content;
    private Date pubTime;
    private String name;

    public Question(){

    }
    public Question(String title, String content){
        this.title = title;
        this.content = content;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public Date getPubTime(){
        return pubTime;
    }
    public void setPubTime(Date date){
        pubTime = date;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "["+title+"@Question]";
    }

    public static Question getQuestionById(int id){
        if(id<1){
            return null;
        }
        String sql = "select * from question where id=?";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setTitle(rs.getString("title"));
                q.setContent(rs.getString("content"));
                q.setName(rs.getString("name"));
                long timestamp = rs.getLong("pub_time");
                Date pub_time = new Date(timestamp);
                q.setPubTime(pub_time);
                return q;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Question[] getAllQuestions(){
        String sql = "select * from question order by pub_time desc";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Question> questions = new ArrayList<>();
            while(rs.next()){
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setTitle(rs.getString("title"));
                q.setContent(rs.getString("content"));
                q.setName(rs.getString("name"));
                long timestamp = rs.getLong("pub_time");
                Date pub_time = new Date(timestamp);
                q.setPubTime(pub_time);
                questions.add(q);
            }
            return questions.toArray(new Question[questions.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Answer[] getAnswers(){
        String sql = "select * from answer where question_id=? order by pub_time desc";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            List<Answer> answers = new ArrayList<>();
            while(rs.next()){
                Answer a = new Answer();
                a.setId(rs.getInt("id"));
                a.setContent(rs.getString("content"));
                a.setName(rs.getString("name"));
                long timestamp = rs.getLong("pub_time");
                Date pub_time = new Date(timestamp);
                a.setPubTime(pub_time);
                answers.add(a);
            }
            return answers.toArray(new Answer[answers.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Question[] searchQuestion(String keyword){
        String sql = "select * from question where title like ? or content like ?;";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setString(1, "%"+keyword+"%");
            pst.setString(2, "%"+keyword+"%");
            System.out.println(pst);
            ResultSet rs = pst.executeQuery();
            List<Question> questions = new ArrayList<>();
            while(rs.next()){
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setTitle(rs.getString("title"));
                q.setContent(rs.getString("content"));
                q.setName(rs.getString("name"));
                long timestamp = rs.getLong("pub_time");
                Date pub_time = new Date(timestamp);
                q.setPubTime(pub_time);
                questions.add(q);
            }
            return questions.toArray(new Question[questions.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(){
        String sql = "insert into question(title, content, pub_time, name)" +
                     "values(?,?,?, ?)";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, content);
            pst.setLong(3, System.currentTimeMillis());
            pst.setString(4, name);
            int row = pst.executeUpdate();
            if(row==0){
                return false;
            }else{
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
