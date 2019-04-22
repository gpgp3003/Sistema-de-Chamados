/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControladorPrincipal;
import controle.ControladorPrincipal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gian Pestana
 */
public class ControladorPrincipalTest {
    
    public ControladorPrincipalTest() {
    }
    
    @Test
    public void iniciarControladoresTest(){
        ControladorPrincipal contrl = new ControladorPrincipal();
        assertNotNull(contrl.getCtrChamados());
        assertNotNull(contrl.getCtrTecnicos());
        assertNotNull(contrl.getCtrClientes());
        assertNotNull(contrl.getCtrEmpresa());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    }
}
