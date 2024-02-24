import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Alumno } from 'src/app/model/Alumno';
import { Sede } from 'src/app/model/Sede';
import { AlumnoService } from 'src/app/services/alumno.service';
import { SedeService } from 'src/app/services/sede.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-alumno',
  templateUrl: './nuevo-alumno.component.html',
  styleUrls: ['./nuevo-alumno.component.css']
})
export class NuevoAlumnoComponent {
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
    ciclo:string

  
  //llamamos al api exclusivo del objeto tarea
  constructor(private apiAlumno:AlumnoService,private apiSede:SedeService,
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
      ciclo:[,[Validators.required]],
      sede:[,[Validators.required]],
    })
  }

  grabarDatos(){
    var objSede=new Sede(this.codSede,"")
    this.sede=objSede
    var objAlu=new Alumno(0,this.nombrePersona,this.paternoPersona,this.maternoPersona,this.celularPersona,this.correoPersona,
      this.dniPersona,this.fechaNacimientoPersona,this.sexoPersona,this.direccionPersona,this.sede,this.ciclo,)

    this.apiAlumno.saveAlumno(objAlu).subscribe(response=>{
      alert("Alumno registrado")
      this.router.navigate(['alumnos'])
    })  
  }

  onSubmit() {
    this.submitted = true;
    if(this.formulario.invalid) {
			return
		}

    //console.log(this.formulario.value)
		//alert('Mensaje Enviado !')
    this.apiAlumno.saveAlumno(this.formulario.value).subscribe(response=>{
      alert("Correcto")
    })


	}


}
