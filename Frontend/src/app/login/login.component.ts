import { Component, ViewChild } from '@angular/core';
import { UserService } from '../service/user.service';
import { AuthserviceService } from '../service/authservice.service';
import { NgForm } from '@angular/forms';
 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @ViewChild('f') registrationForm!: NgForm ;
  constructor(private userService:UserService,private authservice:AuthserviceService){}
  error:boolean=false;
  logindata={email:"",password:""}
  
  login(){
     this.userService.generateToken(this.logindata).subscribe(
      (response)=>{
        this.error=false;
        this.registrationForm.reset();
        this.authservice.loginuser(response);
     },
     (error)=>{
      this.error=true;
      console.log(error);
     }
    ); 
  }
}
