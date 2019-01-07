import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  private roleId: number = 1;
  public password: string;
  public passwordRepeat: string;
  public firstName: string;
  public lastName: string;
  public email: string;

  public userInfo: string;

  constructor(private userService: UserService) {
  }

  public registerUser(): void {
    this.userService.createUser(this.prepareUserBody()).subscribe(
      (response) => {
        this.userInfo = "Konto zostało utworzone!";
      },
      (error) => {
        console.log(error);
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
    return true;
  }

  onSubmit(): void {
    if (this.validateUser()) {
      this.registerUser();
    } else {

    }
  }


  ngOnInit() {
  }

}
