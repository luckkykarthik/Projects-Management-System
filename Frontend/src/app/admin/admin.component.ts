import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

interface user{
  name: string;
    gender:string;
    department:string;
    role: string;
    email: string;
    password: string;
    phone: string;
    id: number;
}
interface Project {
  id: number;
  studentid: number;
  studentname: string;
  title: string;
  description: string;
  faculty: string;
  aod:string;
}
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{
  pr:boolean=false;
  st:boolean=false;
  users:user[]=[];
  data:user[]=[];
  iptr:user[]=[];
  prd:Project[]=[];
  np:boolean=false;
  constructor(private user:UserService){}
  ngOnInit(): void {
    this.user.getAllTeachers().subscribe(res=>{
      this.data=res;
    })
  }
  allTeachers(){
    this.users=this.data;
    this.pr=true;
    this.st=false;
  }
  ptr(){
    this.iptr=this.data;
    this.users=this.data;
    this.pr=false;
    this.st=true;
  }
  getRe(id:number){
    this.user.geteveryteacherProjectRequests(id).subscribe(res=>{
      this.prd=res;
      if(this.prd.length==0){
        this.np=true
      }
      else{
        this.np=false;
      }
    })
  }
  onclick(k:string){

  }
}
