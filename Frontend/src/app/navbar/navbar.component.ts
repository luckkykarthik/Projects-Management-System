import { Component } from '@angular/core';
import { AuthserviceService } from '../service/authservice.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(public authservice:AuthserviceService){}

  public isLoggedIn(){
    return this.authservice.isLoggedIn();
  }

  public logout(){
    this.authservice.logout();
  }
}
