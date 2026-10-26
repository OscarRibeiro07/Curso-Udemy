package br.com.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serializeble = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "sobrenome", nullable = false, length = 80)
    private String sobrenome;
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;
    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(nome, person.nome) && Objects.equals(sobrenome, person.sobrenome) && Objects.equals(endereco, person.endereco) && Objects.equals(genero, person.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, endereco, genero);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void getGenero(String s) {

    }
}
