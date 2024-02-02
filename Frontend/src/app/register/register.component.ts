import { Component ,OnInit, ViewChild} from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  @ViewChild('registrationForm') registrationForm!: NgForm ;
  user:User=new User();
  saved:boolean=false;
  emailExists:boolean=false;
  register(){
    this.saveuser(); 
    
    // this.user={
    //   name:"",
    //   department:"",
    //   gender:"",
    //   role:"",
    //   email:"",
    //   password: "",
    //   phone: "",
    //   id:""
    // };
  }
  constructor(private userservice:UserService){}
  ngOnInit(): void {
      
  }
  private saveuser(){
    this.userservice.createUser(this.user).subscribe(data=>{
      this.registrationForm.reset();
      this.saved=true;
    },
    (error:HttpErrorResponse)=>{
        this.emailExists=true;
    }
      
    )
    // this.userservice.createuser(this.user).subscribe(data=>{
    //   //console.log(data);
    // })
  }
  
  }

