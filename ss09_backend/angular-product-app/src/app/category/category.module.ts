import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CategoryRoutingModule} from './category-routing.module';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryDeleteComponent } from './category-delete/category-delete.component';
import { CategoryCreateComponent } from './category-create/category-create.component';
import { CategoryUpdateComponent } from './category-update/category-update.component';
import {ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [CategoryListComponent, CategoryDeleteComponent, CategoryCreateComponent, CategoryUpdateComponent],
  imports: [
    CommonModule,
    CategoryRoutingModule,
    ReactiveFormsModule
  ]
})
export class CategoryModule { }
