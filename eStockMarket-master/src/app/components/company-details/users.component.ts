import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import {map} from 'rxjs/operators';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  //viewingUser: User;
  toSearchCompanyCode: string;
  cmpDetails;
  usersDetails:any = [];

  postData = this._fb.group({
    companyCode: ['', Validators.required]
  });

  constructor(private cmpService: CompanyService,
    private _fb: FormBuilder) { }

  ngOnInit(): void {
    this.cmpService.listAllCmp().pipe(map(data => {return data;})).subscribe(response => {
      this.cmpDetails = response        
        console.log("respone :: ",JSON.stringify(response));
      },error => {
        console.log("error :: "+error);
      });
  }

  view(){

    console.log("result  ");
  }

  deleteCmp(id){
    alert(id);
    this.cmpService.removeCmp(id).pipe(map(data => {return data;})).subscribe(response => {
      this.cmpDetails = response        
        console.log("respone :: ",JSON.stringify(response));
      },error => {
        console.log("error :: "+error);
      });
  }

  handleResponse(response){
    console.log(response);
  }

}
