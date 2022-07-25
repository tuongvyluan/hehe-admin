/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luan Tuong Vy
 */
public class AuthorBUS {
    
    private AuthorDTO authorDTO;
    private AuthorDAO dao;

    public AuthorBUS() {
    }
    
   
    
    public AuthorDTO getAuthor(String email) {
        AuthorDTO author = null;
        // TODO Auto-generated method stub
        return author;
    }

    public AuthorDTO getAuthor(int id) {
        AuthorDTO author = null;
        // TODO Auto-generated method stub
        return author;
    }
    public List<AuthorModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        AuthorDAO auth = new AuthorDAO();
        List<AuthorModel> list = auth.get(pageNumber, rowsOfPage);
        return list;
    }
}
