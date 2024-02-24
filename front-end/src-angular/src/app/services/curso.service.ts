import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../model/Curso';
@Injectable({
    providedIn: 'root'
  })
  export class CursoService{
    private apiBase='http://localhost:8091'

    constructor(private api:HttpClient) { }
  
    getCursos(){
      return this.api.get<Curso[]>(this.apiBase+"/curso/lista")
    }
    
    saveCurso(bean:Curso){
      return this.api.post<Curso>(this.apiBase+"/curso/registrar",bean)
    }

    updateCurso(bean:Curso){
      return this.api.put<Curso>(this.apiBase+"/curso/actualizar",bean)
    }
  
    deleteCurso(cod:number){
      return this.api.delete(this.apiBase+"/curso/eliminar/"+cod)
    }
  
    getConsultaCurso(cod:number){
      return this.api.get<Curso>(this.apiBase+"/curso/buscar/"+cod)
    }
  }