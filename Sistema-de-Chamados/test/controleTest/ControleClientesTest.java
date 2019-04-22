/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControleClientes;
import controle.ControleClientes;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gian Pestana
 */
public class ControleClientesTest {
    
    @Test
    public void clienteDAONullTest(){
        ControleClientes cc = new ControleClientes();
        assertNotNull(cc.getClienteDAO());
    }
    
    @Test
    public void incluiNovoClienteTest(){
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"FCI");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, "Joao", 85748574);
        
        ClienteEmpresa ce = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
        assertTrue((cli.getNome().equals(ce.getNome()))&&(cli.getCpf()==ce.getCpf())&&(cli.getTelefone()==ce.getTelefone())&&(cli.getEmpresa().equals(ce.getEmpresa())));
    }
    
    
    @Test (expected = Exception.class)
    public void dadosInvalidosClienteTest() throws Exception{
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"FCI");
        //ClienteEmpresa cli = new ClienteEmpresa(12a, empresa, ~2345678912L, null, 88574);
         //ClienteEmpresa ce = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
    }
    
    
}
