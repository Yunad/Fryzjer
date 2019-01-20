import {MainPageComponents, ReservationComponents} from './AppComponentsTest.po';
import {RegisterComponents} from './RegisterModuleTest.po';
import {LoginComponents} from './LoginModuleTest.po';
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

    it('Wyświetla przycisk Strona domowa', function () {
      expect(page.getHomeButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Strona domowa wyświetla stronę główną', function () {
      page.getHomeButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    });

    it('Wyświetla przycisk Rezerwacja wizyty', function () {
      expect(page.getReservationButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Rezerwacja wizyty wyświetla stronę rezerwacji', function () {
      page.getReservationButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/reservation');
    });

    it('Wyświetla przycisk Cennik usług', function () {
      expect(page.getRegisterButton().isPresent()).toBe(true);
    });

    it('Po naciśnięciu przycisku Cennik usług wyświetla stronę rejestracji', function () {
      page.getRegisterButton().click();
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
      expect(login.getLoginLabel().isPresent()).toBe(true);
    });

    it('Wyświetla przycisk Zaloguj', function () {
      expect(login.getLoginButton().isPresent()).toBe(true);
    });

  });

  describe('Widok rejestracji', function () {

    let register: RegisterComponents;

    beforeEach(() => {
      browser.get('/register');
      register = new RegisterComponents();
    });

    it('Wyświetla napis Zarejestruj się', function () {
      expect(register.getRegisterNameText().isPresent()).toBe(true);
    });

    it('Wyświetla zdjęcie w widoku rejestracji', function () {
      expect(register.getRegisterImg().isPresent()).toBe(true);
    });

    it('Wyświetla przycisk Załóż konto', function () {
      expect(register.getRegisterButton().isPresent()).toBe(true);
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

  });

});
