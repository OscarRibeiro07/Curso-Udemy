package br.com.erudio.dto.v1;

import java.util.Objects;

public class PersonDTOV1 {

    private static final long serializeble = 1L;
    private Long id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String genero;

    public PersonDTOV1() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTOV1 personDTO)) return false;
        return Objects.equals(id, personDTO.id) && Objects.equals(nome, personDTO.nome) && Objects.equals(sobrenome, personDTO.sobrenome) && Objects.equals(endereco, personDTO.endereco) && Objects.equals(genero, personDTO.genero);
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
}
