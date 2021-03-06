import {LoginComponents, MainPageComponents, PriceListComponents, ReservationComponents} from './app.po';
import {RegisterComponents} from './RegisterModuleTest.po';
import {browser} from 'protractor';

describe('--Testy obecności komponentów, poprawność ścieżek na stronie--', function () {

  beforeEach(function () {
  });

  describe('Strona główna', function () {

    let page: MainPageComponents;

    beforeEach(function () {
      browser.get('/');
      page = new MainPageComponents();
    });

    it('Wyświetla logo strony', function () {
      expect(page.getLogoImg().isPresent()).toBe(true);
    });

    it('Wyświetla przycisk Home', function () {
      expect(page.getHomeButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Home wyświetla stronę główną', function () {
      page.getHomeButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    });

    it('Wyświetla przycisk Rezerwacja', function () {
      expect(page.getReservationButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Rezerwacja wyświetla stronę rezerwacji', function () {
      page.getReservationButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/reservation');
    });

    it('Wyświetla przycisk Register', function () {
      expect(page.getRegisterButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Register wyświetla stronę rejestracji', function () {
      page.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    });

    it('Wyświetla przycisk Cennik', () => {
      expect(page.getPriceButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Cennik wyświetla usługi fryzjerskie', () => {
      page.getPriceButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/priceList');
    });

    it('Wyświetla zdjęcia na slajdach', function () {
      expect(page.getCarouselImg().isPresent()).toBe(true);
    });

    it('Wyświetla link KONTAKT w stopce', function () {
      expect(page.getFooterLabel1().isPresent()).toBe(true);
    });

    it('Wyświetla link REGULAMIN w stopce', function () {
      expect(page.getFooterLabel2().isPresent()).toBe(true);
    });

  });

  describe('Widok logowania', function () {

    let login: LoginComponents;

    beforeEach(() => {
      browser.get('/');
      login = new LoginComponents();
    });

    it('Wyświetla napis Zaloguj się', function () {
      expect(login.getLoginLabel().getText()).toEqual('Zaloguj się!!!');
    });

    it('Wyświetla przycisk Zaloguj', function () {
      expect(login.getLogin2Button().getText()).toEqual('Zaloguj');
    });

    it('Wyświetla przycisk Załóż konto', function () {
      expect(login.getCreateAccountButton().getText()).toEqual('Załóż konto');
    });

    it('Wyświetla link Zapomniałem hasła', function () {
      expect(login.getForgettenPasswordLink().getText()).toEqual('Zapomniałem hasła');
    });

  });

  describe('Widok rejestracji', function () {

    let register: RegisterComponents;

    beforeEach(() => {
      browser.get('/register');
      register = new RegisterComponents();
    });

    it('Wyświetla napis Zarejestruj się', function () {
      expect(register.getRegisterName().getText()).toEqual('Zarejestruj się');
    });

    it('Wyświetla zdjęcie w widoku rejestracji', function () {
      expect(register.getRegisterImg().isPresent()).toBe(true);
    });

  });

  describe('Widok rezerwacji', function () {
    let reservation: ReservationComponents;

    beforeEach(() => {
      browser.get('/reservation');
      reservation = new ReservationComponents();
    });

    it('Wyświetla kalendarz', function () {
      expect(reservation.getCalendar().isPresent()).toBe(true);
    });

    it('Wyświetla wybór usługi', function () {
      expect(reservation.getChoiceServices().isPresent()).toBe(true);
    });

  });

  describe('Widok cennika', function () {
    let price: PriceListComponents;

    beforeEach(() => {
      browser.get('/priceList');
      price = new PriceListComponents();
    });

  });
});
