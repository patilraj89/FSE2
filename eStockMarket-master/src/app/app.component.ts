import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  loginFlag: boolean;
  title = 'eStockMarket';
  constructor(private _loginService: LoginService,
    private _router: Router) { }
    
  ngOnInit() {
    this.loginFlag = this._loginService.getLoginFlag();
  }


}
