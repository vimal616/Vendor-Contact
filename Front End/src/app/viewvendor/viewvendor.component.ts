import { Component, OnInit } from '@angular/core';
import { VENDORS } from '../vendor';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewvendor',
  templateUrl: './viewvendor.component.html',
  styleUrls: ['./viewvendor.component.scss']
})
export class ViewvendorComponent implements OnInit {
  vendors: VENDORS[];
  vendor = new VENDORS();
  search:string;
  constructor(private Service:VendorService, private router:Router) { }

  ngOnInit() {
    this.getVendors();
  }
  getVendors(): void {
    this.Service.getAllVendors().subscribe((data) => { this.vendors = data, console.log(data); }, (error) => { console.log(error); });
  }
  addvendor(): void{
    this.router.navigate(['addvendor']);
  }
  edit(id:number)
  {
    this.router.navigate(['/editRecord/'+id]);
  }

  logout(id:number)
  {
    this.router.navigate(['']);
  }
  searchVendor(search:string):void{
    console.log(search);
if(search!=null)
{
  console.log(search);
  this.Service.searchVendor(search).subscribe((vendordata)=>{
    this.search=undefined;
    this.vendors=vendordata,
    console.log(vendordata);
  },(error)=>{console.log(error);}
  );
}
  else{

    this.getVendors();
  }
}

disable(venderId:number):void{
  this.Service.disableVender(venderId)
  .subscribe((data)=>{
    this.getVendors();
    console.log(data)
  },
  (error)=>{
    console.log(error)
  })
  }


  }

