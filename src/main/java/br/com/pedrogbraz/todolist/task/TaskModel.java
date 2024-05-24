package br.com.pedrogbraz.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/*
 *
 * Id
 * Usuário(ID_USUARIO)
 * Descriçção
 * Título
 * Data de início
 * Data de término
 * Prioridade
 *
 */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID") // Gerar um id automáticamente
    private UUID id;
    private String description;

    @Column(length = 50) // Limitando o tamanho máximo de 50 caracteres
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;

    @CreationTimestamp // Gravar a data em que a tabela foi gerada
    private LocalDateTime createdAt;

}
