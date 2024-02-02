import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { NgForm } from '@angular/forms'; 
import { pfaculty } from '../model/pfaculty';
@Component({
  selector: 'app-afp',
  templateUrl: './afp.component.html',
  styleUrls: ['./afp.component.css']
})
export class AfpComponent {
  DomainValues: any = {
    WEB: false,
    MAD: false,
    NS: false,
    IPA: false,
    CC: false,
    ML: false
  };
  o: any = {};
  constructor(private user: UserService) {}

  getData(d: any) {
    // this.o = d.value;
    // const selectedCheckboxes = Object.keys(this.DomainValues)
    //   .filter(key => this.DomainValues[key]);
    // this.o.domain = selectedCheckboxes;
    // this.o.image=this.o.image.replace("C:\\fakepath\\","")
    // console.log(this.o); 
    // this.user.add(this.o);
    // this.savefaculty();
  }
  savefaculty(){
    // this.user.createfaculty(this.o).subscribe(data=>{
    //   console.log(data)
    // })
  }
}
