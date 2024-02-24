export class Tarea{
    codigoTarea:number
    titulo:string
    descripcion:string
    asignacion:string
    constructor(cod:number,tit:string,desc:string,asig:string){
        this.codigoTarea=cod
        this.titulo=tit
        this.descripcion=desc
        this.asignacion=asig
    }
}