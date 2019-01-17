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
    if (this.minimumPasswordLength() && this.correctPassword() && this.correctMail() && this.minumumUsersCredentialsLength())
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

  private correctPassword(): boolean {
    if (this.password == this.passwordRepeat)
      return true;
  }

  private minimumPasswordLength(): boolean {
    if (this.password.length > 7)
      return true;
  }

  private correctMail(): boolean {
    if (this.email.includes("@") && this.email.includes("."))//TODO: add regex or another method validation
      return true;
  }

  private minumumUsersCredentialsLength(): boolean {
    if (this.lastName.length > 1 && this.firstName.length > 1)
      return true;
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
