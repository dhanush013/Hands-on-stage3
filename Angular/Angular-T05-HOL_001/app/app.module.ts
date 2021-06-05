import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditEmpReactiveComponent } from './edit-emp-reactive/edit-emp-reactive.component';

import {Routes,RouterModule} from '@angular/router';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';

const routes:Routes=[
 
  {path:'Employee',component:EditEmpReactiveComponent}  
]

@NgModule({
  declarations: [
    AppComponent,
    EditEmpReactiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),FormsModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }