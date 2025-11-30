package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Define a entidade Curso mapeada para a tabela "curso" no banco
@Entity
@Table(name = "curso")
@NoArgsConstructor //gera construtor vazio
@Data //gera getters, setters
@AllArgsConstructor //gera construtor com tudo
@EqualsAndHashCode(callSuper = false)
public class Curso extends PersistenceEntity {

     // Nome do curso, obrigatório e com máximo de 120 caracteres
    @Column(nullable = false, length = 120)
    private String nome;

    // Carga horária do curso, obrigatória
    @Column(nullable = false)
    private int cargaHoraria;

    // Código do curso, obrigatório e com máximo de 20 caracteres
    @Column(nullable = false, length = 20)
    private String codigoCurso;
    
    // Indica se o curso está ativo
    @Column(nullable = false)
    private boolean ativo;
}