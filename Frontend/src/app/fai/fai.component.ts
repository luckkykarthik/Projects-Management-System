import { Component } from '@angular/core';
import {ElementRef, OnInit, ViewChild} from '@angular/core'
import { UserService } from '../service/user.service';
@Component({
  selector: 'app-fai',
  templateUrl: './fai.component.html',
  styleUrls: ['./fai.component.css']
})
export class FaiComponent implements OnInit{
  f:Array<any>=[]
  fai:Array<any>=[{
    name:"Ch.Ratna Kumari",
    image:"assets/pa.jpg",
    email:"ratna.challa@gmail.com",
    department:"CSE Department",
    mobile:"944160196",
    domains:["WEB","MAD","IPA"]
  },
  {
    name:"P.Ravi kumar",
    image:"assets/m.jpg",
    email:"ravi@gmail.com",
    department:"CSE Department",
    mobile:"944160236",
    domains:["WEB","MAD",]
  },
  {
    name:"N.Chandra Shekar",
    image:"assets/m.jpg",
    email:"cs@gmail.com",
    department:"CSE Department",
    mobile:"944162196",
    domains:["WEB","MAD","IPA","ML"]
  },
  {
    name:"P.Hari Nadha",
    image:"assets/m.jpg",
    email:"p.hari@gmail.com",
    department:"CSE Department",
    mobile:"784160196",
    domains:["WEB","IPA","NS"]
  },
  {
    name:"T.Sandeep Kumar reddy",
    image:"assets/m.jpg",
    email:"t.sandeep@gmail.com",
    department:"CSE Department",
    mobile:"944760196",
    domains:["WEB","MAD","IPA","NS"]
  },
  {
    name:"N.Satyanandaram",
    image:"assets/m.jpg",
    email:"n.satya@gmail.com",
    department:"CSE Department",
    mobile:"944163456",
    domains:["WEB","MAD","IPA","NS","ML"]
  },
  {
    name:"K.Vinod Kumar",
    email:"k.vinoda@gmail.com",
    image:"assets/m.jpg",
    department:"CSE Department",
    mobile:"944169876",
    domains:["WEB","IPA","CC","ML"]
  },
  {
    name:"V.Sravani",
    image:"assets/pa.jpg",
    email:"v.s@gmail.com",
    department:"CSE Department",
    mobile:"9656871542",
    domains:["WEB","MAD","IPA","ML"]
  },{
    name:"C.Suneetha",
    image:"assets/pa.jpg",
    email:"c.suneetha@gmail.com",
    department:"CSE Department",
    mobile:"8765960196",
    domains:["WEB","MAD","IPA","CC"]
  }
]
  constructor(private user:UserService){}
  private get(){
    // this.user.getfaculties().subscribe(data=>{
    //   this.f=this.fai.concat(data)
    // })
  }
  ngOnInit(): void {
    // if (Object.keys(this.user.data).length === 0) {
    //   // console.log(this.user.data);
    // } else {
    //   this.fai.push(this.user.data);
    //   console.log(this.user.data);
    // }
    this.get();
  }
}
