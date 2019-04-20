/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControleEmpresas;
import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author rodri
 */
public class ControleEmpresasTest {
    
    @Test
    public void retornaTest(){
     ControleEmpresas ce = new ControleEmpresas();
     Empresa empresa = new Empresa(2,"EMPTest");
     
     Empresa e = ce.retorna(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
     assertEquals(empresa.getNomeEmpresa(), e.getNomeEmpresa());
     assertEquals(empresa.getNumeroContrato(),e.getNumeroContrato());
    }
    
    @Test (expected = Exception.class)
    public void nmrInvalidoNoretornaTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(-123, "EMPTest2");
    }
    
    @Test (expected = Exception.class)
    public void nomeNullNoretornaTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(123, null);
    }
    
    @Test
    public void retornaNullTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(123, "empty");
        assertNull(e);
    }
    
    @Test
    public void inserirEmpresaInexistenteTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(2,"EMPTest");
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        
        assertNotNull(e);
        assertSame(empresa.getNumeroContrato(), e.getNumeroContrato());
        assertEquals(empresa.getNomeEmpresa(),e.getNomeEmpresa());
        
    }
    
    @Test
    public void inserirEmpresaExistenteTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(2,"EMPTest");
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa e2 = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        
        assertNull(e2); /*Como uma empresa de mesmo nome e nºcontrato (e) foi inserida anteriormente,
                          o retorno do método inserir deve ser nulo, caso não seja, o teste falhará.
                         */
    }
    
    @Test
    public void validarContratoeNomeExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(200, "upm");
        int valida = ce.validar(200, "upm");
        assertEquals(1,valida);  
    }
    
    @Test
    public void validarNomeExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(200, "upm");
        int valida = ce.validar(967, "upm");
        assertEquals(2,valida);  
    }
    
    @Test
    public void validarContratoExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(200, "upm");
        int valida = ce.validar(200, "puc");
        assertEquals(3,valida);  
    }
    
    @Test
    public void validarNenhumAtributoExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(200, "upm");
        int valida = ce.validar(967, "puc");
        assertEquals(4,valida);  
    }
    
    @Test (expected = Exception.class)
    public void contratoInvalidoNoValidarTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        int valida = ce.validar(-891, "insper");
    }
    
    @Test (expected = Exception.class)
    public void empresaInvalidoNoValidarTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        int valida = ce.validar(-891, "insper");
    }
    
}