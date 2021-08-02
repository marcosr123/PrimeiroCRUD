package com.marcos.primeirocrud.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "livro_sequence", sequenceName = "livro_sequence", allocationSize = 1)
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_sequence")
    private Integer id;
    private String nome;
    private String descricao;
    private String codigo;

}
