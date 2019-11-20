import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { VendorService } from '../vendor.service';
import { VENDORS } from '../vendor';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  login=new VENDORS();
  logins:VENDORS[];
  message:string;

  constructor(private route:ActivatedRoute,private router:Router,private Service:VendorService) { }

  ngOnInit() {
  }
  validLogin(form:NgForm){

    //if ((this.sessionTokenUserName==null) && (this.sessionTokenRoleId==null))
// {
 
 this.Service.getRoleId(form.value).subscribe(data=>{
   console.log(data);
   this.login=data;
   
  
    console.log(this.login);
     
     if(this.login.userId==1){
       console.log(data.username);
       this.router.navigate(['vendor']);
     }
     else if(this.login.userId==2){
       console.log(data.username);
       this.router.navigate(['vendor']);
     }
     
     
     else{
       this.message="Incorrect username or password";
     }
   },
   (error) =>{
     console.log(error);
   });
   }
}



