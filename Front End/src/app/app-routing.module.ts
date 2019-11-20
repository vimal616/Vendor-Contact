import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { VendorComponent } from './vendor/vendor.component';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { EditvendorComponent } from './editvendor/editvendor.component';


const routes: Routes = [
  {path:'',component: LoginComponent},
  {path:'vendor',component: ViewvendorComponent},
  {path:'addvendor',component: VendorComponent},
  {path:'editRecord/:id',component: EditvendorComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
