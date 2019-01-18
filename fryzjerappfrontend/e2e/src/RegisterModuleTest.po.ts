import {registerViewPath} from "./AppComponentsTest.po";
import {by, element} from "protractor";

export class RegisterComponents {

  getRegisterName() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > h1')));
  }

  getRegisterImg() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > img')));
  }

  getName() {

    return element(by.css('#jp1'));
  }

  getLastName() {
    return element(by.css('#jp2'));
  }

  getMail() {
    return element(by.css('#jp3'));
  }

  getPassword() {
    return element(by.css('#jp5'));
  }

  getRepeatPasswourd() {
    return element(by.css('#jp6'));
  }

  getRegisterButton() {
    return element(by.css(registerViewPath('col-md-5.col-lg-4 > div.text-body > input.btn')));
  }

  getRegistrationConfirmText() {
    return element(by.css(registerViewPath('col-md-5.col-lg-4 > div.text-body > p')));
  }

}
