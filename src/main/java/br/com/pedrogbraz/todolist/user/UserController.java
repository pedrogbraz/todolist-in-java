package br.com.pedrogbraz.todolist.user;

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
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.getName());
    }
}
