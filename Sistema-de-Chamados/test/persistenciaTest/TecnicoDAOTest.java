/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaTest;

import Persistencia.TecnicoDAO;
import entidade.Tecnico;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author rodri
 */
public class TecnicoDAOTest {

    @Test
    public void persistirTecnicoTest() {
        Tecnico tecnico = new Tecnico("Caio", 44516654);
        TecnicoDAO tecnicodao = new TecnicoDAO();
        tecnicodao.put(tecnico);
        Tecnico inserido = tecnicodao.get(tecnicodao.gerarCodigo() - 1);
        assertTrue(((tecnico.getTelefone() == inserido.getTelefone())) && (tecnico.getNome().equals(inserido.getNome())));
    }

    @Test
    public void leituraTest() {
        Tecnico tecnico = new Tecnico("Caio", 44516654);
        TecnicoDAO tecnicodao = new TecnicoDAO();
        Assert.assertTrue(tecnicodao.voltaCashTecnico().size() > 0 );
    }
    
    @Test
    public void gerarCodigoTest(){
        TecnicoDAO tecnicodao = new TecnicoDAO();
        int expected = tecnicodao.voltaCashTecnico().size() + 1;
        assertEquals(expected, tecnicodao.gerarCodigo());
    }

}