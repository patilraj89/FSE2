import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CompanyService } from 'src/app/services/company.service';
import {map} from 'rxjs/operators';
import { FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-search-by-date',
  templateUrl: './search-by-date.component.html',
  styleUrls: ['./search-by-date.component.css']
})
export class SearchByDateComponent implements OnInit {

  viewingUser;
  postData;
  stockDetails;
  submitted = false;
  toSearchDateTo: string;
  toSearchDateFrom: string;
  cmpDetails;
  usersDetails:any = [];
  statDetails;
  maxVal;
  minVal;
  avgVal;

  

  constructor(private cmpService: CompanyService,
    private _fb: FormBuilder) { }

  ngOnInit(): void {
    this.postData = this._fb.group({
      cmpCode:['', Validators.required],
      searchDateTo: ['', Validators.required],
      searchDateFrom: ['', Validators.required],
    });

    this.cmpService.listAllCmp().pipe(map(data => {return data;})).subscribe(response => {
      this.cmpDetails = response        
        console.log("respone :: ",JSON.stringify(response));
      },error => {
        console.log("error :: "+error);
      });
   // this.userService.allUsers().pipe(map(data => {return data;})).subscribe(response => {
      //this.viewingUsers = response
   //     this.usersDetails = response;
   //     console.log("respone :: ",response);
   //   },error => {
   //     console.log("error :: "+error);
   //   });

  }

  view(){

    console.log("result  ");
  }

  get f() { return this.postData.controls; }
  searchUser(){
    this.submitted = true;
    console.log("input dta : ", this.postData.value);
        // stop here if form is invalid
        if (this.postData.invalid) {
          console.log("input dta not valid");
            return;
        }
        console.log("input dta : ", this.postData.value.cmpCode);
        this.cmpService.listStockByCmp(this.postData.value).pipe(map(data => {return data;})).subscribe(response => {
          this.stockDetails = response['stockData'];
          this.maxVal = response['maxVal'];
          this.minVal = response['minVal'];
          this.avgVal = response['avgVal'];   
            console.log("respone :: ",JSON.stringify(response));

            this.cmpService.listAllCmp().pipe(map(data => {return data;})).subscribe(response => {
              this.cmpDetails = response        
                console.log("respone :: ",JSON.stringify(response));
              },error => {
                console.log("error :: "+error);
              });


          },error => {
            console.log("error :: "+error);
          });
   
  }

  handleResponse(response){
    console.log(response);
  }

  

}
