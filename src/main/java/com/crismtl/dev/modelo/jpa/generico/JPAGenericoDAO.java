package com.crismtl.dev.modelo.jpa.generico;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crismtl.dev.modelo.dao.generico.GenericoDAO;

public abstract class JPAGenericoDAO<T, ID extends Serializable> implements
		GenericoDAO<T, ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Class<T> entity;

	@PersistenceContext(unitName = "ExampleJEE")
	private EntityManager entityManager;

	private final String entityName;

	protected static final String SENTENCIA_SELECT = "SELECT e FROM";

	protected JPAGenericoDAO(final Class<T> entity,
			final EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entity = entity;
		this.entityName = entity.getSimpleName();
	}

	@SuppressWarnings("unchecked")
	public JPAGenericoDAO() {
		final Class<T> aType = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.entity = aType;
		this.entityName = entity.getSimpleName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarATodos() throws Exception {
		List<T> resultado;
		try {
			resultado = this.getEntityManager()
					.createQuery(SENTENCIA_SELECT + this.getEntityName() + "e")
					.getResultList();
			return resultado;
		} catch (Exception ex) {
			throw new Exception(
					"buscarATodos: No se ha podido obtener las entidades: "
							+ getEntityName(), ex);
		}
	}

	@Override
	public T buscarPorId(final ID id) throws Exception {
		try {
			return this.getEntityManager().find(entity, id);
		} catch (Exception ex) {
			throw new Exception(
					"buscarPorId:No se ha podido obtener la entidad '"
							+ getEntityName() + "' con identificador " + id, ex);
		}
	}

	@Override
	public T crear(final T entity) throws Exception {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T actualizar(final T entity) throws Exception {
		return getEntityManager().merge(entity);
	}

	@Override
	public void borrar(T entity) throws Exception {
		T borrado = getEntityManager().merge(entity);
		getEntityManager().remove(borrado);
	}

	public Class<T> getEntity() {
		return entity;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public String getEntityName() {
		return entityName;
	}
}
