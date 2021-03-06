import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public login: string = "";
  public password: string = "";
  public validationMessage: string = '';

  constructor(private router: Router) { }

  public onLogin(): void {
    this.validationMessage = "";
    if (this.login.length > 1 && this.password.length > 1) {
      //wysylanie do serwera
    } else {
      this.validationMessage = "Wypełnij pole LOGIN oraz HASŁO";
    }
  }

  public goTo(path: string): void {
    this.router.navigate([path])
  }

  ngOnInit() {
  }

}
