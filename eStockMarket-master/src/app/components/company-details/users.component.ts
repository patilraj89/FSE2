import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';
import {map} from 'rxjs/operators';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  viewingUser: User;
  toSearchCompanyCode: string;

  usersDetails:any = [];

  postData = this._fb.group({
    companyCode: ['', Validators.required]
  });

  constructor(private userService: UserService,
    private _fb: FormBuilder) { }

  ngOnInit(): void {
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

  searchUser(){
    if(this.postData.value['companyCode']){
      //this.viewingUser = this.userService.getUser(this.toSearchUserEmail);
      //search in below data. use filter if necessary
      console.log("companyCode : ",this.postData.value['companyCode']);
    }
  }

  handleResponse(response){
    console.log(response);
  }

}
