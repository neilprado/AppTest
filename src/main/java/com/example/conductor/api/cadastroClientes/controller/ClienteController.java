package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.exception.ClienteException;
import com.example.conductor.api.cadastroClientes.model.Cliente;
import com.example.conductor.api.cadastroClientes.repository.ClienteRepository;
import com.example.conductor.api.cadastroClientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService service;

    private final ClienteRepository dao;

    public ClienteController(ClienteRepository dao) {
        this.dao = dao;
    }

    @PostMapping("cliente/login")
    public ResponseEntity<String> login(@RequestBody Cliente c){
       Cliente cliente = dao.findByEmail(c.getEmail());
       System.out.println(cliente);

        if(!cliente.getSenha().equals(c.getSenha())) {
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        if (cliente == null){
           return ResponseEntity.notFound().build();
       }
       String token = "TokenGeneratedDone";
       return ResponseEntity.ok(token);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listAll(){
        return ResponseEntity.ok(dao.findAll());
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.ok(dao.save(cliente));
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        try {
            dao.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable(value = "id") Long id) throws ClienteException {
        Optional<Cliente> cliente = dao.findById(id);
        if (!cliente.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente.get());
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> update(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente)
            throws ClienteException {
        Cliente c = dao.findById(id).get();
        if(c == null)
            return ResponseEntity.notFound().build();
        c.setNome(cliente.getNome());
        c.setDataNascimento(cliente.getDataNascimento());
        c.setEmail(cliente.getEmail());
        c.setTelefone(cliente.getTelefone());
        c.setSenha(cliente.getSenha());
        c.setEndereco(cliente.getEndereco());
        return ResponseEntity.ok(dao.save(c));
    }




    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente c) { return service.adicionar(c); }

    @GetMapping(path = {"/{id}"})
    public Cliente listarId(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Cliente editar(@RequestBody Cliente c, @PathVariable("id") long id) {
        c.setId(id);
        return service.editar(c);
    }

    @DeleteMapping
    public Cliente delete(@PathVariable("id") int id) {
        return service.deletar(id);
    }

}
