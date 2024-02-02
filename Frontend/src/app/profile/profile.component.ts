import { Component,OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  constructor(private user:UserService){}
  User:any={}
  ngOnInit(): void {
    this.user.getProfile().subscribe(data=>{
      this.User=data;
  })
  }
}
