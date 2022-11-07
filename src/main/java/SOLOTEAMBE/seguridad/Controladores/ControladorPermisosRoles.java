package SOLOTEAMBE.seguridad.Controladores;

import SOLOTEAMBE.seguridad.Modelos.Permiso;
import SOLOTEAMBE.seguridad.Modelos.PermisoRol;
import SOLOTEAMBE.seguridad.Modelos.Rol;
import SOLOTEAMBE.seguridad.Repositorios.RepositorioPermiso;
import SOLOTEAMBE.seguridad.Repositorios.RepositorioPermisosRoles;
import SOLOTEAMBE.seguridad.Repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")
public class ControladorPermisosRoles {
    @Autowired
    private RepositorioPermisosRoles miRepositorioPermisosRoles;
    @Autowired
    private RepositorioPermiso miRepositorioPermiso;
    @Autowired
    private RepositorioRol miRepositorioRol;

    @GetMapping("")
    public List<PermisoRol> index(){
        return this.miRepositorioPermisosRoles.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public PermisoRol create(@PathVariable String id_rol, @PathVariable String id_permiso){
        PermisoRol nuevo = new PermisoRol();
        Rol elRol = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso elPermiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if(elRol != null && elPermiso != null){
            nuevo.setMiPermiso(elPermiso);
            nuevo.setMiRol(elRol);
            return this.miRepositorioPermisosRoles.save(nuevo);
        }
        return null;
    }

    @GetMapping("{id}")
    public PermisoRol show(@PathVariable String id){
        PermisoRol miPermisoRol = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        return miPermisoRol;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        PermisoRol miPermisoRol = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        if(miPermisoRol != null){
            this.miRepositorioPermisosRoles.delete(miPermisoRol);
        }
    }

    @PutMapping("{id}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisoRol update(@PathVariable String id, @PathVariable String id_rol, @PathVariable String id_permiso){
        PermisoRol miPermisoRol = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        Rol rolActual = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso miPermiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if(miPermisoRol != null && rolActual != null && miPermiso != null ){
            miPermisoRol.setMiPermiso(miPermiso);
            miPermisoRol.setMiRol(rolActual);
            return this.miRepositorioPermisosRoles.save(miPermisoRol);
        }else{
            return null;
        }
    }
}
