package SOLOTEAMBE.seguridad.Repositorios;

import SOLOTEAMBE.seguridad.Modelos.Permiso;
import org.springframework.data.mongodb.repository.Query;
import SOLOTEAMBE.seguridad.Modelos.PermisoRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermisosRoles extends MongoRepository<PermisoRol, String> {
    @Query("{'rol.$id': ObjectId(?0), 'permiso.$id': ObjectId(?1)}")
    PermisoRol getPermisoRol(String id_rol, String id_permiso);
}
