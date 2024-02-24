import { Component } from "@angular/core";
import { Sede } from "src/app/model/Sede";
import { SedeService } from "src/app/services/sede.service";
@Component({
    selector: 'app-nueva-sede',
    templateUrl: './nueva-sede.component.html',
    styleUrls: ['./nueva-sede.component.css']
  })
  export class NuevaSedeComponent{
    //atributos de la clase Sede
    codigoSede:number
    nombreSede:string

    //llamamos al servicio
    constructor(private apiSede:SedeService){}

    grabarDatos(){
        var objSede= new Sede(this.codigoSede,this.nombreSede)
        this.apiSede.saveSede(objSede).subscribe(response=>{
            alert("Sede registrada")
        })
    }
  }