/*
 * To change this license header, choose License Headers in Project Properties.
 * To chan[
ge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadeTest;

import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Folco
 */
public class TecnicoTest {
    
    /*Testes de Inicialização*/
    @Test
    public void criarTecnico(){
        Tecnico p = new Tecnico("Rodrigo", 99940129);
        assertEquals(p.getNome(), "Rodrigo");
        assertEquals(p.getTelefone(), 99940129);
    }
    
    @Test (expected = Exception.class)
    public void criarNomeNullTest() throws Exception{
        Tecnico p = new Tecnico(null, 99940129);
    }
    
    @Test (expected = Exception.class)
    public void criarTelInvalidoTest() throws Exception{
        Tecnico p = new Tecnico("Rodrigo", -99940129);
    }
    
    /*Testes de Alteração*/
    @Test
    public void alterarNome(){
        Tecnico p = new Tecnico("Rodrigo", 999401292);
        p.setNome("Gian");
        assertEquals(p.getNome(), "Gian");
    }
    
    @Test
    public void alterarTelefone(){
        Tecnico p = new Tecnico("Rodrigo", 99940129);
        p.setTelefone(87654321);
        assertEquals(p.getTelefone(), 87654321);
    }
    
    /*Teste de Alteração Invalida*/
    @Test (expected = Exception.class)
    public void alterarNomeNullTest() throws Exception{
        Tecnico p = new Tecnico("Rodrigo", 99940129);
        p.setNome(null);
    }
    
    @Test (expected = Exception.class)
    public void alterarTelefoneInvalidoTest() throws Exception{
        Tecnico p = new Tecnico("Rodrigo", 99940129);
        p.setTelefone(-99940129);
        
    }
    
}