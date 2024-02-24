import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IntranetComponent } from './intranet/intranet.component';
//import { FormEmpleadoComponent } from './pages/empleado/form-empleado/form-empleado.component';
//import { FormLibroComponent } from './pages/libro/form-libro/form-libro.component';
import { AlumnoComponent } from './pages/alumno/alumno.component';
import { NuevoAlumnoComponent } from './pages/alumno/nuevo-alumno/nuevo-alumno.component';
import { SedeComponent } from './pages/sede/sede.component';
import { NuevaSedeComponent } from './pages/sede/nueva-sede/nueva-sede.component';
import { ProfesorComponent } from './pages/profesor/profesor.component';
import { NuevoProfesorComponent } from './pages/profesor/nuevo-profesor/nuevo-profesor.component';
import { CursoComponent } from './pages/curso/curso.component';
import { NuevoCursoComponent } from './pages/curso/nuevo-curso/nuevo-curso.component';
import { TareaComponent } from './pages/tarea/tarea.component';


const routes: Routes = [
  {
    path:'',
    component:IntranetComponent,
    children:[
      {
        path:'alumno',
        component: AlumnoComponent
      },
      {
        path:'alumno/nuevo',
        component:NuevoAlumnoComponent
      },
      {
        path:'sede',
        component: SedeComponent
      },
      {
        path:'sede/nueva',
        component:NuevaSedeComponent
      },
      {
        path:'profesor',
        component:ProfesorComponent
      },
      {
        path:'profesor/nuevo',
        component:NuevoProfesorComponent
      },
      {
        path:'curso',
        component:CursoComponent
      },
      {
        path:'curso/nuevo',
        component:NuevoCursoComponent
      },
      {
        path:'tarea',
        component:TareaComponent
      },
      /*{
        path:'libro/nuevo',
        component: FormLibroComponent
      },
      {
        path:'libro/editar/:id',
        component: FormLibroComponent
      }*/
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SistemaRoutingModule { }
