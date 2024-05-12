import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { PerfilService } from '../../services/perfil.service';
import { Perfil } from '../../models/perfil.interface';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
})
export default class PerfilComponent implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private perfilService = inject(PerfilService);

  form?: FormGroup;
  perfil?: Perfil;
  errors: string[] = [];

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.perfilService.getPerfil(parseInt(id)).subscribe((perfil) => {
        this.perfil = perfil;
        this.form = this.fb.group({
          nombre: [perfil.nombre, [Validators.required]],
          apellidos: [perfil.apellidos, [Validators.required]],
          descripcion: [perfil.descripcion, [Validators.required]],
          colorWeb1: [perfil.colorWeb1,
            [
              Validators.required,
              Validators.pattern('#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})'),
            ],
          ],
          colorWeb2: [perfil.colorWeb2,
            [
              Validators.required,
              Validators.pattern('#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})'),
            ],
          ],
        });
      });
    } else {
      this.form = this.fb.group({
        nombre: ['', [Validators.required]],
        apellidos: ['', [Validators.required]],
        descripcion: ['', [Validators.required]],
        colorWeb1: [
          '',
          [
            Validators.required,
            Validators.pattern('#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})'),
          ],
        ],
        colorWeb2: [
          '',
          [
            Validators.required,
            Validators.pattern('#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})'),
          ],
        ],
      });
    }
  }

  save() {
    if (this.form?.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const perfilForm = this.form!.value;
    let request: Observable<Perfil>;

    if (this.perfil) {
      request = this.perfilService.updatePerfil(this.perfil.id, perfilForm);
    } else {
      request = this.perfilService.createPerfil(perfilForm);
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
