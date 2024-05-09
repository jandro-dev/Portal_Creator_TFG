package portal.template.portaltemplatespring.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

}
