/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaTest;

import Persistencia.ClienteDAO;
import Persistencia.ClienteDAO;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Gian Pestana
 */
public class ClienteDAOTest {
    Empresa empresa = new Empresa(1001, "Mackenzie");
    ClienteEmpresa ce1 = new ClienteEmpresa(456, empresa, 36411351848L, "Gian", 982785986);
    ClienteDAO clientedao = new ClienteDAO();

    @Test
    public void inserirClienteTest() {
        clientedao.put(ce1);
        ClienteEmpresa ce2 = clientedao.get(ce1.getCpf());
        Assert.assertTrue((ce1.getCodigo() == ce2.getCodigo()) && (ce1.getCpf() == ce2.getCpf()) && (ce1.getTelefone() == ce2.getTelefone()) && (ce1.getNome().equals(ce2.getNome()) && (ce1.getEmpresa().getNumeroContrato() == ce2.getEmpresa().getNumeroContrato()) && (ce1.getEmpresa().getNomeEmpresa().equals(ce2.getEmpresa().getNomeEmpresa()))));
    }

    @Test
    public void leituraTest() {
        clientedao.put(ce1);
        Assert.assertTrue(clientedao.voltaCashCliente().size() > 0);

    }

    @Test
    public void verificarDadoNaoExisteNoBancoTest() {
        clientedao.put(ce1);
        boolean resp = clientedao.validarCPF(45473486851L);
        Assert.assertFalse(resp);
        
    }

}
