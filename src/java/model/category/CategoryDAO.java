/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.category;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.post.PostDAO;

/**
 *
 * @author NguyenTheAnh
 */
public class CategoryDAO {

    public List<CategoryDTO> getAllCategory() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [Categories]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            List<CategoryDTO> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new CategoryDTO(id, name));
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<CategoryDTO> list = dao.getAllCategory();
        for(CategoryDTO cate : list){
            System.out.println(cate);
        }
    }
}
