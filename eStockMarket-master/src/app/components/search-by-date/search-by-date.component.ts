import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';
import {map} from 'rxjs/operators';
import { FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-search-by-date',
  templateUrl: './search-by-date.component.html',
  styleUrls: ['./search-by-date.component.css']
})
export class SearchByDateComponent implements OnInit {

  viewingUser: User;
  toSearchDateTo: string;
  toSearchDateFrom: string;

  usersDetails:any = [];

  postData = this._fb.group({
    searchDateTo: ['', Validators.required],
    searchFromTo: ['', Validators.required],
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
    if(this.postData.value['searchDateTo']){
      //this.viewingUser = this.userService.getUser(this.toSearchUserEmail);
      //search in below data. use filter if necessary
      console.log("searchDateTo : ",this.postData.value['searchDateTo']);
    }
  }

  handleResponse(response){
    console.log(response);
  }

  

}
