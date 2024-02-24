import { Component } from '@angular/core';
import { Tarea } from 'src/app/model/Tarea';
import { TareaService } from 'src/app/services/tarea.service';

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css']
})
export class TareaComponent {
  //crea un listado del objeto tarea
  listaTareas:Tarea[]=[]
  
  //llamamos al api exclusivo del objeto tarea
  constructor(private apiTarea:TareaService){}

  ngOnInit(){
    this.apiTarea.getTareas().subscribe(response=>{
      this.listaTareas=response
    })
  }
}
