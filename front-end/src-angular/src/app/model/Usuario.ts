import { Rol } from "./Rol"

export class Usuario{
    codigo:number
    login:string
    clave:string
    nombre:string
    apellido:string
    rol:Rol

    constructor(cod:number,log:string,cla:string,nom:string,ape:string,rol:Rol ){
        this.codigo=cod
        this.login=log
        this.clave=cla
        this.nombre=nom
        this.apellido=ape
        this.rol=rol
    }
}