import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/Login';
import { Rol } from 'src/app/model/Rol';
import { Usuario } from 'src/app/model/Usuario';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username:string
  password:string
  //variables para el registro de un nuevo usuario 
  codigo:number
  login:string
  clave:string
  nombre:string
  apellido:string
  rol:Rol


  modalAbierto: boolean = false;

  //crear objeto de Login
 
  constructor(private api:LoginService,private router:Router){}


    //mètodo
    iniciarSesion(){
      let obj=new Login(this.username,this.password)
      this.api.postIniciarSesion(obj).subscribe(response=>{
       this.router.navigate(['sistema'])
        //guardar token
        sessionStorage.setItem('token',response.accessToken)

      },err=>{
        alert("Usuario y/o clave incorrectos");
      })
  
    }
    abrirModal() {
      console.log("abierto")
      this.modalAbierto = true;
    }
  
    cerrarModal() {
      this.modalAbierto = false;
    }
  
    registrarUsuario() {
      let usu= new Usuario(this.codigo,this.login,this.clave,this.nombre,this.apellido,this.rol)
      // Lógica para enviar los datos del nuevo usuario al backend y guardar en la base de datos
      // Por ejemplo, usando un servicio HTTP POST para enviar los datos al backend
      this.api.registrarUsuario(usu).subscribe(
        (response) => {
          // Procesar la respuesta del backend si es necesario
          console.log('Usuario registrado:', response);
          // Cerrar el modal después de registrar
          this.cerrarModal();
        },
        (error) => {
          // Manejo de errores
          console.error('Error al registrar usuario:', error);
        }
      );
    }



}
