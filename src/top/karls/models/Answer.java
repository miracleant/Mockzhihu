package top.karls.models;

import top.karls.utils.SqlHelper;

import java.sql.*;
import java.util.Date;

/**
 * Created by karlind on 10/16/16.
 */
public class Answer {
    private int id;
    private String content;
    private Date pubTime;
    private Question question;
    private String name;

    public Answer(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    public void setPubTime(Date pubTime){
        this.pubTime = pubTime;
    }

    public Question getQuestion(){
        return question;
    }
    public void setQuestion(Question q){
        this.question = q;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public static Answer getAnswerById(int id){
        if(id<1){
            return null;
        }
        String sql = "select * from answer where id=?";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Answer ans = new Answer();
                ans.setId(rs.getInt("id"));
                ans.setContent(rs.getString("content"));
                ans.setName(rs.getString("name"));
                long timestamp = rs.getLong("pub_time");
                Date pub_time = new Date(timestamp);
                ans.setPubTime(pub_time);
                int question_id = rs.getInt("question_id");
                ans.setQuestion(Question.getQuestionById(question_id));
                return ans;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(){
        String sql = "insert into answer(content, pub_time,question_id, name)" +
                "values(?,?,?,?)";
        try{
            PreparedStatement pst = SqlHelper.getConnection().prepareStatement(sql);
            pst.setString(1, content);
            pst.setLong(2, System.currentTimeMillis());
            pst.setInt(3, question.getId());
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
