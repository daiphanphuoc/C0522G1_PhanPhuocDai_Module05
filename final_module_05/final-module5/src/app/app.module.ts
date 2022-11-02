import {BrowserModule} from '@angular/platform-browser';
import {NgModule, Pipe} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {NavbarComponent} from './navbar/navbar.component';
import {FooterComponent} from './footer/footer.component';
import {SoTietKiemComponent} from './so-tiet-kiem/so-tiet-kiem.component';
import {SuaSoTietKiemComponent} from './sua-so-tiet-kiem/sua-so-tiet-kiem.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {TitleCasePipe} from '@angular/common';
import { TaoMoiSoTietKiemComponent } from './tao-moi-so-tiet-kiem/tao-moi-so-tiet-kiem.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    FooterComponent,
    SoTietKiemComponent,
    SuaSoTietKiemComponent,
    TaoMoiSoTietKiemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
