import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ListemployeeService {

  private rola: number =2;

  public backendUrl: string = "http://localhost:8080/user/get/role/";

  constructor(private http: HttpClient) {
  }

  public getEmploye() {
    return this.http.get(this.backendUrl+this.rola);
  }
}
