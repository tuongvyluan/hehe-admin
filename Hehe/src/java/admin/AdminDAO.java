/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import authors.AuthorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

/**
 *
 * @author triud
 */
public class AdminDAO {

//    public static AdminDTO getAdmin(String Email, String Password) {
//        Connection cn = null;
//        AdminDTO acc = null;
//        try {
//            cn = DBUtils.getConnection();
//            if (cn != null) {
//                String sql = "SELECT FirstName, LastName, Email, Password, PhoneNumber, "
//                        + "Status FROM Author WHERE [Email] = ? and [Password] = ?";
//                PreparedStatement pst = cn.prepareStatement(sql);
//                pst.setString(1, Email);
//                pst.setString(2, Password);
//                ResultSet rs = pst.executeQuery();
//                if (rs.next()) {
//                    int AccID = rs.getInt("Id");
//                    acc = new AdminDTO(AccID, Email);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return acc;
//    }

    public static AdminDTO loginAdmin(String email) {
        Connection cn = null;
        AdminDTO acc = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT Id, Email Status FROM Admin WHERE [Email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id");
                    acc = new AdminDTO(id, email);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
