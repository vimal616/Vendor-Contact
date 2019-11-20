import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { VendorService } from './vendor.service';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { EditvendorComponent } from './editvendor/editvendor.component';

@NgModule({
  declarations: [
    AppComponent,
    VendorComponent,
    LoginComponent,
    ViewvendorComponent,
    EditvendorComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [VendorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
