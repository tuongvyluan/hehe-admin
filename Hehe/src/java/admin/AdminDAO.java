/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

/**
 *
 * @author triud
 */
public class AdminDAO {
     public static AdminDTO getAdmin(String Email, String Password)  {
        Connection cn = null;
        AdminDTO acc = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT FirstName, LastName, Email, Password, PhoneNumber, "
                        + "Status FROM Author WHERE [Email] = ? and [Password] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Email);
                pst.setString(2, Password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int AccID = rs.getInt("Id");
                    acc = new AdminDTO(AccID,Email,Password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
