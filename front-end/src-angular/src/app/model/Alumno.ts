import { Sede } from "./Sede"

export class Alumno{
    codigoPersona:number
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
    ciclo:string
    //notas:[]



    constructor(codi:number,nom:string,pat:string,mat:string,cel:number,correo:string,
        dni:string,fec:Date,sexo:string,dir:string,sed:Sede,cic:string){
            this.codigoPersona=codi
            this.nombrePersona=nom
            this.paternoPersona=pat
            this.maternoPersona=mat
            this.celularPersona=cel
            this.correoPersona=correo
            this.dniPersona=dni
            this.fechaNacimientoPersona=fec
            this.sexoPersona=sexo
            this.direccionPersona=dir
            this.sede=sed
            this.ciclo=cic
    }
}