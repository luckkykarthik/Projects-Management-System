import { Component, OnInit } from '@angular/core';
import { Project } from '../model/project';
import { UserService } from '../service/user.service';
import { HttpErrorResponse } from '@angular/common/http';
// interface aprd{
//   id:number;
//   studentid:number;
//   studentname:string;
//   title:string;
//   description:string;
//   aod:string;
//   githublink:string;
//   facultyid:string;
//   facultyname:string;
//   submitted:boolean;
// }
@Component({
  selector: 'app-spr',
  templateUrl: './spr.component.html',
  styleUrls: ['./spr.component.css']
})
export class SprComponent implements OnInit {
  done=false;
  updaterror:boolean=false;
  githublink=null;
  registrationSubmitted: boolean = false;
  exists:boolean=false;
  loading: boolean = true;
  isProjectAccepted:boolean=false;
  check!: boolean;
  profile: any = {};
  projectDetails:any={};
  project: Project = { studentid: 0, studentname: '', title: '', description: '', aod: '', faculty: '' };

  constructor(private user: UserService) { }

  ngOnInit(): void {
    this.user.getProfile().subscribe(data => {
      if (data) {
        this.profile = data;
        this.project = {
          studentid: data.id ?? 0,
          studentname: data.name ?? '',
          title: '',
          description: '',
          aod: '',
          faculty: ''
        };
      }
      this.user.isProjectAccepted(this.profile.id).subscribe(
        res=>{
          this.loading = false;
          if(res){
            this.projectDetails=res;
            this.githublink=this.projectDetails.githublink;
            this.isProjectAccepted=true;
          }
          else{
            this.isProjectAccepted=false;
          }
        }
      );
      if(!this.isProjectAccepted){
        this.user.check(this.profile.id).subscribe(res => {
          this.check = res;
          this.loading = false; // Set loading to false once API calls are completed.
        });
      }
    });
  }

  registerProject(): void {
    this.user.sendProjectRequest(this.project).subscribe(
      (res) => {
        this.registrationSubmitted = true;
    },
    (error: HttpErrorResponse) => {
      if (error.status === 409){
          this.exists=true;
      }
      else{
        this.exists=false;
      }
      console.error('Error occurred:', error);
    }
  );
  }
  update(){
    if(!this.githublink){
      this.updaterror=true;
    }
    else{
      this.user.updateGithublink({id:this.projectDetails.id,githublink:this.githublink}).subscribe(
        res=>{
          this.done=true;
        }
      )
    }
  }
}
