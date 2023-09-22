import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { PassengerService } from 'src/app/passenger.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email_store: string="";
  password_store: string="";
  pEmail: string ="";
  pPassword: string ="";



  f_login: boolean = false;
  f_logout: boolean = true;
  f_reg: boolean = false;
  flag_admin: boolean = true;
  flag_passenger: boolean = true;

  constructor(private ps: PassengerService,
              private router: Router,
              private titleService: Title) {
                this.titleService.setTitle("Login Page");
        }

  ngOnInit(): void {
  }


loginUser(loginRef:NgForm) {                   
  let login = loginRef.value;
  console.log(login);
  console.log(login.pEmail);
  console.log(login.pPassword);

  this.ps.login(login).subscribe(
    result=> {
      if(result=="WELCOME") {
        sessionStorage.setItem("email_session", login.pEmail);
        sessionStorage.setItem("password_session", login.pPassword);
            if( login.pEmail == "admin@ad.com") {      
              this.router.navigate(["/homepage"], {skipLocationChange:true});
            } else {
              console.log("Logged in..")
              alert("Welcome "+login.pEmail);
              this.router.navigate(["/homepage"], {skipLocationChange:true});
            }
      } else {
          alert(result);
      }
    }, error=> {
      console.log(error);
      console.log("null "+login.email);
    }
  )
}




}