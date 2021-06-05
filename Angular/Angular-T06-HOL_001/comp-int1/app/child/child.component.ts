import { Component, OnInit,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  message="Hello World!";
  @Output() messageEvent = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }
  sendMessage() {

    this.messageEvent.emit(this.message);
  }

}
