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

    public void updateScore(String account_id, int score) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String updateScoreSql = "update Users\n"
                    + "set score = ?\n"
                    + "where id = ?";
            stm = con.prepareStatement(updateScoreSql);
            stm.setInt(1, score);
            stm.setString(2, account_id);
            stm.executeUpdate();

            String updateRankSql = "WITH RankedUsers AS (\n"
                    + "    SELECT\n"
                    + "        id,\n"
                    + "        ROW_NUMBER() OVER (ORDER BY Score DESC) AS Rank\n"
                    + "    FROM\n"
                    + "        Users\n"
                    + ")\n"
                    + "UPDATE U\n"
                    + "SET U.Rank = R.Rank\n"
                    + "FROM\n"
                    + "    Users U\n"
                    + "JOIN RankedUsers R ON U.id = R.id;";
            stm = con.prepareStatement(updateRankSql);
            stm.executeUpdate() ;
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
    
    public void updateStatus(String accId , int status){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "update Users set status = ? where id = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setString(2, accId);
            stm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, _email);
            stm.setString(3, _password);
            stm.executeUpdate();
            return this.checkLogin(_email, _password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<AccountDTO> getTopScoreAccount() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT TOP(10) * FROM Users ORDER BY rank";
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
        dao.updateScore("7", 0);
    }
}
