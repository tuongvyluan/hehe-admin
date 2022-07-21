/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import authors.AuthorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class AuthorDAO {
    
    private final String GET_AUTHOR = "SELECT FirstName, LastName, Email FROM Author WHERE Id=?";
    
    public AuthorDTO get(int authorId) throws SQLException {
        AuthorDTO author = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_AUTHOR);
                ptm.setInt(1, authorId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    author = new AuthorDTO();
                    author.setAuthorId(authorId);
                    author.setFirstName(rs.getString("FirstName"));
                    author.setLastName(rs.getString("LastName"));
                    author.setEmail(rs.getString("Email"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return author;
    }
    
    public static AuthorDTO loginAuthor(String email, String password)  {
        Connection cn = null;
        AuthorDTO acc = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT Id, FirstName, LastName, Email, Password, PhoneNumber, "
                        + "Status FROM Author WHERE [Email] = ? and [Password] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phoneNumber = rs.getString("PhoneNumber");
                    acc = new AuthorDTO(id, password, firstName, lastName, email, phoneNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
