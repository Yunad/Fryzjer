import {by, element} from 'protractor';

function buttonPath(numberButton: number) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ' +
    'ul > li:nth-child(' + numberButton + ') > a > b';
}

function loginViewPath(loginComponents: string) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > ' +
    'div > ' + loginComponents;
}

export class MainPageView {

  getLogoImg() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-3 > img'));
  }

  getHomeButton() {
    return element(by.css(buttonPath(1)));
  }

  getReservationButton() {

    return element(by.css(buttonPath(2)));
  }

  getRegisterButton() {
    return element(by.css(buttonPath(3)));
  }

  getPriceButton() {
    return element(by.css(buttonPath(4)));
  }

  getCarouselImg() {
    return element(by.css('body > app-root > app-homepage > div > app-carousel > ngb-carousel > ' +
      'div > div.carousel-item.active > img'));
  }

  getFooterLabel1() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td:nth-child(2)'));
  }

  getFooterLabel2() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td:nth-child(3)'));
  }

}

export class PriceListView {

}

export class RegisterView {

  getRegisterName() {
    return element(by.css('body > app-root > app-register > div > header > div > div > div.col-sm-6.col-md-7.col-lg-8 > h1'));
  }

  getRegisterImg() {
    return element(by.css('body > app-root > app-register > div > header > div > div > div.col-sm-6.col-md-7.col-lg-8 > img'));
  }

  get NameField() {
    return element(by.css('#jp1'))
  }

  get SurnameField() {
    return element(by.css('#jp2'))
  }

  get mailField() {
    return element(by.css('#jp3'))
  }

  get passwordField() {
    return element(by.css('#jp5'))
  }

  get repeatPasswourdField() {
    return element(by.css('#jp6'))
  }

}

export class LoginView {

  getLoginLabel() {
    return element(by.css(loginViewPath('p.Butlog')));
  }

  getLogin2Button() {
    return element(by.css(loginViewPath('button.btn')));
  }

  getCreateAccountButton() {
    return element(by.css(loginViewPath('button.btn-sm')));
  }

  getForgettenPasswordLink() {
    return element(by.css(loginViewPath('p.resent')));
  }
}
