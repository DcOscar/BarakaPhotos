/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class GestionadorClubTest {
    

    @Test
    public void comprobarPosibilidadOrden() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {1, 2, 3, 4};
        double[] grupoAzul = {2, 3, 4, 5};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        String resultado = gestionador.ordenarBoxeadoras();
        String esperado = "Yes";
        assertEquals(resultado, esperado);
        System.out.println(resultado);
    }

    @Test
    public void comprobarPosibilidadOrden2() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {1, 5, 4};
        double[] grupoAzul = {2, 3, 4};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        String resultado = gestionador.ordenarBoxeadoras();
        String esperado = "No";
        assertEquals(resultado, esperado);
        System.out.println(resultado);
    }

    @Test
    public void comprobarPosibilidadOrden3() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {1.68, 1.79, 1.87, 1.63, 1.73, 1.92};
        double[] grupoAzul = {1.89, 1.67, 1.80, 1.81, 1.77, 1.94};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        String resultado = gestionador.ordenarBoxeadoras();
        String esperado = "Yes";
        assertEquals(resultado, esperado);
        System.out.println(resultado);
    }

    @Test
    public void comprobarPosibilidadOrden4() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {1.78, 1.63, 1.84};
        double[] grupoAzul = {1.67, 1.58, 1.82};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        String resultado = gestionador.ordenarBoxeadoras();
        String esperado = "No";
        assertEquals(resultado, esperado);
        System.out.println(resultado);
    }

    @Test
    public void comprobarCasoAlturaInvalida() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {0, 0, 0, 0};
        double[] grupoAzul = {0, 0, 0, 0};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        boolean condicion = false;
        if (gestionador.getGrupoAzul().isEmpty() && gestionador.getGrupoDorado().isEmpty()) {
            condicion = true;

        }
        assertTrue(condicion);
    }

    @Test
    public void comprobarCasoAlturasNoEquitativas() {
        GestionadorClub gestionador = new GestionadorClub();
        double[] grupoDorado = {1.25, 1.32, 0, 0};
        double[] grupoAzul = {1.90, 0, 0, 0};
        for (int i = 0; i < grupoDorado.length; i++) {
            gestionador.agregarBoxeadoraGrupoDorado(grupoDorado[i]);
            gestionador.agregarBoxeadoraGrupoAzul(grupoAzul[i]);
        }
        String esperado = "No";
        String resultado = gestionador.ordenarBoxeadoras();
        assertEquals(esperado, resultado);

    }
    
}
