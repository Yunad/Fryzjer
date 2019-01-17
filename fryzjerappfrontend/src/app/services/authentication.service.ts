import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public backendUrl: string = "http://localhost:8080/user/get/email/";

  constructor(private http: HttpClient) { }

  getUserDetails(): void {

  }
}
