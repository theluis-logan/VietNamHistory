/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.quiz;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenTheAnh
 */
public class QuizDAO {
    public List<QuizDTO> getQuiz(int numberOfQuestion){
        Connection con = null ;
        PreparedStatement stm = null ;
        ResultSet rs = null ;
        try{
            con = DBContext.getConnection() ;
            String sql = "  SELECT TOP(?) * FROM Quizzes ORDER BY NEWID()" ;
            stm = con.prepareStatement(sql);
            stm.setInt(1, numberOfQuestion);
            rs = stm.executeQuery() ;
            List<QuizDTO> list = new ArrayList<>() ;
            while(rs.next()){
                int id = rs.getInt("id") ;
                String question = rs.getString("question");
                list.add(new QuizDTO(id, question));
            }
            for(QuizDTO quiz : list){
                sql = "SELECT * FROM Answers WHERE quiz_id = ?" ;
                stm = con.prepareStatement(sql) ;
                stm.setInt(1, quiz.getId());
                rs = stm.executeQuery() ;
                int correct = 1 ;
                while(rs.next()){
                    String ans = rs.getString("answer_text");
                    boolean isCorrect = rs.getBoolean("is_correct");
                    switch(correct){
                        case 1:
                            quiz.setAnswerA(ans);
                            if(isCorrect) quiz.setCorrect(correct);
                            break ;
                        case 2:
                            quiz.setAnswerB(ans);
                            if(isCorrect) quiz.setCorrect(correct);
                            break ;
                        case 3:
                            quiz.setAnswerC(ans);
                            if(isCorrect) quiz.setCorrect(correct);
                            break ;
                        case 4:
                            quiz.setAnswerD(ans);
                            if(isCorrect) quiz.setCorrect(correct);
                            break ;
                    }
                    correct++ ;
                }
            }
            return list ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
    
    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        List<QuizDTO> list = dao.getQuiz(20) ;
        for(QuizDTO quiz : list){
            System.out.println(quiz);
        }
    }
}
