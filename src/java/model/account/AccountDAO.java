/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

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
public class AccountDAO {
    
    public void updateScore(String account_id , int score){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AccountDTO checkLogin(String _email, String _password) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, _email);
            stm.setString(2, _password);
            rs = stm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role_id");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                boolean status = rs.getBoolean("status");
                return new AccountDTO(id, username, email, password, role, score, rank, status);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<AccountDTO> getAllAccount() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT * FROM Users";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            List<AccountDTO> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role_id");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                boolean status = rs.getBoolean("status");
                AccountDTO account = new AccountDTO(id, username, email, password, role, score, rank, status);
                list.add(account);
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public AccountDTO signUpAccount(String _email, String _password) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            int accNumber = this.getAllAccount().size();
            String username = "user" + Integer.toString(accNumber + 1);
            String sql = "insert into Users (username , email , [password] , role_id , score , [rank] , [status]) \n"
                    + "values (?,?,?,1,0,0,1)";
            stm = con.prepareStatement(sql) ;
            stm.setString(1, username);
            stm.setString(2, _email);
            stm.setString(3, _password);
            stm.executeUpdate() ;
            return this.checkLogin(_email, _password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<AccountDTO> getTopScoreAccount(){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT TOP(10) * FROM Users ORDER BY score DESC";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            List<AccountDTO> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role_id");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                boolean status = rs.getBoolean("status");
                AccountDTO account = new AccountDTO(id, username, email, password, role, score, rank, status);
                list.add(account);
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        List<AccountDTO> list = dao.getTopScoreAccount() ;
        for(AccountDTO account : list){
            System.out.println(account);
        }
    }
}
