import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import {map} from 'rxjs/operators';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userData: any = [];
  wrongPassword:boolean = false;

  loginForm = this._fb.group({
    loginId: ['', Validators.required],
    passwordKey: ['', Validators.required]
  });

  constructor(
    private _router: Router,
    private _fb: FormBuilder,
    private _loginService: LoginService,
    private _cmpService: CompanyService
    ) { }

  ngOnInit(): void {
    
  }

  login(){
    this.wrongPassword = false;
    
    this._cmpService.fetchUserData(this.loginForm.value['loginId']).pipe(map(data => {return data;})).subscribe(response => {

        this.userData = response;
        if(this.userData.passwordKey === this.loginForm.value['passwordKey']){
          this._loginService.setLoginFlag("Y"); //logging in
          this._cmpService.setLoginId(this.userData.loginId);
          this._router.navigate(['myTweet']);
        }else{
          this.wrongPassword = true;
        }
        
      },error => {
        console.log("error :: ",error);
        this._loginService.setLoginFlag(false);
      });
  }

  toCreateUser(){
    this._router.navigate(['create']);
  }

}
