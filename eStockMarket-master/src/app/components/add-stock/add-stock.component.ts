import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {map} from 'rxjs/operators';
import { CompanyService } from 'src/app/services/company.service';
@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.css']
})
export class AddStockComponent implements OnInit {
  cmpDetails;
  postData: FormGroup;
  submitted = false;
  constructor(private _fb: FormBuilder,private cmpService: CompanyService) { }

  ngOnInit(): void {
    console.log("inside")
    this.postData = this._fb.group(
      {        
        cmpCode: ['', Validators.required],
        stockPrice: ['', Validators.required]        
      });


      this.cmpService.listAllCmp().pipe(map(data => {return data;})).subscribe(response => {
        this.cmpDetails = response        
          console.log("respone :: ",JSON.stringify(response));
        },error => {
          console.log("error :: "+error);
        });

  }

  get f() { return this.postData.controls; }

  AddStock() {    
    this.submitted = true;
    console.log("input dta : ", this.postData.value);
        // stop here if form is invalid
        if (this.postData.invalid) {
          console.log("input dta not valid");
            return;
        }
        console.log("input dta : ", this.postData.value);
    this.cmpService.addStock(this.postData.value).subscribe(response => {
      console.log("respone :: " + JSON.stringify(response));
      alert(JSON.stringify(response));
    }, error => {
      alert("Stock Added Succesfully");
      console.log("error :: " + error);
    });

  }

}
