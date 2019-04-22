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
import entidade.RegistroChamado;
import entidade.RegistroChamado;
import entidade.Tecnico;
import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gian Pestana
 */
public class RegistroChamadoTest {
    Empresa emp = new Empresa(1000, "Mackenzie");
    Pessoa pessoa = new Pessoa("Gian", 12345678);
    Tecnico tec = new Tecnico("Rodrigo", 87654321);
    ClienteEmpresa cliEmp = new ClienteEmpresa(123, emp, 1351848, pessoa.getNome(), pessoa.getTelefone());
    Chamado chamado = new Chamado(cliEmp.getCodigo(), "Problema", "Problema tecnicos na internet", 5, tec, cliEmp, "WINDOWS", "VISTA", "AAA", "100.100.1.1");

    @Test
    public void CadastroRegistroChamadoTest() {
        RegistroChamado rc = new RegistroChamado("Defeitos na rede", chamado, tec);
        assertEquals("Defeitos na rede", rc.getAssunto());
    }

    @Test
    public void editarRegistroChamadoTest() {
        RegistroChamado rc = new RegistroChamado("Defeitos na rede", chamado, tec);
        rc.setAssunto("Assunto alterado");
        assertNotSame("Defeitos na rede",rc.getAssunto());
    }
    
    
    @Test(expected = Exception.class)
    public void verificarDadoNullTest() throws Exception{
        RegistroChamado rc = new RegistroChamado(null, chamado, tec);
    }
    
}
