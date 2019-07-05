package com.example.conductor.api.cadastroClientes.repository;

import com.example.conductor.api.cadastroClientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findByNome(String nome);
    public Cliente findByEmail(String email);
    public Cliente findById(int id);
}
