import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Profesor } from 'src/app/model/Profesor';
import { Sede } from 'src/app/model/Sede';
import { AlumnoService } from 'src/app/services/alumno.service';
import { ProfesorService } from 'src/app/services/profesor.service';
import { SedeService } from 'src/app/services/sede.service';

@Component({
  selector: 'app-nuevo-profesor',
  templateUrl: './nuevo-profesor.component.html',
  styleUrls: ['./nuevo-profesor.component.css']
})
export class NuevoProfesorComponent {
  formulario: FormGroup=new FormGroup({})
  submitted = false  
  //crea un listado del objeto Sede
  listaSedes:Sede[]=[]
  //crea un listado del objeto Alumno
  //listaAlumnos:Alumno[]=[]
  //lista de atributos 
    nombrePersona:string
    paternoPersona:string
    maternoPersona:string
    celularPersona:number
    correoPersona:string
    dniPersona:string
    fechaNacimientoPersona:Date
    sexoPersona:string
    direccionPersona:string
    sede:Sede
    codSede:number
    horas:number
    salario:number

  
  //llamamos al api exclusivo del objeto tarea
  constructor(private apiProfesor:ProfesorService,private apiSede:SedeService,
    private router:Router,private fb:FormBuilder){}

  ngOnInit(){
    this.apiSede.getSedes().subscribe(response=>{
      this.listaSedes=response
    })

    this.formulario=this.fb.group({
      nombrePersona:[,[Validators.required]],
      paternoPersona:[,[Validators.required]],
      maternoPersona:[,[Validators.required]],
      celularPersona:[,[Validators.required]],
      correoPersona:[,[Validators.required]],
      dniPersona:[,[Validators.required]],
      fechaNacimientoPersona:[,[Validators.required]],
      sexoPersona:[,[Validators.required]],
      direccionPersona:[,[Validators.required]],
      horas:[,[Validators.required]],
      salario:[,[Validators.required]],
      sede:[,[Validators.required]],
    })
  }

  grabarDatos(){
    var objSede=new Sede(this.codSede,"")
    this.sede=objSede
    var objPro=new Profesor(0,this.nombrePersona,this.paternoPersona,this.maternoPersona,this.celularPersona,this.correoPersona,
      this.dniPersona,this.fechaNacimientoPersona,this.sexoPersona,this.direccionPersona,this.sede,this.salario,this.horas,)

    this.apiProfesor.saveProfesor(objPro).subscribe(response=>{
      alert("Profesor registrado")
      this.router.navigate(['profesor'])
    })  
  }

  onSubmit() {
    this.submitted = true;
    if(this.formulario.invalid) {
			return
		}

    //console.log(this.formulario.value)
		//alert('Mensaje Enviado !')
    this.apiProfesor.saveProfesor(this.formulario.value).subscribe(response=>{
      alert("Correcto")
    })


	}


}
