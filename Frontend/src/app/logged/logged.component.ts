import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-logged',
  templateUrl: './logged.component.html',
  styleUrls: ['./logged.component.css']
})
export class LoggedComponent {
  constructor(private router:Router){}
  username="Hello Lucky"
  logout(){
    this.router.navigate(["/"])
  }
}
