package com.example.conductor.api.cadastroClientes.mockito;

import com.example.conductor.api.cadastroClientes.builder.ClienteBuilder;
import com.example.conductor.api.cadastroClientes.model.Cliente;
import com.example.conductor.api.cadastroClientes.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClienteIntegrationTest {
    private Cliente c;

    @Mock
    private ClienteRepository dao;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        c = ClienteBuilder.getCliente().now();
    }

    @Test
    public void saveClientWithSuccess(){
        c = ClienteBuilder.getCliente().changeName("Teste de Mocks").changeEmail("teste@teste.com").now();
        Mockito.when(dao.save(c)).thenReturn(c);
        Cliente result = dao.save(c);
        Assert.assertEquals("Expecting Teste de Mocks", "Teste de Mocks", result.getNome());
    }

    @Test
    public void listAllClientsWithSuccess(){
<<<<<<< HEAD
        Cliente c2 = ClienteBuilder.getCliente().changeName("Teste 2").changeEmail("teste2@teste2.com").now();
        Cliente c3 = ClienteBuilder.getCliente().changeName("Teste 3").changeEmail("teste3@test3.com").now();
        
=======
        List<Cliente>  clientes = new ArrayList<Cliente>();
        clientes.add(ClienteBuilder.getCliente().changeName("Teste 2").changeEmail("teste2@teste2.com").now());
        clientes.add(ClienteBuilder.getCliente().changeName("Teste 3").changeEmail("teste3@test3.com").now());
        clientes.add(c);

        Mockito.when(dao.findAll()).thenReturn(clientes);
        List<Cliente> result = dao.findAll();
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void listClientByNome(){
        Mockito.when(dao.findByNome(c.getNome())).thenReturn(c);
        Cliente result = dao.findByNome(c.getNome());
        Assert.assertEquals("Neil", result.getNome());
    }

    @Test
    public void removeClientWithSuccess(){
        Cliente toDelete = ClienteBuilder.getCliente()
                .changeName("Será removido").changeEmail("delete@delete.com").now();
        dao.delete(toDelete);
        Mockito.verify(dao, Mockito.times(1)).delete(toDelete);
>>>>>>> cbdb6cbfacf035eb16a6f8bac8ac84b332b510c5
    }
}
