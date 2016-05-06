package com.crismtl.dev.modelo.dao.generico;

import java.io.Serializable;
import java.util.List;

public interface GenericoDAO<T, ID extends Serializable> extends Serializable {
	List<T> buscarATodos() throws Exception;

	T buscarPorId(ID id) throws Exception;

	T crear(T entity) throws Exception;

	T actualizar(T entity) throws Exception;

	void borrar(T entity) throws Exception;
}
