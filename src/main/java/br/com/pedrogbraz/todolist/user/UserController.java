package br.com.pedrogbraz.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Modificadores
 * public - Qualquer um pode acessar
 * private - Pode ser usado somente na classe dele
 * protected - Só tem acesso os filhos que estão em seu pacote
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // Definindo que o spring que vai gerenciar o ciclo de vida
    private IUserRepository userRepository;

    /*
     * String (texto)
     * Integer (int) - Números inteiros
     * Double (double) - Números 0.0000
     * Float (float) - Números 0.000
     * char (char) - Apenas caractéres
     * Date (date) - Para trabalhar com datas
     * void (void) - Quando não possui nenhum retorno
     */
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
