package com.example.conductor.api.cadastroClientes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    @Size(min = 3, max = 20, message = "O nome do usuário deve ter entre 3 e 20 caracteres")
    private String nome;

    @NotBlank(message = "Campo email é obrigatório")
    @Email(message = "Não é um email válido")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Campo senha é obrigatório")
    private String senha;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String endereco;

    @Pattern(regexp = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Informe um telefone do tipo: [(83)99999-8888]")
    private String telefone;
    
    public Cliente() {
    }

    public Cliente(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Cliente(String nome, String email, String senha, Date dataNascimento, String endereco, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
