import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Profesor } from '../model/Profesor';
@Injectable({
    providedIn: 'root'
  })
  export class ProfesorService{
    private apiBase='http://localhost:8091'

    constructor(private api:HttpClient) { }
  
    getProfesores(){
      return this.api.get<Profesor[]>(this.apiBase+"/profesor/lista")
    }
    
    saveProfesor(bean:Profesor){
      return this.api.post<Profesor>(this.apiBase+"/profesor/registrar",bean)
    }

    updateProfesor(bean:Profesor){
      return this.api.put<Profesor>(this.apiBase+"/profesor/actualizar",bean)
    }
  
    deleteProfesor(cod:number){
      return this.api.delete(this.apiBase+"/profesor/eliminar/"+cod)
    }
  
    getConsultaProfesor(cod:number){
      return this.api.get<Profesor>(this.apiBase+"/profesor/buscar/"+cod)
    }
  
  }