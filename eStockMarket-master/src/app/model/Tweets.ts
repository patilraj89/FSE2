export class Tweets{
    constructor(public loginId:string, public message: string, public timeStamp: string, public likes:number, public original:boolean, public userTweet){};
}