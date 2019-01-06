import {browser, by, element} from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-4 > app-login > div > p.Butlog > b'));
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

  getRegisterName() {
    return element(by.css('body > app-root > app-register > div > header > div > div > div.col-sm-6.col-md-7.col-lg-8 > h1'));
  }

  getPriceButton() {
    return element(by.css('body > app-root > app-homepage > div > app-header > header > div > div.col-lg-5 > app-menu > ul > li:nth-child(4) > a > b'));
  }

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
