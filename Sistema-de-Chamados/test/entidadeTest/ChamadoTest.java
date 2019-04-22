/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadeTest;

import entidade.Chamado;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Empresa;
import entidade.Pessoa;
import entidade.Pessoa;
import entidade.Tecnico;
import entidade.Tecnico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31704913
 */
public class ChamadoTest {

    Empresa emp = new Empresa(1, "Mackenzie");
    Pessoa p1 = new Pessoa("Gian", 31704913);
    Tecnico t1 = new Tecnico("Rodrigo", 11111111);
    ClienteEmpresa ce1 = new ClienteEmpresa(123, emp, 1351848, p1.getNome(), p1.getTelefone());
    Chamado ch = new Chamado(ce1.getCodigo(), "Problema", "Problema tecnicos na internet", 5, t1, ce1, "WINDOWS", "VISTA", "AAA", "192.168.2.1");

    @Test
    public void cadastrarChamadoTest() {
        assertEquals("Problema", ch.getTitulo());
        assertEquals("Problema tecnicos na internet", ch.getDescricao());
        assertEquals(5, ch.getPrioridade());
        assertEquals("WINDOWS", ch.getSistemaOperacional());
        assertEquals("VISTA", ch.getVersaoSO());
        assertEquals("AAA", ch.getTipoConexao());
        assertEquals("192.168.2.1", ch.getEnderecoRede());

    }

    @Test
    public void editarChamadoTest() {
        Empresa emp2 = new Empresa(2, "FCI");
        Pessoa p2 = new Pessoa("Piero", 43569892);
        Tecnico t2 = new Tecnico("Folco", 47581525);
        ClienteEmpresa ce2 = new ClienteEmpresa(321, emp2, 1234567, p2.getNome(), p2.getTelefone());
        Chamado ch2 = new Chamado(ce2.getCodigo(), "Problema", "Problema tecnicos na internet", 5, t2, ce2, "WINDOWS", "VISTA", "AAA", "192.168.2.1");

        ch2.setTitulo("Solução");
        ch2.setDescricao("Problema nos cabos de comunicação");
        ch2.setPrioridade(1);
        ch2.setSistemaOperacional("MACOS");
        ch2.setVersaoSO("10");
        ch2.setTipoConexao("Radio");
        ch2.setEnderecoRede("192.456.3.2");
        assertNotSame("Problema", ch2.getTitulo());
        assertNotSame("Problema tecnicos na internet", ch2.getDescricao());
        assertNotSame(5, ch2.getPrioridade());
        assertNotSame("WINDOWS", ch2.getSistemaOperacional());
        assertNotSame("VISTA", ch2.getVersaoSO());
        assertNotSame("AAA", ch2.getTipoConexao());
        assertNotSame("192.168.2.1", ch2.getTipoConexao());

    }

    @Test(expected = Exception.class)
    public void verificarDadosInvalidosTest() throws Exception {
         Chamado chamadoInvalido = new Chamado(ce1.getCodigo(), "XXXX", "Erro", -5, null, ce1, null, "0", "NULO", null);

    }

}
