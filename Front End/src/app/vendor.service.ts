import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { VENDORS } from './vendor';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private _httpService:HttpClient,private _router:Router) { }
  getRoleId(formData:any):any{
    return this._httpService.get<VENDORS>(environment.APIUrl+'api/login/'+formData.username+'/'+formData.password);
  }
  getAllVendors(): Observable<VENDORS[]>{
    return this._httpService.get<VENDORS[]>(environment.APIUrl +'vendors');
  }
  addVendor(vendor:VENDORS){
    let body=JSON.stringify(vendor);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    if(vendor.id !=null)
    {
      return this._httpService.put(environment.APIUrl +'vendor/add',body,options);
    }
    else{
      return this._httpService.post(environment.APIUrl +'vendor/add',body,options);

    }
   
  }
  getVendorById(id:number): Observable<VENDORS>{
    return this._httpService.get<VENDORS>(environment.APIUrl +'vendors/'+id);
  }
  updateRecord(product:VENDORS)
  {
    let body = JSON.stringify(product);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    return this._httpService.post(environment.APIUrl +'vendor/add',body,options);  
  }
  searchVendor(search:string): Observable<VENDORS[]>{
    return this._httpService.get<VENDORS[]>(environment.APIUrl +'vendor/'+search);
  }

  disableVender(id:number): Observable<VENDORS>{

    let body = JSON.stringify(id);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    return this._httpService.put<VENDORS>(environment.APIUrl +'disable/'+id,body,options); 

  }
}
