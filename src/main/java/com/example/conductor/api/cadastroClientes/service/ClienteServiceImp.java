package com.example.conductor.api.cadastroClientes.service;

import com.example.conductor.api.cadastroClientes.model.Cliente;
import com.example.conductor.api.cadastroClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Cliente adicionar(Cliente c) {
        return repository.save(c);
    }

    @Override
    public Cliente editar(Cliente c) { return repository.save(c); }

    @Override
    public Cliente deletar(int id) {
        Cliente c = repository.findById(id);
        if (c != null) {
            repository.delete(c);
        }
        return c;
    }

}
