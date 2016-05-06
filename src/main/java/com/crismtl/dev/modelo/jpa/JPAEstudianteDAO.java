package com.crismtl.dev.modelo.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.crismtl.dev.modelo.dao.EstudianteDAO;
import com.crismtl.dev.modelo.entidad.Estudiante;
import com.crismtl.dev.modelo.jpa.generico.JPAGenericoDAO;

@Stateless
public class JPAEstudianteDAO extends JPAGenericoDAO<Estudiante, Integer>
		implements EstudianteDAO {
}
