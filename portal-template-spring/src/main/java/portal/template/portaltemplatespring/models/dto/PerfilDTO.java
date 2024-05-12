package portal.template.portaltemplatespring.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDTO {
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorio")
    private String apellidos;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotBlank(message = "El color primario es obligatorio")
    private String colorWeb1;

    @NotBlank(message = "El color secundario es obligatorio")
    private String colorWeb2;

}
