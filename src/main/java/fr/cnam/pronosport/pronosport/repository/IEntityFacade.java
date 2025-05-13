package fr.cnam.pronosport.pronosport.repository;

/*

Le design pattern Facade est conçu pour éviter que la logique métier des classes soit trop dépendante des détails d’implémentation de classes tierces  (dans notre cas Hibernate)  ou de sous-systèmes complexes.
 En introduisant une façade, on fournis une interface simplifiée et unifiée : le client (la logique métier) n’interagit qu’avec la façade, et non directement avec les classes internes du sous-système
*/

import java.util.List;

public interface IEntityFacade <T>{T add(T entity) throws Exception;
    T get(Class<T> entity, Integer id)throws Exception;

    List<T> getAll(Class<T> entityClass) throws Exception;
    void update(T entity)throws Exception;
    void remove(T entity)throws Exception;


}
