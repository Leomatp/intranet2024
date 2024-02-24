import { Component } from '@angular/core';
import { Sede } from 'src/app/model/Sede';
import { SedeService } from 'src/app/services/sede.service';

@Component({
  selector: 'app-sede',
  templateUrl: './sede.component.html',
  styleUrls: ['./sede.component.css']
})
export class SedeComponent {
  listaSedes:Sede[]=[]

  constructor(private apiSede:SedeService){}

  ngOnInit(){
    this.apiSede.getSedes().subscribe(response=>{
      this.listaSedes=response
    })
  }

}
