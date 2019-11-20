import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VendorService } from '../vendor.service';
import { VENDORS } from '../vendor';

@Component({
  selector: 'app-editvendor',
  templateUrl: './editvendor.component.html',
  styleUrls: ['./editvendor.component.scss']
})
export class EditvendorComponent implements OnInit {
  vendors: VENDORS[];
  vendor = new VENDORS();
  constructor(private route:ActivatedRoute,private router:Router,private Service:VendorService) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getVendorById(params['id']));
   // this.getVendorById(this.id);
   
  }
  getVendorById(id:number){
    console.log(id);
    this.Service.getVendorById(id)
    .subscribe((searchData) =>{
      this.vendor=searchData;
      console.log(searchData);
    }, (error) =>{
    console.log(error);
  });
    }

    updateRecord():void{
      this.Service.updateRecord(this.vendor)
      .subscribe((response) => {
        console.log(response);
        this.router.navigate(['vendor']);
        
      }, (error) =>{
        console.log(error);
      });
      
    }
}
