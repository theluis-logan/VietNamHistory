/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.quiz.QuizDAO;
import model.quiz.QuizDTO;

/**
 *
 * @author NguyenTheAnh
 */
@WebServlet(name = "LoadQuizControl", urlPatterns = {"/loadQuiz"})
public class LoadQuizControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int num = Integer.parseInt(request.getParameter("numOfQuestion"));
            QuizDAO dao = new QuizDAO();
            List<QuizDTO> quizList = dao.getQuiz(num);
            int count = 1;
            for (QuizDTO quiz : quizList) {
                out.print("<form id=\"" + count + "\"class=\"form--test__card\" qa=\"" + quiz.getCorrect() + "\">\n"
                        + "                        <p class=\"test--card__question\">" + quiz.getQuestion() + "</p>\n"
                        + "                        <div class=\"test--card__answer\">\n"
                        + "                            <input id=\"ans1" + count + "\" name=\"" + count + "\" type=\"radio\" value=\"1\">\n"
                        + "                            <label for=\"ans1" + count + "\" class=\"test--card__label\">A." + quiz.getAnswerA() + "</label>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"test--card__answer\">\n"
                        + "                            <input id=\"ans2" + count + "\" name=\"" + count + "\" type=\"radio\" value=\"2\">\n"
                        + "                            <label for=\"ans2" + count + "\" class=\"test--card__label\">B." + quiz.getAnswerB() + "</label>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"test--card__answer\">\n"
                        + "                            <input id=\"ans3" + count + "\" name=\"" + count + "\" type=\"radio\" value=\"3\">\n"
                        + "                            <label for=\"ans3" + count + "\" class=\"test--card__label\">C." + quiz.getAnswerC() + "</label>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"test--card__answer\">\n"
                        + "                            <input id=\"ans4" + count + "\" name=\"" + count + "\" type=\"radio\" value=\"4\">\n"
                        + "                            <label for=\"ans4" + count + "\" class=\"test--card__label\">D." + quiz.getAnswerD() + "</label>\n"
                        + "                        </div>\n"
                        + "                    </form>");
                count++;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
