import {by, element} from "protractor";

function registerViewPath(registerComponents: string) {
  return 'body > app-root > app-register > div > header > div > div > div.col-sm-6.' + registerComponents;
}

export class RegisterComponents {

  getRegisterNameText() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > h1')));
  }

  getRegisterImg() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > img')));
  }

  getRegisterNameField() {

    return element(by.css('#jp1'));
  }

  getRegisterLastNameField() {
    return element(by.css('#jp2'));
  }

  getRegisterMailField() {
    return element(by.css('#jp3'));
  }

  getRegisterPasswordField() {
    return element(by.css('#jp5'));
  }

  getRegisterRepeatPasswourdField() {
    return element(by.css('#jp6'));
  }

  getRegisterButton() {
    return element(by.css(registerViewPath('col-md-5.col-lg-4 > div.text-body > input.btn')));
  }

}
