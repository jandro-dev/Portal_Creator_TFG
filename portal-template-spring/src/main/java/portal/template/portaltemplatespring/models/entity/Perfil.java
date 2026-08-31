package portal.template.portaltemplatespring.models.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String nombre;

    @NonNull
    private String apellidos;

    @NonNull
    private String descripcion;

    @NonNull
    private String colorWeb1;

    @NonNull
    private String colorWeb2;

    @OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();
}