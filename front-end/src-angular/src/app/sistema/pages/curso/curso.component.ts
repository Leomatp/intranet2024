import { Component } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { CursoService } from 'src/app/services/curso.service';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent {
  listaCursos:Curso[]=[]

  constructor(private apiCurso:CursoService){}

  ngOnInit(){
    this.apiCurso.getCursos().subscribe(response=>{
      this.listaCursos=response
    })
  }

}
