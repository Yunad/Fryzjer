import {LoginViewComponents, MainPageComponents, PriceListViewComponents, RegisterViewComponents} from './app.po';
import {browser} from 'protractor';

describe('Main page', () => {

  let page: MainPageComponents;

  beforeEach(() => {
    browser.get('/');
    page = new MainPageComponents();
  });

  it('Wyświetla logo', () => {
    expect(page.getLogoImg().isPresent()).toBe(true);
  });

  it('Wyświetla przycisk: Home', () => {
    expect(page.getHomeButton().getText()).toEqual('Home');
  });

  it('Po naciśnięciu przycisku Home wyświetla stronę główną', () => {
    page.getHomeButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
  });

  it('Wyświetla przycisk: Login', () => {
    expect(page.getLoginButton().getText()).toEqual('Login');
  });

  it('Po naciśnięciu przycisku Login wyświetla stronę logowania', () => {
    page.getLoginButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
  });

  it('Wyświetla przycisk: Register', () => {
    expect(page.getRegisterButton().getText()).toEqual('Register');
  });

  it('Po naciśnięciu przycisku Register wyświetla stronę rejestracji', () => {
    page.getRegisterButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
  });

  it('Wyświetla przycisk: Cennik', () => {
    expect(page.getPriceButton().getText()).toEqual('Cennik');
  });

  it('Po naciśnięciu przycisku Cennik wyświetla usługi fryzjerskie', () => {
    page.getPriceButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/priceList');
  });

  it('Wyświetla zdjęcia na slajdach', () => {
    expect(page.getCarouselImg().isPresent()).toBe(true);
  });

  it('Wyświetla: COPYRIGHT @ 2018 w stopce', () => {
    expect(page.getFooterLabel1().getText()).toEqual('COPYRIGHT @ 2018');
  });

  it('Wyświetla: KONTAKT w stopce', () => {
    expect(page.getFooterLabel2().getText()).toEqual('KONTAKT');
  });

  it('Wyświetla: REGULAMIN w stopce', () => {
    expect(page.getFooterLabel3().getText()).toEqual('REGULAMIN');
  });

  it('Wyświetla: byJunk22 w stopce', () => {
    expect(page.getFooterLabel4().getText()).toEqual('by Junk22');
  });

});

describe('Login view', () => {

  let login: LoginViewComponents;

  beforeEach(() => {
    browser.get('/');
    login = new LoginViewComponents();
  });

  it('Wyświetla napis: Zaloguj się', () => {
    expect(login.getLoginLabel().getText()).toEqual('Zaloguj się!!!');
  });

  it('Wyświetla przycisk: Zaloguj', () => {
    expect(login.getLogin2Button().getText()).toEqual('Zaloguj');
  });

  it('Wyświetla przycisk: Załóż konto', () => {
    expect(login.getCreateAccountButton().getText()).toEqual('Załóż konto');
  });

  it('Wyświetla link: Zapomniałem hasła', () => {
    expect(login.getForgettenPasswordLink().getText()).toEqual('Zapomniałem hasła');
  });

});

describe('Register view', () => {

  let register: RegisterViewComponents;

  beforeEach(() => {
    browser.get('/register');
    register = new RegisterViewComponents();
  });

  it('Wyświetla napis: Zarejestruj się', () => {
    expect(register.getRegisterName().getText()).toEqual('Zarejestruj się');
  });

  it('Wyświetla zdjęcie w widoku rejestracji', () => {
    expect(register.getRegisterImg().isPresent()).toBe(true);
  });

});

describe('Price List view', () => {
  let price: PriceListViewComponents;

  beforeEach(() => {
    browser.get('/priceList');
    price = new PriceListViewComponents();
  });

  it('Wyświetla napis: Nasze usługi fryzjerskie', () => {
    expect(price.getPriceListName().getText()).toEqual('Nasze usługi fryzjerskie');
  });

  it('Wyświetla w tabeli usługę: Strzyżenie męskie', () => {
    expect(price.getPriceList1().getText()).toEqual('Strzyżenie męskie');
  });

  it('Wyświetla w tabeli usługę: Strzyżenie damskie', () => {
    expect(price.getPriceList2().getText()).toEqual('Strzyżenie damskie');
  });

  it('Wyświetla w tabeli usługę: Farbowanie włosów', () => {
    expect(price.getPriceList3().getText()).toEqual('Farbowanie włosów');
  });

  it('Wyświetla w tabeli usługę: Klasyczna koloryzacja włosów', () => {
    expect(price.getPriceList4().getText()).toEqual('Klasyczne koloryzacja włosów');
  });

  it('Wyświetla w tabeli usługę: Balayage', () => {
    expect(price.getPriceList5().getText()).toEqual('Balayage');
  });

  it('Wyświetla w tabeli usługę: Dekoloryzacja włosów', () => {
    expect(price.getPriceList6().getText()).toEqual('Dekoloryzacja włosów');
  });

  it('Wyświetla w tabeli usługę: Strzyżenie grzywki', () => {
    expect(price.getPriceList7().getText()).toEqual('Strzyżenie grzywki');
  });

  it('Wyświetla w tabeli usługę: Modelowanie włosów', () => {
    expect(price.getPriceList8().getText()).toEqual('Modelowanie włosów');
  });

  it('Wyświetla w tabeli usługę: Pielęgnacja włosów', () => {
    expect(price.getPriceList9().getText()).toEqual('Pielęgnacja włosów');
  });

  it('Wyświetla w tabeli usługę: Przedłuzanie włosów', () => {
    expect(price.getPriceList10().getText()).toEqual('Przedłużanie włosów');
  });

  it('Wyświetla w tabeli usługę: Zagęszczanie włosów', () => {
    expect(price.getPriceList11().getText()).toEqual('Zagęszczanie włosów');
  });

  it('Wyświetla w tabeli usługę: Doczepianie włosów', () => {
    expect(price.getPriceList12().getText()).toEqual('Doczepianie włosów');
  });

});
