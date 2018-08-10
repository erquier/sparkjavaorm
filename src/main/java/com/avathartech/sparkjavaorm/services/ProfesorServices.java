package com.avathartech.sparkjavaorm.services;

import com.avathartech.sparkjavaorm.entidades.Estudiante;
import com.avathartech.sparkjavaorm.entidades.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by vacax on 04/06/16.
 */
public class ProfesorServices extends GestionDb<Profesor> {

    private static ProfesorServices instancia;

    private ProfesorServices(){
        super(Profesor.class);
    }

    public static ProfesorServices getInstancia(){
        if(instancia==null){
            instancia = new ProfesorServices();
        }
        return instancia;
    }



    /**
     *
     * @param nombre
     * @return
     */
    public List<Profesor> findAllByNombre(String nombre){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Profesor.findAllByNombre");
        query.setParameter("nombre", "%"+nombre+"%");
        List<Profesor> lista = query.getResultList();
        return lista;
    }
}
