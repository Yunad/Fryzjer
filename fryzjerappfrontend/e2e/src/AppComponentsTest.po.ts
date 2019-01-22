import {by, element} from 'protractor';

function buttonPath(numberButton: number) {
  return 'body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ' +
    'ul > li:nth-child(' + numberButton + ') > a > b';
}

function reservationViewPath(reservationComponents: string) {
  return 'body > app-root > app-reservation > div > header > div > div.col-lg-4 > app-reservation-sidebar > div > ' + reservationComponents;
}

export class MainPageComponents {

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

export class ReservationComponents {

  getCalendar() {
    return element(by.css(reservationViewPath('div > my-date-picker > div > div')));
  }

}
