/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadeTest;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gian Pestana
 */
public class ClienteEmpresaTest {

    @Test
    public void cadastrarClienteEmpresatest() {
        Empresa emp = new Empresa(1000, "Mackenzie");
        Pessoa p1 = new Pessoa("Gian", 12345678);
        ClienteEmpresa ce1 = new ClienteEmpresa(456, emp, 36411351848L, p1.getNome(), p1.getTelefone());
        assertEquals((Integer) 456, ce1.getCodigo());
        assertEquals(1000, emp.getNumeroContrato());
        assertEquals("Mackenzie", emp.getNomeEmpresa());
        assertEquals(36411351848L, ce1.getCpf());
        assertEquals("Gian", p1.getNome());
        assertEquals(12345678, p1.getTelefone());
    }

    @Test
    public void editaClienteEmpresaTest() {
        Empresa emp2 = new Empresa(1000, "Mackenzie2");
        Pessoa p2 = new Pessoa("Rodrigo", 12345678);
        ClienteEmpresa ce1 = new ClienteEmpresa(456, emp2, 1351848, p2.getNome(), p2.getTelefone());
        ce1.setCpf(7654321);
        ce1.setCodigo(123);
        assertNotSame(1351848,ce1.getCpf());
        assertNotSame(456,ce1.getCodigo());
    }
    
    @Test(expected = Exception.class)
    public void verificarDadosInvalidosTest()throws Exception{
        Empresa emp3 = new Empresa(1000, "Mackenzie");
        Pessoa p3 = new Pessoa("Joao", 12345678);
        ClienteEmpresa ce3 = new ClienteEmpresa(100.5, emp3, -1351848, p3.getNome(), p3.getTelefone());
    }
    

}
