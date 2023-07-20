/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.post;

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
public class PostDAO {

    public List<PostDTO> getAllPost() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[marker_id]\n"
                    + "      ,[category_id]\n"
                    + "      ,[content]\n"
                    + "      ,[title]\n"
                    + "  FROM Posts\n";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            List<PostDTO> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int markerId = rs.getInt("marker_id");
                int categoryId = rs.getInt("category_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                list.add(new PostDTO(id, title, content, categoryId, markerId));
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<PostDTO> getPostByCategory(String cid) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[marker_id]\n"
                    + "      ,[category_id]\n"
                    + "      ,[content]\n"
                    + "      ,[title]\n"
                    + "  FROM Posts\n"
                    + "  WHERE category_id = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, cid);
            rs = stm.executeQuery();
            List<PostDTO> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int markerId = rs.getInt("marker_id");
                int categoryId = rs.getInt("category_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                list.add(new PostDTO(id, title, content, categoryId, markerId));
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PostDTO getPost(String _id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[marker_id]\n"
                    + "      ,[category_id]\n"
                    + "      ,[content]\n"
                    + "      ,[title]\n"
                    + "  FROM Posts\n"
                    + "  WHERE id = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, _id);
            rs = stm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int markerId = rs.getInt("marker_id");
                int categoryId = rs.getInt("category_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                return new PostDTO(id, title, content, categoryId, markerId);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        PostDAO dao = new PostDAO();
        List<PostDTO> list = dao.getPostByCategory("1");
        for (PostDTO post : list) {
            System.out.println();
        }
    }
}
