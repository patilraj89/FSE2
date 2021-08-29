import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UsersComponent } from './components/company-details/users.component';
import { CreateUserComponent } from './components/create-newcompany/create-user.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';




import { SearchByDateComponent } from './components/search-by-date/search-by-date.component';
import { AddStockComponent } from './components/add-stock/add-stock.component';


@NgModule({
  declarations: [
    AppComponent,
 
    UsersComponent,
 
    CreateUserComponent,

    LoginComponent,
    HomeComponent,

   
    SearchByDateComponent,

   
    AddStockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
