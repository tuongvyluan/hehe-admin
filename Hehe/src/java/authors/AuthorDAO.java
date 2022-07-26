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
    private final String CREATE_AUTHOR = "INSERT INTO Author "
            + "(status, email, password, firstName, lastName) VALUES "
            + "('ACTIVE', ?, ?, ?, ?)";
    private final String AUTHOR_MODEL_FIELDS = "id, firstName, lastName, email, status";
    private final String CHECK_GOOGLE_LOGIN = "SELECT " + AUTHOR_MODEL_FIELDS
            + " FROM Author WHERE email=? AND Status='ACTIVE'";
    
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
                String sql = "SELECT Id, FirstName, LastName, Email, PhoneNumber, "
                        + "Status FROM Author WHERE [Email] = ? AND Password = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phoneNumber = rs.getString("PhoneNumber");
                    acc = new AuthorDTO(id, firstName, lastName, email, phoneNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    public static AuthorDTO loginAuthor(String email)  {
        Connection cn = null;
        AuthorDTO acc = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT Id, FirstName, LastName, Email, PhoneNumber, "
                        + "Status FROM Author WHERE [Email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phoneNumber = rs.getString("PhoneNumber");
                    acc = new AuthorDTO(id, firstName, lastName, email, phoneNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    public static boolean addAuthor(String email, String password, String firstName) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("INSERT INTO Author (Email, Password, FirstName) VALUES (?,?,?)");
                ptm.setString(1, email);
                ptm.setString(2, password);
                ptm.setString(3, firstName);
                check = ptm.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean add(AuthorDTO author) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null && author != null) {
                ptm = conn.prepareStatement(CREATE_AUTHOR);
                ptm.setString(1, author.getEmail());
                ptm.setString(2, author.getPassword());
                ptm.setString(3, author.getFirstName() == null ? "" : author.getFirstName());
                ptm.setString(4, author.getLastName() == null ? "" : author.getLastName());
                check = ptm.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkEmail(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_GOOGLE_LOGIN);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }
    
//    public static AuthorDTO comparePassword(int id, String Password)  {
//        Connection cn = null;
//        AuthorDTO acc = null;
//        try {
//            cn = DBUtils.getConnection();
//            if (cn != null) {
//                String sql = "SELECT Password FROM Author WHERE [Email] = ? and [Password] = ?";
//                PreparedStatement pst = cn.prepareStatement(sql);
//                pst.setString(1, email);
//                pst.setString(2, password);
//                ResultSet rs = pst.executeQuery();
//                if (rs.next()) {
//                    int id = rs.getInt("Id");
//                    String firstName = rs.getString("FirstName");
//                    String lastName = rs.getString("LastName");
//                    String phoneNumber = rs.getString("PhoneNumber");
//                    acc = new AuthorDTO(id, password, firstName, lastName, email, phoneNumber);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return acc;
//    }
    
    public static AuthorDTO changePassword(int id, String newPassword)  {
        Connection cn = null;
        AuthorDTO acc = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Author SET Password = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, newPassword);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
