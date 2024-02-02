import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

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
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit{
  constructor(private user:UserService){}
  show!:boolean;
  projects:Project[]=[]
  ngOnInit(): void {
    this.user.getAcceptedProjects().subscribe(res=>{
      this.projects=res;
      if(this.projects===null){
        this.show=true
      }
      else{
        this.show=false;
      }
    })
  }

}
