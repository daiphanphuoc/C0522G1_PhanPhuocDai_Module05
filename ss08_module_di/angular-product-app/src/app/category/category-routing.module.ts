import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {CategoryDeleteComponent} from './category-delete/category-delete.component';
import {CategoryUpdateComponent} from './category-update/category-update.component';
import {CategoryCreateComponent} from './category-create/category-create.component';
import {CategoryListComponent} from './category-list/category-list.component';

const routes: Routes = [
  {
    path: '',
    component: CategoryListComponent
  },
  {
    path: 'create',
    component: CategoryCreateComponent
  },
  {
    path: 'edit/:id',
    component: CategoryUpdateComponent
  },
  {
    path: 'delete/:id',
    component: CategoryDeleteComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule { }
