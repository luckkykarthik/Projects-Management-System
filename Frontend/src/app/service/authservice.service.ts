import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  constructor(private router:Router) { }
  public setToken(token:string){
    localStorage.setItem("token",token);
  }

  public getToken(){
   return  localStorage.getItem("token");
  }

  public setRole(role:string){
    return localStorage.setItem("role",role)
  }

  public getRole(){
    return localStorage.getItem("role")
  }

  public isLoggedIn(){
    let token=this.getToken()
      if(token==undefined || token=="" || token===null){
        return false;
      }
      else{
        return true;
      }
  }

  public loginuser(response:any){
    this.setToken(response.token);
    this.setRole(response.role);
    const role=response.role;
    if(role === "student"){
      this.router.navigate(['/dashboard']).then(() => {
        // window.location.reload();
      });
    }
    else if(role === "teacher"){
      this.router.navigate(['/faculty']).then(() => {
        // window.location.reload();
      });
    }
    else{
      this.router.navigate(['/admin']).then(() => {
        // window.location.reload();
      });
    }
  }
  public logout(){
    localStorage.clear();
    // location.href="/"
    this.router.navigate(['']);
  }

  public roleMatch(role:string){
    const srole=this.getRole();
    if(srole != null && srole){
      if(role === srole){
        return true;
      }
      else{
        return false;
      }
    }
    return false;
  }
}
