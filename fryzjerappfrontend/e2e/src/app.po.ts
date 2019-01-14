import {by, element} from 'protractor';


function buttonPath(numberButton: number) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ' +
    'ul > li:nth-child(' + numberButton + ') > a > b';
}

function loginViewPath(loginComponents: string) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > ' +
    'div > ' + loginComponents;
}

function registerViewPath(registerComponents: string) {
  return 'body > app-root > app-register > div > header > div > div > div.col-sm-6.' + registerComponents;
}

function reservationViewPath(reservationComponents: string) {
  return 'body > app-root > app-reservation > div > div > div.col-lg-4 > app-reservation-sidebar > div > ' + reservationComponents;
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

export class RegisterView {

  getRegisterName() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > h1')));
  }

  getRegisterImg() {
    return element(by.css(registerViewPath('col-md-7.col-lg-8 > img')));
  }

  getName() {

    return element(by.css('#jp1'));
  }

  getSurname() {
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

  getValidationText() {
    return element(by.css(registerViewPath('col-md-5.col-lg-4 > div.text-body > p')));
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

export class ReservationView {

  getCalendar() {
    return element(by.css(reservationViewPath('div > my-date-picker > div > div')));
  }

  getChoiceServices() {
    return element(by.css(reservationViewPath('select')));
  }

}

export class PriceListView {

}
