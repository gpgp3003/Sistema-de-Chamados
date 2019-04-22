/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadeTest;

import entidade.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Folco
 */
public class PessoaTest {

    @Test
    public void criarPessoa() {
        Pessoa p = new Pessoa("Rodrigo", 99940129);
        assertEquals(p.getNome(), "Rodrigo");
        assertEquals(p.getTelefone(), 99940129);
    }

    @Test(expected = Exception.class)
    public void criarNomeNull() throws Exception {
        Pessoa p = new Pessoa(null, 99940129);
    }

    @Test(expected = Exception.class)
    public void criarTelInvalido() throws Exception {
        Pessoa p = new Pessoa(null, -99940129);
    }

    /*Testes de Alteração*/
    @Test
    public void alterarNome() {
        Pessoa p = new Pessoa("Rodrigo", 99940129);
        p.setNome("Gian");
        assertEquals(p.getNome(), "Gian");
    }

    @Test
    public void alterarTelefone() {
        Pessoa p = new Pessoa("Rodrigo", 99940129);
        p.setTelefone(99940122);
        assertEquals(p.getTelefone(), 99940122);
    }

    /*Teste de Alteração Invalida*/
    @Test (expected = Exception.class)
    public void alterarNomeNullTest() throws Exception{
        Pessoa p = new Pessoa("Rodrigo", 99940122);
        p.setNome(null);
    }

    @Test (expected = Exception.class)
    public void alterarTelefoneInvalidoTest() throws Exception{
        Pessoa p = new Pessoa("Rodrigo", 99940122);
        p.setTelefone(-99940122);
    }

}