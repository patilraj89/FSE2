import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loginId: String;

  constructor(private _loginService: LoginService,
    private _userService: UserService,
    private _router: Router) { }

  ngOnInit(): void {
    this.loginId = this._userService.getLoginId();
  }

  logout(){
    //localStorage.removeItem('login-token');
    this._loginService.setLoginFlag("N");
    this._router.navigate(['/login']);
  }

  create(){
    this._router.navigate(['/create']);
  }

}
