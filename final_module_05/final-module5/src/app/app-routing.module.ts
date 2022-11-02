import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SoTietKiemComponent} from './so-tiet-kiem/so-tiet-kiem.component';
import {SuaSoTietKiemComponent} from './sua-so-tiet-kiem/sua-so-tiet-kiem.component';
import {TaoMoiSoTietKiemComponent} from './tao-moi-so-tiet-kiem/tao-moi-so-tiet-kiem.component';


const routes: Routes = [
  {path: 'tietkiem', component: SoTietKiemComponent},
  {path: 'tietkiem/taomoi', component: TaoMoiSoTietKiemComponent},
  {path: 'tietkiem/:id', component: SuaSoTietKiemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
