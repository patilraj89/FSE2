import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  postData: FormGroup;
  submitted = false;
  pattern1 =  "^[0-9_-]{10,12}"; 

  constructor(
    private cmpService: CompanyService,
    private _fb: FormBuilder,
    private _router: Router
  ) { }

  ngOnInit(): void {
    console.log("inside")
    this.postData = this._fb.group(
      {
        //companyCode: ['', [Validators.required, Validators.email]],
        comapnyName: ['', Validators.required],
        comapnyCEO: ['', Validators.required],
        companyTurnover: ['', Validators.required],
        companyWebsite: ['', Validators.required],
        stockExchang: ['',Validators.required]
      });
  }


  get f() { return this.postData.controls; }

  AddCmp() {    
    this.submitted = true;

        // stop here if form is invalid
        if (this.postData.invalid) {
          console.log("input dta not valid");
            return;
        }
        console.log("input dta : ", this.postData.value);
    this.cmpService.createCompany(this.postData.value).subscribe(response => {
      console.log("respone :: " + JSON.stringify(response));
      alert('Company Created Successfully');
    }, error => {
      console.log("error :: " + error);
    });

  }


}
