package admin;

public class AdminDTO {
    int adminId;
    
    String password;
    String email;

    public AdminDTO(int adminId, String email) {
        this.adminId = adminId;
        this.email = email;
    }

    public AdminDTO(int adminId, String password, String email) {
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

    public void setEmail(String email) {
        this.email = email;
    }

    

    // cons
   
    // getter setter
    

    // method
    @Override
    public String toString(){
               return "StudentDTO{" + "id=" + adminId + ", email=" + email + ", password=" + password+ '}';

    }

}
