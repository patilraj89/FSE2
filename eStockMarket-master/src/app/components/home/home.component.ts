import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { CompanyService } from 'src/app/services/company.service';
import {AddStockComponent} from '../add-stock/add-stock.component';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loginId: String;

  constructor(
    private _cmpService: CompanyService,
    private _router: Router) { }

  ngOnInit(): void {
    this.loginId = this._cmpService.getLoginId();
  }  

  create(){
    this._router.navigate(['/create']);
  }

}
