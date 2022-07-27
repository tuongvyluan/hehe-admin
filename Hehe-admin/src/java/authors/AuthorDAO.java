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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import utils.MyUtils;

public class AuthorDAO {

    private AuthorModel author;
//Author model field
    private final String AUTHOR_MODEL_FIELDS = "id, firstName, lastName, dob, email, password, "
            + "phoneNumber, status, createdAt, updatedAt";

//
    private final String GET_AUTHOR = "SELECT FirstName, LastName, Email FROM Author WHERE Id=?";
    private final String CREATE_AUTHOR = "INSERT INTO Author "
            + "(status, email, password, firstName, lastName) VALUES "
            + "('ACTIVE', ?, ?, ?, ?)";

    private final String CHECK_GOOGLE_LOGIN = "SELECT " + AUTHOR_MODEL_FIELDS
            + " FROM Author WHERE email=? AND Status='ACTIVE'";
    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    private final String GET_AUTHORS = "SELECT " + AUTHOR_MODEL_FIELDS + " FROM Author ORDER BY createdAt "
            + PAGINATION;

    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT " + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

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

    public static AuthorDTO loginAuthor(String email, String password) {
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

    public static AuthorDTO loginAuthor(String email) {
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

    public static boolean changePassword(int authorId, String newPassword) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Author SET Password = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newPassword);
                pst.setInt(2, authorId);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<AuthorModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<AuthorModel> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }

        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                ptm = conn.prepareStatement(DECLARE_PAGINATION + GET_AUTHORS);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    author = new AuthorModel();
                    author.setAuthorId(rs.getInt("id"));
                    author.setFirstName(rs.getString("firstName"));
                    author.setLastName(rs.getString("lastName"));
                    author.setEmail(rs.getString("email"));
                    author.setPassword(rs.getString("password"));
                    author.setPhoneNumber(rs.getString("phoneNumber"));
                    author.setStatus(rs.getString("status"));
                    list.add(author);

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

        return list;
    }

    public static boolean updateAuthorStatus(int id, String status) {
        Connection cn = null;
        AuthorModel auth = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update Author set Status = ? where [Id] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<AuthorModel> getAuthorBySearch(String name) {
        ArrayList<AuthorModel> list = new ArrayList<>();
        Connection cn = null;
        AuthorModel auth = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [Id],[FirstName],[LastName],[Email],"
                        + "[PhoneNumber],[Status] from Author where [FirstName] like CONCAT ('%',?,'%') ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String FirstName = rs.getString("FirstName");
                    String LastName = rs.getString("LastName");
                    String Email = rs.getString("Email");
                    String Status = rs.getString("Status");
                    String Phone = rs.getString("PhoneNumber");
                    auth = new AuthorModel(id, FirstName, LastName, Email, Phone, Status);
                    list.add(auth);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean createAuthor(String firstName, String lastName, String email, String status, String phoneNumber, String password) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Author (FirstName, LastName,Password, Email, Status, PhoneNumber) VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, password);
                pst.setString(4, email);
                pst.setString(5, status);
                pst.setString(6, phoneNumber);

                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
