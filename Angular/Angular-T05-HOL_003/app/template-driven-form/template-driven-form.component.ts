import { Component, OnInit } from '@angular/core';
import { addressModel } from 'src/app/address';


@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  countryData: any[] = ['India', 'US', 'UK'];

  model: addressModel = {
  
  address: '',
  
  city: '',
  
  state:'',
  
  postcode: 0,
  
  country: this.countryData[0],
  
  aggrement: false
  
  };
  
  constructor() { }
  
  ngOnInit() {
  
  }
  
  onFormSubmit() {
  
  console.log("Full Address", this.model);
  
  }
  
  }
