import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Router, ActivatedRoute } from '@angular/router';
import { VENDORS } from '../vendor';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.scss']
})
export class VendorComponent implements OnInit {
  vendors: VENDORS[];
  vendor = new VENDORS();
  constructor(private route:ActivatedRoute,private Service:VendorService, private router:Router) { }

  ngOnInit() {
   
  }
  addRecord(): void{
    this.Service.addVendor(this.vendor)
    .subscribe((response)=>{
        console.log(response);
        
        
      }, (error)=>{
        console.log(error);
        
      });
      this.router.navigate(['vendor'])
  }
  
}
