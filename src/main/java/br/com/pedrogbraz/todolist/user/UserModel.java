package br.com.pedrogbraz.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true) // Indica que o username, irá ser uma coluna única(valor único), para que não seja possível ter usernames repetidos
    private String username;
    private String name;
    private String password;

    @CreationTimestamp // Gravar a data em que o foi criado
    private LocalDateTime createdAt;

}
