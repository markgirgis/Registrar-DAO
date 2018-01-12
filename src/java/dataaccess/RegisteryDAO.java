/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import java.util.List;
import transferobjects.Registry;
/**
 *
 * @author markg
 */
public interface RegisteryDAO {
     /**
     * method to return a list of all registrys in the database
     * @return List<Registry>
     */
    List<Registry> getAllRegistries();
    /**
     * method to add a new Registry to the database
     * @param registry 
     */
    void addRegistry(Registry r);
}
