import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../model/Tarea';
@Injectable({
    providedIn: 'root'
  })
  export class TareaService{
    private apiBase='http://localhost:8091'

    constructor(private api:HttpClient) { }
  
    getTareas(){
      return this.api.get<Tarea[]>(this.apiBase+"/tarea/lista")
    }
  }