package portal.template.portaltemplatespring.models.entity;

import jakarta.persistence.Entity;
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
    
    @NonNull
    private String nombre;

    @NonNull
    private String apellidos;

    @NonNull
    private String colorWeb1;

    @NonNull
    private String colorWeb2;

}