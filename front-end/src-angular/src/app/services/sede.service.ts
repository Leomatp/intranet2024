import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sede } from '../model/Sede';
@Injectable({
    providedIn: 'root'
  })
  export class SedeService{
    private apiBase='http://localhost:8091'

    constructor(private api:HttpClient) { }
  
    getSedes(){
      return this.api.get<Sede[]>(this.apiBase+"/sede/lista")
    }
    
    saveSede(bean:Sede){
      return this.api.post<Sede>(this.apiBase+"/sede/registrar",bean)
    }
  }