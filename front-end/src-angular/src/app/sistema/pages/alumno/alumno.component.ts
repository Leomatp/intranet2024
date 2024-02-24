import { Component } from '@angular/core';
import { Alumno } from 'src/app/model/Alumno';
import { Tarea } from 'src/app/model/Tarea';
import { AlumnoService } from 'src/app/services/alumno.service';
import { TareaService } from 'src/app/services/tarea.service';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent {
  //crea un listado del objeto tarea
  listaAlumnos:Alumno[]=[]
  
  //llamamos al api exclusivo del objeto tarea
  constructor(private apiAlumno:AlumnoService){}

  ngOnInit(){
    this.apiAlumno.getAlumnos().subscribe(response=>{
      this.listaAlumnos=response
    })
  }
}
