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
        List<Cliente>
        Cliente c2 = ClienteBuilder.getCliente().changeName("Teste 2").changeEmail("teste2@teste2.com").now();
        Cliente c3 = ClienteBuilder.getCliente().changeName("Teste 3").changeEmail("teste3@test3.com").now();
        
    }
}
