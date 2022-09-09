package Integrador.Interfaces;

import java.util.List;
import java.util.Optional;

/**
* Dao generico
*/
public interface IDao<T> {

	/**
	* Obtiene un registro de un modelo de la base de datos
	* @param id Id del modelo
	* @return Modelo en caso de existir, nulo en caso que no exista
	*/
    Optional<T> get(int id);

    /**
	* Obtiene todos los registros de un modelo de la base de datos
	* @return Lista de registros del modelo
	*/
    List<T> getAll();

    /**
	* Guarda un modelo en la base de datos
	* @param t Modelo a guardar
	*/
    void save(T t);

    /**
	* Actualiza un modelo en la base de datos
	* @param t Modelo a actualizar
	*/
    void update(T t);

    /**
	* Borra un modelo en la base de datos
	* @param t Modelo a borrar
	*/
    void delete(T t);

    /**
	* Crea la tabla correspondiente en la base de datos
	*/
    void createTable();
}
