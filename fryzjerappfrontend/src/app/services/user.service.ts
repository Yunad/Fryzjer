import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class UserService {
  public backendUrl: string = "http://localhost:8082/user";

  constructor(private http: HttpClient) {}

  public createUser(userBody) {
    return this.http.post(this.backendUrl + "/create", userBody);
  }
}
