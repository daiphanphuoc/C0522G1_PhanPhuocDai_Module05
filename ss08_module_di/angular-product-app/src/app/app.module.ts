import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ProductModule} from './product/product.module';
import {ProductRoutingModule} from './product/product-routing.module';
import {CategoryRoutingModule} from './category/category-routing.module';
import {CategoryModule} from './category/category.module';
import {ShareModule} from './share/share.module';
import {ShareRoutingModule} from './share/share-routing.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    ProductModule,
    ProductRoutingModule,
    CategoryRoutingModule,
    CategoryModule,
    ShareModule,
    ShareRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
