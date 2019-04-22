/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControleChamados;
import entidade.BancoDeDados;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.SistemaOperacional;
import entidade.Status;
import entidade.Tecnico;
import entidade.TipoConexao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gian Pestana
 */
public class ControleChamadosTest {
    
    @Test
    public void alterarChamadoTest(){
        ControleChamados cc = new ControleChamados();
        
        Empresa empresa = new Empresa(1,"Mackenzie");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
        
        Tecnico tecnico = new Tecnico("Rodrigo",46612321);
        //Novo chamado de Desempenho
        Chamado chamado = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10);
        
        Chamado c = cc.InserirChamadoDesempenho(chamado.getTitulo(), chamado.getDescricao(), chamado.getPrioridade(), chamado.getTecnico(), chamado.getCliente(), chamado.getSistemaOperacional(), chamado.getVersaoSO(), chamado.getOperacao(), chamado.getDuracaoOperacao());
        cc.alterarChamado(c, ""+Status.em_atendimento, "O HD está quase cheio", "Realizar limpeza de Disco");
        assertEquals(c.getCausaProblema(), "O HD está quase cheio");
        assertEquals(c.getSolucaoProblema(), "Realizar limpeza de Disco");
        assertEquals(c.getStatus(), "em_atendimento"); 
    }
    
    
    @Test
    public void inserirChamadoTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Rodrigo",46612321);
        Empresa empresa = new Empresa(1,"Mackenzie");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
        Chamado cr = new Chamado(123,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        
        Chamado cr2 = cc.InserirChamadoRede(cr.getTitulo(), cr.getDescricao(), cr.getPrioridade(), cr.getTecnico(), cr.getCliente(), cr.getSistemaOperacional(), cr.getVersaoSO(), cr.getTipoConexao(), cr.getEnderecoRede());
        Chamado c = cc.buscaPeloCodigo(cr2.getCodigo());
        assertTrue(cr.getTitulo().equals(c.getTitulo()));
        assertTrue(cr.getDescricao().equals(c.getDescricao()));
        assertSame(cr.getPrioridade(), c.getPrioridade());
        assertEquals(cr.getTecnico(),c.getTecnico());
        assertEquals(cr.getCliente(),c.getCliente());
        assertEquals(cr.getSistemaOperacional(),c.getSistemaOperacional());
        assertEquals(cr.getVersaoSO(),c.getVersaoSO());
        assertEquals(cr.getTipoConexao(),c.getTipoConexao());
        assertEquals(cr.getEnderecoRede(),c.getEnderecoRede());
    }
    
    @Test
    public void inserirChamadoBancodeDadosTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Rodrigo",46612321);
        Empresa empresa = new Empresa(1,"Mackenzie");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
        Chamado cbd = new Chamado("Usuário não encontrado","O referido usuário não está registrado no banco de dados",2,tecnico,clienteEmpresa,""+SistemaOperacional.WINDOWS,"XP",""+BancoDeDados.Oracle);
        
        Chamado cbd2 = cc.InserirChamadoBancoDeDados(cbd.getTitulo(), cbd.getDescricao(), cbd.getPrioridade(), cbd.getTecnico(), cbd.getCliente(), cbd.getSistemaOperacional(), cbd.getVersaoSO(), cbd.getBancoDeDados());
        Chamado c = cc.buscaPeloCodigo(cbd2.getCodigo());
        assertTrue(cbd.getTitulo().equals(c.getTitulo()));
        assertTrue(cbd.getDescricao().equals(c.getDescricao()));
        assertSame(cbd.getPrioridade(), c.getPrioridade());
        assertEquals(cbd.getTecnico(),c.getTecnico());
        assertEquals(cbd.getCliente(),c.getCliente());
        assertEquals(cbd.getSistemaOperacional(),c.getSistemaOperacional());
        assertEquals(cbd.getVersaoSO(),c.getVersaoSO());
        assertEquals(cbd.getBancoDeDados(),c.getBancoDeDados());   
    }
    
    @Test
    public void inserirRegistroTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Rodrigo",46612321);
        Empresa empresa = new Empresa(1,"Mackenzie");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
        Chamado chamado = new Chamado("Lentidão ao navegar","O SO está muito lento e travando muito",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10);
        
        RegistroChamado r = new RegistroChamado("Problema com Servidor", chamado, tecnico);
        RegistroChamado r2 = cc.inserirRegistroChamado(r.getAssunto(), r.getChamado(), r.getTecnico());
        
        assertEquals(r.getAssunto(),r2.getAssunto());
        assertTrue(r.getChamado().equals(r2.getChamado()));
        assertTrue(r.getTecnico().equals(r2.getTecnico()));
    }
    
    @Test
    public void obterDetalhesChamado(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Rodrigo",46612321);
        Empresa empresa = new Empresa(1,"Mackenzie");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
        Chamado c = new Chamado("AAA","BBB",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10);
        
        
        String detalhes = "\n" + "--------" + "\n" + "Data de abertura do chamado: "
                + c.getData() + "\n" + "Hororio de abertura do chamado: " + c.getHora() + "\n"
                + "Titulo do chamado: " + "AAA" + "\n" + "Descricao do chamado: " + "BBB" + "\n"
                + "Prioridade do chamado" + 3 + "\n" + "Status do chamado: " + "Iniciado" + "\n"
                + "Tipo de problema do chamado: " + "Problema de Desempenho" + "\n" + "Tecnico responsovel pelo chamado: "
                + "Rodrigo" + "\n" + "Cliente requisitor do chamado: " + "Gian" + "\n";
        
        assertEquals(cc.retornaDetalhesChamado(c),detalhes);
    }
    
}
