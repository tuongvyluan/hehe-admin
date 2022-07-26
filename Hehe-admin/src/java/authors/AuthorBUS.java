/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Tuong Vy
 */
public class AuthorBUS {
    
    private AuthorDTO authorDTO;
    private AuthorDAO dao;

    public AuthorBUS() {
    }
    
    public AuthorDTO get(int authorId) throws SQLException {
        dao = new AuthorDAO();
        authorDTO = dao.get(authorId);
        return authorDTO;
    }
    
    public AuthorDTO register(AuthorDTO author) throws SQLException {
        AuthorDTO error = null;
        if (author != null) {
            AuthorDAO dao = new AuthorDAO();
            if (dao.checkEmail(author.getEmail())) {
                error = new AuthorDTO();
                error.setEmail("This email is already used.");
            } else {
                if (!dao.add(author)) {
                    error = new AuthorDTO();
                }
            }
        }
        return error;
    }
}
