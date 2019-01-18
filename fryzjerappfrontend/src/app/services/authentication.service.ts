import {Injectable} from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private token = 'dupa'; //zmienna zawierająca token


  constructor() {
  }

  getTokenName() {
    return this.token;  //metoda zwracająca prywatny token
  }

  getToken() { //metoda zwracająca wartość tokena
    let cookies: any = document.cookie ? document.cookie.split('; ') : [];
    cookies = cookies.map((raw) => {
      const cookie = raw.split('=');
      if (!cookie || !cookie.length) return {};
      return {
        key: cookie[0],
        val: cookie[1]
      };
    });
    const tOKEN = cookies.find((cookie: any) => cookie.key === this.token) as any;
    return tOKEN ? tOKEN.val : null;
  }

  isAdm() { //inormacja zwrotna czy login istnieje
    return !!this.getToken();
  }

  loginSuccess(tokenn) { //metoda ustawiająca token z idSesji zwróconym z backendu
    const date = new Date();
    date.setTime(date.getTime() + 6000);
    document.cookie = `${this.token}=${tokenn};expires=${date.toUTCString()};path=/`;
  }

}
