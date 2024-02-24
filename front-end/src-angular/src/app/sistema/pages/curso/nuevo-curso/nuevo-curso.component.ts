import { Component } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { CursoService } from 'src/app/services/curso.service';

@Component({
  selector: 'app-nuevo-curso',
  templateUrl: './nuevo-curso.component.html',
  styleUrls: ['./nuevo-curso.component.css']
})
export class NuevoCursoComponent {

  //atributos de la clase Curso
  codigoCurso:number
  nombreCurso:string
  creditos:number
  //llamamos al servicio 
  constructor(private apiCurso:CursoService){}

  grabarDatos(){
    var objCurso= new Curso(this.codigoCurso,this.nombreCurso,this.creditos)
    this.apiCurso.saveCurso(objCurso).subscribe(response=>{
        alert("Curso registrado")
    })
}
}
