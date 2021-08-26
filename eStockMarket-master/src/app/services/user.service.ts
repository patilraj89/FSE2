import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tweets } from '../model/Tweets';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  loginId: string;
  isReply:boolean = false;

  local = "3.249.45.95";


  getReply(){
    return this.isReply;
  }
  setIsReply(isReply:boolean){
    this.isReply = isReply;
  }
  getLoginId(){
    return this.loginId;
  }

  setLoginId(loginId: string){
    this.loginId = loginId;
  }

  viewUser(){
    return this.http.get('http://'+this.local+':8081/users');
  }

  fetchUserData(loginIdInput){
    return this.http.get('http://'+this.local+':8081/user/login/'+ loginIdInput);
  }

  resetPassword(newPassword){
    return this.http.put('http://'+this.local+':8081/user/forgetPassword',newPassword, {responseType: 'text'});
  }

  createTweet(userData){
    return this.http.post('http://'+this.local+':8081/user/createTweet', userData);
  }

  createUser(userDt){
    return this.http.post('http:/'+this.local+':8081/user/create', userDt);
  }

  allTweets(){
    return this.http.get('http://'+this.local+':8081/user/allTweets');
  }

  myTweets(loginId){
    return this.http.get('http://'+this.local+':8081/user/allTweets/'+loginId);
  }

  allUsers(){
    return this.http.get('http://'+this.local+':8081/user/allUsers');
  }

  like(likeData){
    return this.http.put('http://'+this.local+':8081/user/likes',likeData, {responseType: 'text'});
  }

  reply(userDt){
    return this.http.put('http://'+this.local+':8081/user/reply', userDt);
  }
  constructor(private http: HttpClient) { }
}
