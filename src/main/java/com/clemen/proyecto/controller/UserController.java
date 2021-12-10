package com.clemen.proyecto.controller;

import com.clemen.proyecto.dao.UserDAO;
import com.clemen.proyecto.entities.User;
import com.clemen.proyecto.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * TODO: Crear servicio
 * Metodo actualizar
 * Probar guardado con asociaciones
 *  -Billing Info desde aqui
 *  -Task desde el controlador tasks
 */

@RestController
public class UserController {

    private UserRepository userRepository;
    private UserDAO userDao;

    public UserController(UserRepository userRepository, UserDAO userDao) {

        this.userRepository=userRepository;
        this.userDao=userDao;
    }


    // Mostrar Jpa Repository
    @GetMapping("/api/users")
    private List<User> findAll(){

        return this.userRepository.findAll();
    }

    // Mostrar Criteria
    @GetMapping("/api/users/active")
    private List<User> findAllCriteria(){

       return this.userDao.findAllActive();
    }

    // Crear
    @PostMapping("/api/users")
    private User create(@RequestBody User user){

        return this.userRepository.save(user);
    }

    // Actualizar
    @PutMapping("/api/users/{id}")
    private String update(@PathVariable Long id, @RequestBody User user){

        // Si permitimos update de todo podemos dejar solo esta linea y el metodo void
        // return this.userRepository.save(user);
        // Si queremos que solo modifique algunos campos
        User userUpdate = this.userRepository.findById(id).orElse(null);
        if (userUpdate != null) {
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setDni(user.getDni());
            userUpdate.setActive(user.isActive());
            this.userRepository.save(userUpdate);
            return "Usuario actualizado";
        }

        return "No existe el usuario";
    }

    // TODO revisar Integridad referencial
    // Podemos dejarlo void y no devolver nada o
    // Delete
    @DeleteMapping("/api/users/{id}")
    private String delete(@PathVariable Long id){

        if (this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
        return "Usuario eliminado";
        }
        return "No existe el usuario";

        
    }




}
