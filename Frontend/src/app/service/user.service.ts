import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { pfaculty } from '../model/pfaculty';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseurl="http://localhost:8080";
  constructor(private http:HttpClient) { }

  public generateToken(logindata:any):Observable<any>{
    return this.http.post(this.baseurl+"/login",logindata);
  }

  public createUser(user:any):Observable<any>{
    return this.http.post(this.baseurl+"/create",user);
  }

  public getProfile():Observable<any>{
    return this.http.get<any>(this.baseurl+"/profile");
  }

  public getUsers():Observable<[]>{
      return this.http.get<[]>(this.baseurl+"/users");
    }
  public getAllTeachers():Observable<[]>{
    return this.http.get<[]>(this.baseurl+"/teachers");
  }

  public getAllStudents():Observable<[]>{
    return this.http.get<[]>(this.baseurl+"/students");
  }
  public getTprojects():Observable<[]>{
      return this.http.get<[]>(this.baseurl+"/projectrequest");
    }
  public geteveryteacherProjectRequests(id:number):Observable<[]>{
    return this.http.get<[]>(`${this.baseurl}/projectrequest/${id}`);
  }
  public check(id:number):Observable<boolean>{
    return this.http.get<boolean>(`${this.baseurl}/projectrequest/check/${id}`);
  }
  public sendProjectRequest(data:any):Observable<any>{
    return this.http.post(this.baseurl+"/projectrequest",data);
  }
  public deleteRequest(studentid:number){
    return this.http.delete(`${this.baseurl}/projectrequest/${studentid}`);
  }
  public acceptProjectRequest(data:any):Observable<any>{
    return this.http.post(this.baseurl+"/projectrequest/accept",data);
  }
  public isProjectAccepted(id:number):Observable<boolean>{
    return this.http.get<boolean>(`${this.baseurl}/projectrequest/checkaccept/${id}`);
  }
  public getAcceptedProjects():Observable<[]>{
    return this.http.get<[]>(this.baseurl+"/apr");
  }
  public updateGithublink(data:any):Observable<[]>{
    return this.http.put<[]>(this.baseurl+"/apr/update",data);
  }
  
}
  // requestHeader=new HttpHeaders(
  //   {"No-Auth":"True"}
  // );
  // data={}
  // private baseurl="http://localhost:8001/user";
  // constructor(private httpclient:HttpClient) { }
  // getusers():Observable<User[]>{
  //   return this.httpclient.get<User[]>(`${this.baseurl}`);
  // }
  // createuser(user:User):Observable<any>{
  //   return this.httpclient.post(`${(this.baseurl)}`,user)
  // }
  // getfaculties():Observable<pfaculty[]>{
  //   return this.httpclient.get<pfaculty[]>(`${this.baseurl+"/faculty"}`);
  // }
  // createfaculty(faculty:pfaculty):Observable<any>{
  //   return this.httpclient.post(`${this.baseurl+"/faculty"}`,faculty)
  // }
  // add(data:any){
  //   this.data=data;
  //   //console.log(this.data)
  // }


