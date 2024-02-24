import { Component } from '@angular/core';
import { Profesor } from 'src/app/model/Profesor';
import { ProfesorService } from 'src/app/services/profesor.service';

@Component({
  selector: 'app-profesor',
  templateUrl: './profesor.component.html',
  styleUrls: ['./profesor.component.css']
})
export class ProfesorComponent {
  listaProfesores:Profesor[]=[]

  constructor(private apiProfesor:ProfesorService){}

  ngOnInit(){
    this.apiProfesor.getProfesores().subscribe(response=>{
      this.listaProfesores=response
    })
  }

}
