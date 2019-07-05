package com.example.conductor.api.cadastroClientes.service;

import com.example.conductor.api.cadastroClientes.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listar();
    Cliente listarId(int id);
    Cliente adicionar(Cliente c);
    Cliente editar(Cliente c);
    Cliente deletar(int id);

}
