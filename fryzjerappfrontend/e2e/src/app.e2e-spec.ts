import {LoginView, MainPageView, PriceListView, RegisterView} from './app.po';
import {browser} from 'protractor';

describe('Main page', () => {

  let page: MainPageView;

  beforeEach(() => {
    browser.get('/');
    page = new MainPageView();
  });

  it('Wyświetla logo', () => {
    expect(page.getLogoImg().isPresent()).toBe(true);
  });

  it('Wyświetla przycisk: Home', () => {
    expect(page.getHomeButton().isPresent()).toBe(true);
  });

  it('Po naciśnięciu przycisku Home wyświetla stronę główną', () => {
    page.getHomeButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
  });

  it('Wyświetla przycisk: Rezerwacja', () => {
    expect(page.getReservationButton().isPresent()).toBe(true);
  });

  it('Po naciśnięciu przycisku Rezerwacja wyświetla stronę rezerwacji', () => {
    page.getReservationButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/reservation');
  });

  it('Wyświetla przycisk: Register', () => {
    expect(page.getRegisterButton().isPresent()).toBe(true);
  });

  it('Po naciśnięciu przycisku Register wyświetla stronę rejestracji', () => {
    page.getRegisterButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
  });

  it('Wyświetla przycisk: Cennik', () => {
    expect(page.getPriceButton().isPresent()).toBe(true);
  });

  it('Po naciśnięciu przycisku Cennik wyświetla usługi fryzjerskie', () => {
    page.getPriceButton().click();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/priceList');
  });

  it('Wyświetla zdjęcia na slajdach', () => {
    expect(page.getCarouselImg().isPresent()).toBe(true);
  });

  it('Wyświetla link: KONTAKT w stopce', () => {
    expect(page.getFooterLabel1().isPresent()).toBe(true);
  });

  it('Wyświetla link: REGULAMIN w stopce', () => {
    expect(page.getFooterLabel2().isPresent()).toBe(true);
  });

});

describe('Login view', () => {

  let login: LoginView;

  beforeEach(() => {
    browser.get('/');
    login = new LoginView();
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

  let register: RegisterView;

  beforeEach(() => {
    browser.get('/register');
    register = new RegisterView();
  });

  it('Wyświetla napis: Zarejestruj się', () => {
    expect(register.getRegisterName().getText()).toEqual('Zarejestruj się');
  });

  it('Wyświetla zdjęcie w widoku rejestracji', () => {
    expect(register.getRegisterImg().isPresent()).toBe(true);
  });

});

describe('Price List view', () => {
  let price: PriceListView;

  beforeEach(() => {
    browser.get('/priceList');
    price = new PriceListView();
  });

});
