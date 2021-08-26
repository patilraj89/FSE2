import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreateUserComponent } from './components/create-newcompany/create-user.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

import { UsersComponent } from './components/company-details/users.component';
import  {SearchByDateComponent}from './components/search-by-date/search-by-date.component';

const routes: Routes = [
  //{ path: 'login', component: LoginComponent },
 // { path: 'create', component: CreateUserComponent },
 // { path: 'forgetPassword', component: ForgotPasswordComponent},
 // {path:'', component: LoginComponent},
 {path:'', component: LoginComponent},
  {
    path: 'home',
    component: HomeComponent,
    children: [
    
      { path: 'view', component:UsersComponent},
    { path: 'create', component: CreateUserComponent },
      { path: 'search', component: SearchByDateComponent },
   ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
