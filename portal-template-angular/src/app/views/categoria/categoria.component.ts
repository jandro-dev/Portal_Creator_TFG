import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from '../../models/categoria.interface';
import { Observable } from 'rxjs';
import { Perfil } from '../../models/perfil.interface';

@Component({
  selector: 'app-categoria',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css',
})
export default class CategoriaComponent implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private categoriaService = inject(CategoriaService);

  form?: FormGroup;
  categoria?: Categoria;
  errors: string[] = [];
	//
	perfil?: Perfil

  ngOnInit(): void {
		const idGuardado = localStorage.getItem('perfilId');

		if (!idGuardado) {
   	 	return;
  	}

		const idPerfil = parseInt(idGuardado);
    const cid = this.route.snapshot.paramMap.get('cid');

    if (cid) {
			//
      this.categoriaService.getCategoria(parseInt(cid), idPerfil).subscribe((categoria) => {
        this.categoria = categoria;
        this.form = this.fb.group({
          nombre: [categoria.nombre, [Validators.required]]
        });
      });
    } else {
      this.form = this.fb.group({
        nombre: ['', [Validators.required]]
      });
    }
  }

  save() {
		//
    if (this.form?.invalid || !this.perfil) {
			this.form?.markAllAsTouched();
      return;
    }
		const idPerfil = this.perfil.id

    const categoriaForm = this.form!.value;
    let request: Observable<Categoria>;

    if (this.categoria) {
			//
      request = this.categoriaService.updateCategoria(this.categoria.id, idPerfil, categoriaForm);
    } else {
			//
      request = this.categoriaService.createCategoria(idPerfil, categoriaForm);
    }

    request.subscribe({
      next: () => {
        this.errors = [];
        window.location.href = '/';
      },
      error: (response) => {
        this.errors = response.error.errors;
      },
    });
  }
}
