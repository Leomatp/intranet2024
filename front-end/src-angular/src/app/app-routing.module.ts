import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './inicio/pages/login/login.component';
import { LayoutComponent } from './sistema/layout/layout.component';

const routes: Routes = [
  { path:'',
  pathMatch: 'full',
  redirectTo:'login'

  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'sistema',
    component:LayoutComponent,
    loadChildren:()=> import('./sistema/sistema.module').then(m=>m.SistemaModule)
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
