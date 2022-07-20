/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author triud
 */
public class AdminModels {
        int adminId;
    
    String password;
    String email;
    

    // cons
     public AdminModels(int adminId, String password, String email) {   
        this.adminId = adminId;
        this.password = password;
        this.email = email;
    }
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    // getter setter
    public void setEmail(String email) {     
        this.email = email;
    }

    // method
    public AdminDTO toDTO() {
        return new AdminDTO(adminId, password, email);
    }
    
     
}
