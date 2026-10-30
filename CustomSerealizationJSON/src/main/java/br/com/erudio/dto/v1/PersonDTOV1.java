package br.com.erudio.dto.v1;

import br.com.erudio.serialize.SerializeGenero;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import tools.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Objects;

// reordena resposta json postman
@JsonPropertyOrder({"id", "last_name", "sobrenome", "endereco", "genero"})
public class PersonDTOV1 {

    private static final long serializeble = 1L;
    private Long id;
    //muda nome das variaveis da resposta json
    @JsonProperty("last_name")
    private String nome;
    @JsonSerialize(using = SerializeGenero.class)
    private String genero;
    private String sobrenome;
    private String endereco;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTOV1 that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(endereco, that.endereco) && Objects.equals(genero, that.genero) && Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, endereco, genero, dataNascimento);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }




    public PersonDTOV1() {
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
