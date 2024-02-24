import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
@Injectable({
    providedIn: 'root'
  })
  export class AlumnoService{
    private apiBase='http://localhost:8091'

    constructor(private api:HttpClient) { }
  
    getAlumnos(){
      return this.api.get<Alumno[]>(this.apiBase+"/alumno/lista")
    }
    
    saveAlumno(bean:Alumno){
      return this.api.post<Alumno>(this.apiBase+"/alumno/registrar",bean)
    }
  }