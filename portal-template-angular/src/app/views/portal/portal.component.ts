import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { PortalService } from '../../services/portal.service';
import { Portal } from '../../models/portal.interface';
import { Observable } from 'rxjs';
import { Perfil } from '../../models/perfil.interface';

@Component({
  selector: 'app-portal',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './portal.component.html',
  styleUrl: './portal.component.css',
})

export default class PortalComponent implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private portalService = inject(PortalService);

  form?: FormGroup;
  portal?: Portal;
  errors: string[] = [];
	//
	perfilId?: number

  ngOnInit(): void {
		const idGuardado = localStorage.getItem('perfilId');

		if (!idGuardado) {
   	 	return;
  	}

		this.perfilId = parseInt(idGuardado);
    const cid = this.route.snapshot.paramMap.get('cid'); // Id categoria del path de rutas
    const pid = this.route.snapshot.paramMap.get('pid'); // Id portal del path de rutas

    if (cid && pid) {
      this.portalService
        .getPortal(this.perfilId, parseInt(cid), parseInt(pid))
        .subscribe((portal) => {
          this.portal = portal;
          this.form = this.fb.group({
            nombre: [portal.nombre, [Validators.required]],
            descripcion: [portal.descripcion, [Validators.required]],
            link: [portal.link,[
                Validators.required,
                Validators.pattern('(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]')
              ]],
          });
        });
    } else {
      this.form = this.fb.group({
        nombre: ['', [Validators.required]],
        descripcion: ['', [Validators.required]],
        link: ['',[
            Validators.required,
            Validators.pattern('(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]')
          ]]
      });
    }
  }

  save() {
    const categoriaID = this.route.snapshot.paramMap.get('cid');
    if (categoriaID) {
      this.savePortal(parseInt(categoriaID));
    }
  }

  savePortal(categoriaID: number) {
    if (this.form?.invalid || !this.perfilId) {
      this.form?.markAllAsTouched();
      return;
    }

    const portalForm = this.form!.value;
    let request: Observable<Portal>;

    if (this.portal) {
      request = this.portalService.updatePortal(
				this.perfilId,
        categoriaID,
        this.portal.id,
        portalForm
      );
    } else {
      request = this.portalService.createPortal(this.perfilId, categoriaID, portalForm);
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
