import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UtilityService {

  public backendUrl: string = "http://localhost:8080/service/get";

  constructor(private http: HttpClient ) {

  }
  public getServices() {
    return this.http.get(this.backendUrl);
  }
}
