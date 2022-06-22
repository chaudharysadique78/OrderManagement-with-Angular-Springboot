import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { OrderformComponent } from './components/orderform/orderform.component';
import { ThankuComponent } from './components/thanku/thanku.component';
import { UpdateComponent } from './components/update/update.component';

const routes: Routes = [
  {path:'about',component:AboutComponent},
  {path:'register',component:OrderformComponent},
  {path:'list',component:ListComponent},
  {path:'orderplace',component:ThankuComponent},
  {path:'',component:HomeComponent},
  {path:'update/:id',component:UpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
