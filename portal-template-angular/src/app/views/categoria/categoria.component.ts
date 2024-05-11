import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from '../../models/categoria.interface';
import { Observable } from 'rxjs';

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

  ngOnInit(): void {
    const cid = this.route.snapshot.paramMap.get('cid');

    if (cid) {
      this.categoriaService.getCategoria(parseInt(cid)).subscribe((categoria) => {
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
    if (this.form?.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const categoriaForm = this.form!.value;
    let request: Observable<Categoria>;

    if (this.categoria) {
      request = this.categoriaService.updateCategoria(this.categoria.id, categoriaForm);
    } else {
      request = this.categoriaService.createCategoria(categoriaForm);
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
