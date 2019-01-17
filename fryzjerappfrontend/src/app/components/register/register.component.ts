import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  private roleId: number = 1;
  public password: string = "";
  public passwordRepeat: string = "";
  public firstName: string = "";
  public lastName: string = "";
  public email: string = "";

  public userInfo: string;

  constructor(private userService: UserService, private router: Router) {
  }

  public registerUser(): void {
    this.userService.createUser(this.prepareUserBody()).subscribe(
      (response) => {
        this.goTo('');
        console.log(response);
        alert("Konto zostało utworzone. Możesz teraz się zalogować!");
      },
      (error) => {
        console.log(error);
        this.userInfo = "Nie udało się założyć konta. Sprubój jeszcze raz!";
      }
    )
  }

  private prepareUserBody() {
    return {
      name: this.firstName,
      lastName: this.lastName,
      password: this.password,
      email: this.email,
      roleId: this.roleId
    };
  }

  private validateUser(): boolean {
    if (this.password == this.passwordRepeat && this.password.length > 7 && this.email.includes("@")
      && this.lastName.length > 1 && this.firstName.length > 1 && this.email.includes(".")) //TODO: This must be changed. Adam
      return true;
    else
      return false;
  }

  public clear(): void {
    this.lastName = "";
    this.password = "";
    this.email = "";
    this.passwordRepeat = "";
    this.firstName = "";
  }

  public clearInfo(): void {
    this.userInfo = "";
  }

  public goTo(path: string): void {
    this.router.navigate([path])
  }

  onSubmit(): void {
    if (this.validateUser()) {
      this.registerUser();
      this.clear();

    } else {
      this.userInfo = "Niepoprawne dane. Spróbuj jeszcze raz!";
    }
  }


  ngOnInit() {
  }

}
