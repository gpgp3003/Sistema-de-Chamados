/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaTest;

import Persistencia.ChamadoDAO;
import Persistencia.ChamadoDAO;
import entidade.BancoDeDados;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.SistemaOperacional;
import entidade.Tecnico;
import entidade.TipoConexao;
import entidade.TipoProblema;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Gian Pestana
 */
public class ChamadoDAOTest {

    Empresa empresa = new Empresa(1, "Mackenzie");
    ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Gian", 85748574);
    Tecnico tecnico = new Tecnico("Rodrigo", 46612321);
    Chamado chamado = new Chamado("titulo", "descrição", 3, tecnico, clienteEmpresa, "" + SistemaOperacional.LINUX, "Ubuntu", "operação", 10);
    RegistroChamado registro = new RegistroChamado("Defeitos na rede", chamado, tecnico);
    ChamadoDAO chamadodao = new ChamadoDAO();

    @Test
    public void inserirChamadoTest() {
        chamadodao.put(chamado);
        Chamado chamadoInserido = chamadodao.get(chamadodao.gerarCodigo() - 1);
        Assert.assertTrue((chamado.getTitulo().equals(chamadoInserido.getTitulo())) && (chamado.getDescricao().equals(chamadoInserido.getDescricao())) && (chamado.getPrioridade() == chamadoInserido.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamadoInserido.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamadoInserido.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamadoInserido.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamadoInserido.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamadoInserido.getVersaoSO())) && (chamado.getTipoConexao().equals(chamadoInserido.getTipoConexao())) && (chamado.getEnderecoRede().equals(chamadoInserido.getEnderecoRede())));
    }

    @Test
    public void inserirRegistroChamadoTest() {
        chamadodao.putRegistro(registro);
        Collection<RegistroChamado> registros = chamadodao.getRegistros();
        RegistroChamado inserido = null;
        for (RegistroChamado registro1 : registros) {
            if (registro1.getAssunto().equals(registro.getAssunto())) {
                if ((registro.getTecnico().getTelefone() == registro1.getTecnico().getTelefone()) && (registro.getTecnico().getNome().equals(registro1.getTecnico().getNome()))) {
                    if ((registro.getChamado().getTitulo().equals(registro1.getChamado().getTitulo())) && (registro.getChamado().getDescricao().equals(registro1.getChamado().getDescricao())) && (registro1.getChamado().getPrioridade() == registro.getChamado().getPrioridade()) && ((registro.getChamado().getTecnico().getNome().equals(registro1.getTecnico().getNome())) && (registro.getChamado().getTecnico().getTelefone() == registro1.getChamado().getTecnico().getTelefone())) && (registro.getChamado().getCliente().getCpf() == registro1.getChamado().getCliente().getCpf()) && (registro.getChamado().getSistemaOperacional().equals(registro1.getChamado().getSistemaOperacional())) && (registro.getChamado().getVersaoSO().equals(registro1.getChamado().getVersaoSO())) && (registro.getChamado().getBancoDeDados().equals(registro1.getChamado().getBancoDeDados())));
                    inserido = registro1;
                }
            }
        }
        Assert.assertNotNull(inserido);
    }

    @Test
    public void gerarCodigoTest() {
        Assert.assertEquals(chamadodao.getChamados().size(), chamadodao.gerarCodigo() - 1);
    }

    @Test
    public void gerarCodigoRegistroTest() {
        Assert.assertEquals(chamadodao.getRegistros().size(), chamadodao.gerarCodigoRegistroChamado() - 1);

    }

    public void leituraRegistrosChamadosTest() {
        chamadodao.putRegistro(registro);
        Assert.assertTrue(chamadodao.getRegistros().size() > 0);
    }

    public void leituraChamadosTest() {
        chamadodao.put(chamado);
        Assert.assertTrue(chamadodao.getChamados().size() > 0);
    }
}
