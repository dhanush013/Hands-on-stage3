import { Component, OnInit } from '@angular/core';
import{FormGroup,FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-emp-reactive',
  templateUrl: './edit-emp-reactive.component.html',
  styleUrls: ['./edit-emp-reactive.component.css']
})
export class EditEmpReactiveComponent implements OnInit {
  studentForm: FormGroup;

  constructor() { }
  studentName:any;
  mobileNumer:any;
  salary:any;
  gender:any;
  technology:any;
  employeeForm:any;

  ngOnInit() {
    this.studentForm=new FormGroup(
      {
        studentName:new FormControl('',[
          Validators.required,
          Validators.minLength(3)
        ]),
        mobileNumer:new FormControl('',[
          Validators.required,
          Validators.pattern("[987]{1}[0-9]{9}")
          
        ]),
        salary:new FormControl('',Validators.required),
        gender:new FormControl('',Validators.required),
        technology:new FormControl('',Validators.required)
      }
    );
  }

  FormValues(data:any)
  {
    this.studentName=data.studentName;
    this.mobileNumer=data.mobileNumer;
    this.salary=data.salary;
    this.gender=data.gender;
    this.technology=data.technology;
  }
  

}
