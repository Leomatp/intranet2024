import { Profesor } from "./Profesor"

export class Curso{
    codigoCurso:number
    nombreCurso:string
    creditos:number
    //profesores:Profesor

    constructor(codi:number,nom:string,cred:number){
        this.codigoCurso=codi
        this.nombreCurso=nom
        this.creditos=cred
    }
}