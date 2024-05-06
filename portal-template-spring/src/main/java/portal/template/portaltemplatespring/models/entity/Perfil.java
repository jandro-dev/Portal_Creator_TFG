package portal.template.portaltemplatespring.models.entity;

import jakarta.persistence.Entity;

@Entity
public class Perfil {
    
    // Atributos

    private String nombre;
    private String apellidos;
    private String colorWeb1;
    private String colorWeb2;

    // Constructores
    
    public Perfil() {}

    public Perfil(String _nombre, String _apellidos, String _colorWeb1, String _colorWeb2) {
        this.nombre = _nombre;
        this.apellidos = _apellidos;
        this.colorWeb1 = _colorWeb1;
        this.colorWeb2 = _colorWeb2;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getColorWeb1() {
        return colorWeb1;
    }

    public void setColorWeb1(String colorWeb1) {
        this.colorWeb1 = colorWeb1;
    }

    public String getColorWeb2() {
        return colorWeb2;
    }

    public void setColorWeb2(String colorWeb2) {
        this.colorWeb2 = colorWeb2;
    }

}