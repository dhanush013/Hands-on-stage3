import { Component, OnInit,ViewChild,AfterViewInit } from '@angular/core';
import{ChildComponent} from './../child/child.component';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit,AfterViewInit{
  parentMessage = "message from parent";

  @ViewChild(ChildComponent,{static:false}) child;
  childInfo:string;
  

  constructor() { }
  ngAfterViewInit(): void {
    this.childInfo=this.child.message;
   
  }
  
  ngOnInit() {
  }


}
