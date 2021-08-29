import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginFlag: boolean = false;

  loggedInUser;

  getLoginFlag(){
    return this.loginFlag;
  }

  setLoginFlag(loginFlag){
    this.loginFlag = loginFlag;
  }

  getLoggedInUser(){
    return this.loggedInUser;
  }

  setLoggedInUser(loggedInUser){
    this.loggedInUser = loggedInUser;
  }

  constructor() { }
}
