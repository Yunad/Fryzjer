import {by, element} from "protractor";

function loginViewPath(loginComponents: string) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > ' + loginComponents;
}

export class LoginComponents {

  getLoginLabel() {
    return element(by.css(loginViewPath('p.Butlog > b')));
  }

  getLoginButton() {
    return element(by.css(loginViewPath('a:nth-child(7) > button')));
  }

  getLoginMailField() {
    return element(by.css('input:nth-child(3)'));
  }

  getLoginPasswordField() {
    return element(by.css('input:nth-child(5)'));
  }

}
