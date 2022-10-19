import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RattingBarComponent } from './ratting-bar/ratting-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    RattingBarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
