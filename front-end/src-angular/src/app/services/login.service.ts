import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../model/Login';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
  
  private apiBase='http://localhost:8091'

  constructor(private http:HttpClient) { }

  postIniciarSesion(bean:Login){
    return this.http.post<any>(this.apiBase+"/api/auth/login",bean)
  }
  registrarUsuario(nuevoUsuario: Usuario) {
    return this.http.post<Usuario>(this.apiBase+"/api/auth/register",nuevoUsuario)
  }
}
