import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

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
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.css']
})
export class FacultyComponent {
  accepted:boolean=false;
  rejected:boolean=false;
  pr:boolean=false;
  st:boolean=false;
  users:User[]=[];
  data: Project[] = []; 
  constructor(private user:UserService){}
  requests(){
    this.user.getTprojects().subscribe(res=>{
      this.pr=true;
      this.st=false;
      this.data=res;
    })
  }
  allstudents(){
    this.user.getAllStudents().subscribe(res=>{
      this.st=true;
      this.pr=false;
      this.users=res;
    })
  }
  accept(data:any,index:number){
    this.user.acceptProjectRequest(data).subscribe(res=>{
      this.accepted=true;
      this.rejected=false;
    }
    );
    this.data.splice(index,1);
  }
  reject(index:number,id:number){
      this.user.deleteRequest(id).subscribe();
      this.accepted=false;
      this.rejected=true;
      this.data.splice(index,1);
  }
}
