/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadeTest;

import org.junit.Test;
import static org.junit.Assert.*;
import entidade.Empresa;

/**
 *
 * @author Rodrigo Folco
 */
public class EmpresaTest {
    
    /*Testes de Inicialização*/
    @Test
    public void criarEmpresaTest(){
        Empresa e = new Empresa(33456, "UPM");
        assertEquals(e.getNomeEmpresa(), "UPM");
        assertEquals(e.getNumeroContrato(), 33456);
    }
    
    @Test (expected = Exception.class)
    public void criarNumeroContratoInvalidoTest()throws Exception{
        Empresa e = new Empresa(-33456, "UPM");
    }
    
    @Test (expected = Exception.class)
    public void criarNomeEmpresaNullTest()throws Exception{
        Empresa e = new Empresa(33456, null);
    }
    
    /*Testes de Alteração*/
    @Test
    public void alterarNumeroContratoTest(){
        Empresa e = new Empresa(33456, "UPM");
        e.setNumeroContrato(33456);
        assertEquals(e.getNumeroContrato(), 33456);
    }
    
    @Test
    public void alterarNomeEmpresaTest(){
        Empresa e = new Empresa(33456, "UPM");
        e.setNomeEmpresa("UPM-FCI");
        assertEquals(e.getNomeEmpresa(), "UPM-FCI");
    }
    
    
    /*Testes de Alteração para valores inválidos*/
    @Test (expected = Exception.class)
    public void alterarNumeroContratoInvalidoTest()throws Exception{
        Empresa e = new Empresa(33456, "UPM");
        e.setNumeroContrato(-332);
    }
    
    @Test (expected = Exception.class)
    public void alterarNomeEmpresaInvalidoTest()throws Exception{
        Empresa e = new Empresa(33456, "UPM");
        e.setNomeEmpresa(null);
    }
}