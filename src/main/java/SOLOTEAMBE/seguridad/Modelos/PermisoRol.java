package SOLOTEAMBE.seguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PermisoRol {
    @Id
    private String _id;
    @DBRef
    private Permiso miPermiso;
    @DBRef
    private Rol miRol;

    public PermisoRol(){}

    public String get_id() {
        return _id;
    }

    public Permiso getMiPermiso() {
        return miPermiso;
    }

    public void setMiPermiso(Permiso miPermiso) {
        this.miPermiso = miPermiso;
    }

    public Rol getMiRol() {
        return miRol;
    }

    public void setMiRol(Rol miRol) {
        this.miRol = miRol;
    }
}
