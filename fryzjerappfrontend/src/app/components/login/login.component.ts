import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';
import {HttpClient} from '@angular/common/http';
import {error} from 'selenium-webdriver';

interface LoginModel {

  email: string;
  password: string;

}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public email: string = "";
  public password: string = "";
  public validationMessage: string = '';

  public isLoading = false;
  public model: LoginModel = {email: '', password: ''};

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  public onLogin(): void {
    this.validationMessage = '';
    if (this.email.length > 1 && this.password.length > 7) {//TODO: Lepsza walidacja potrzebna na mail oraz na haslo. Adam
      this.onSubmit();//wysylanie do serwera
    } else {
      this.validationMessage = 'Wypełnij poprawnie LOGIN oraz HASŁO';
      this.clear();
    }
  }

  public clearInfo(): void {
    this.validationMessage = '';
  }

  public goTo(path: string): void {
    this.router.navigate([path]);
  }

  public clear(): void {
    this.email = "";
    this.password = "";
 
  }


  private prepareUserBody() {
    return {
      email: this.model.email,
      password: this.model.password
    };
  }

  onSubmit() {
    this.authenticationService.loginUser(this.prepareUserBody()).subscribe((data: any) => {
      this.authenticationService.loginSuccess(data.tokenn);
      this.router.navigate(['priceList']);
      console.log(data);
    }, (error) => {

      console.log(this.email + this.password);
    });

  }

  ngOnInit() {

  }

}
