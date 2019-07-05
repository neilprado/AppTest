package com.example.conductor.api.cadastroClientes.builder;


import com.example.conductor.api.cadastroClientes.model.Cliente;

public class ClienteBuilder {
    private Cliente cliente;

    private ClienteBuilder(){}

    public static ClienteBuilder getCliente(){
        ClienteBuilder builder = new ClienteBuilder();
        builder.cliente = new Cliente();
        builder.cliente.setNome("Neil");
        builder.cliente.setEmail("a@a.com");
        builder.cliente.setSenha("asdfg");
        builder.cliente.setTelefone("(83)99999-8888");
        return builder;
    }

    public Cliente now(){
        return this.cliente;
    }

    public ClienteBuilder changeName(String nome){
        cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder changePassword(String senha){
        cliente.setSenha(senha);
        return this;
    }

    public ClienteBuilder changeEmail(String email){
        cliente.setEmail(email);
        return this;
    }

    public ClienteBuilder changePhone(String phone){
        cliente.setTelefone(phone);
        return this;
    }

    public ClienteBuilder changeId(Long id){
        cliente.setId(id);
        return this;
    }
}