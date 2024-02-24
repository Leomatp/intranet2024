import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { IntranetComponent } from './intranet/intranet.component';
import { SistemaRoutingModule } from './sitema.routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { NgxPaginationModule} from 'ngx-pagination';

//import { FormLibroComponent } from './pages/libro/form-libro/form-libro.component';
//import { ModalModule } from 'ngx-bootstrap/modal';
import { AlumnoComponent } from './pages/alumno/alumno.component';
import { NuevoAlumnoComponent } from './pages/alumno/nuevo-alumno/nuevo-alumno.component';
import { CursoComponent } from './pages/curso/curso.component';
import { NuevoCursoComponent } from './pages/curso/nuevo-curso/nuevo-curso.component';
import { SedeComponent } from './pages/sede/sede.component';
import { NuevaSedeComponent } from './pages/sede/nueva-sede/nueva-sede.component';
import { TareaComponent } from './pages/tarea/tarea.component';
import { ProfesorComponent } from './pages/profesor/profesor.component';
import { NuevoProfesorComponent } from './pages/profesor/nuevo-profesor/nuevo-profesor.component';

@NgModule({
  declarations: [
    LayoutComponent,
    IntranetComponent,
    AlumnoComponent,
    NuevoAlumnoComponent,
    CursoComponent,
    NuevoCursoComponent,
    SedeComponent,
    NuevaSedeComponent,
    TareaComponent,
    ProfesorComponent,
    NuevoProfesorComponent
    //FormLibroComponent
  ],
  imports: [
    CommonModule,
    SistemaRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    //ModalModule.forRoot()
  ]
})
export class SistemaModule { }
