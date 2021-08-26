import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  UserEmailId: string;
  UserFirstName: string;
  UserLastName: string;
  UserLoginId: string;
  UserGender: string;
  UserBirthDate: string;
  //UserPasswordKey: string;

  postData = this._fb.group(
    {
      companyCode: ['', [Validators.required, Validators.email]],
      comapnyName: ['', Validators.required],
      comapnyCEO: ['', Validators.required],
      companyTurnover: ['', Validators.required],
      companyWebsite: ['', Validators.required],
      stockExchang: ['', Validators.required]
    });

  constructor(
    private userService: UserService,
    private _fb: FormBuilder,
    private _router: Router
  ) { }

  ngOnInit(): void {
    console.log("inside")
  }

  saveUser() {
    console.log("input dta : ", this.postData.value);
    this.userService.createUser(this.postData.value).subscribe(response => {
      console.log("respone :: " + response);
      this._router.navigate(['login']);
    }, error => {
      console.log("error :: " + error);
    });

  }


}
