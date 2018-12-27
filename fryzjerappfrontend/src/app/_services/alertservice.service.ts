import { Injectable } from '@angular/core';
import {Router, NavigationStart} from "@angular/router";
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AlertserviceService {

  private subject = new Subject<any>();
  private  afterChange = false;

  constructor(private router: Router) {
    router.events.subscribe(event =>{ /*wiadomosc na change route*/
      if(event instanceof NavigationStart)
      {
        if(this.afterChange)
        {
          /*zachowaj zmiane*/
          this.afterChange = false;
        }
        else
          {
          this.subject.next();
          }
      }
    })
  }

  success(message : string, afterChange = false){
    this.afterChange = afterChange;
    this.subject.next({type: 'success', text:message});}

  error(message : string, afterChange = false){
    this.afterChange = afterChange;
    this.subject.next({type: 'error', text: message});}

  getMessage() : Observable<any>{
    return this.subject.asObservable();
  }
}
/*Usługa alertowania umożliwia wyświetlanie komunikatów o alertach za pośrednictwem komponentu alertu.
* Są metody do  wyswietlania komunikatu o powodzeniu/błędzie.
* Metoda getMessage (),zwraca obiekt Observable, który komponent wykorysta do zasubskrybowania powiadomień, kiedy trzeba wyświetlic komunikat.*/
