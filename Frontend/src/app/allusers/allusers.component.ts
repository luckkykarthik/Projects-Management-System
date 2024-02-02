import { Component,OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  users:User[]=[];
  constructor(private userservice:UserService){}
  private getuser(){
    this.userservice.getUsers().subscribe(data=>{
      this.users=data;
    })
  }
  ngOnInit(): void {
    this.getuser();
      
  }
}
