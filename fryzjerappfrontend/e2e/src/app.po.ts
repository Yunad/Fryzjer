import {by, element} from 'protractor';

export class MainPageComponents {

  getLogoImg() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-3 > img'));
  }

  getHomeButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ul > li:nth-child(1) > a > b'));
  }

  getLoginButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ul > li:nth-child(2) > a > b'));
  }

  getRegisterButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ul > li:nth-child(3) > a > b'));
  }

  getPriceButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ul > li:nth-child(4) > a > b'));
  }

  getCarouselImg() {
    return element(by.css('body > app-root > app-homepage > div > app-carousel > ngb-carousel > div > div.carousel-item.active > img'));
  }

  getFooterLabel1() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td.rig'));
  }

  getFooterLabel2() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td:nth-child(2) > a'));
  }

  getFooterLabel3() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td:nth-child(3) > a'));
  }

  getFooterLabel4() {
    return element(by.css('body > app-root > app-homepage > div > app-footer > footer > div > table > td.lef'));
  }

}

export class PriceListViewComponents {

  getPriceListName() {
    return element(by.css('body > app-root > app-price-list > div > header > h2 > b'));
  }

  getPriceList1() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(1) > span > u'));
  }

  getPriceList2() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(2) > span > u'));
  }

  getPriceList3() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(3) > span > u'));
  }

  getPriceList4() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(4) > span > u'));
  }

  getPriceList5() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(5) > span > u'));
  }

  getPriceList6() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(6) > span > u'));
  }

  getPriceList7() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(7) > span > u'));
  }

  getPriceList8() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(8) > span > u'));
  }

  getPriceList9() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(9) > span > u'));
  }

  getPriceList10() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(10) > span > u'));
  }

  getPriceList11() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(11) > span > u'));
  }

  getPriceList12() {
    return element(by.css('body > app-root > app-price-list > div > header > div.row > div:nth-child(12) > span > u'));
  }

}

export class RegisterViewComponents {

  getRegisterName() {
    return element(by.css('body > app-root > app-register > div > header > div > div > div.col-sm-6.col-md-7.col-lg-8 > h1'));
  }

  getRegisterImg() {
    return element(by.css('body > app-root > app-register > div > header > div > div > div.col-sm-6.col-md-7.col-lg-8 > img'));
  }

}

export class LoginViewComponents {

  getLoginLabel() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > p.Butlog > b'));
  }

  getLogin2Button() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > button.btn'));
  }

  getCreateAccountButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > button.btn-sm'));
  }

  getForgettenPasswordLink() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > p.resent > u'));
  }
}
