import {LoginView, MainPageView, PriceListView, RegisterView, ReservationView} from './app.po';
import {browser} from 'protractor';


describe('--Testy obecności komponentów, poprawność ścieżek na stronie--', function () {

  beforeEach(function () {
  });

  describe('Strona główna', function () {

    let page: MainPageView;

    beforeEach(function () {
      browser.get('/');
      page = new MainPageView();
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

    let login: LoginView;

    beforeEach(() => {
      browser.get('/');
      login = new LoginView();
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

    let register: RegisterView;

    beforeEach(() => {
      browser.get('/register');
      register = new RegisterView();
    });

    it('Wyświetla napis Zarejestruj się', function () {
      expect(register.getRegisterName().getText()).toEqual('Zarejestruj się');
    });

    it('Wyświetla zdjęcie w widoku rejestracji', function () {
      expect(register.getRegisterImg().isPresent()).toBe(true);
    });

  });

  describe('Widok rezerwacji', function () {
    let reservation: ReservationView;

    beforeEach(() => {
      browser.get('/reservation');
      reservation = new ReservationView();
    });

    it('Wyświetla kalendarz', function () {
      expect(reservation.getCalendar().isPresent()).toBe(true);
    });

    it('Wyświetla wybór usługi', function () {
      expect(reservation.getChoiceServices().isPresent()).toBe(true);
    });

  });

  describe('Widok cennika', function () {
    let price: PriceListView;

    beforeEach(() => {
      browser.get('/priceList');
      price = new PriceListView();
    });

  });
});


describe('--Przypadki testowe modułu rejestracji--', function () {

  let registerModule: RegisterView;

  beforeEach(() => {
    browser.get('/register');
    registerModule = new RegisterView();
  });

  describe('Kiedy formularz jest pusty', function () {
    it('nie wyświetla się potwierdzenie utworzenia konta', function () {
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma niepoprawny format maila (cos@cos.cos)', function () {
    it('nie wyświetla się potwierdzenie utworzenia konta', function () {
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getMail().sendKeys('lolek.pl');
      registerModule.getPassword().sendKeys('Rodorodo!');
      registerModule.getRepeatPasswourd().sendKeys('Rodorodo!');
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy w formularzu brakuje jednego wypełnionego pola', function () {
    it('nie wyświetla się potwierdzenie utworzenia konta', function () {
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getPassword().sendKeys('Rodorodo!');
      registerModule.getRepeatPasswourd().sendKeys('Rodorodo!');
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma krótkie hasło', function () {
    it('nie wyświetla się potwierdzenie utworzenia konta', function () {
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getMail().sendKeys('lol@ek.pl');
      registerModule.getPassword().sendKeys('Rodo!');
      registerModule.getRepeatPasswourd().sendKeys('Rodo!');
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy w formularzu pozycja hasło i powtórz hasło są inne', function () {
    it('nie wyświetla się potwierdzenie utworzenia konta', function () {
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getMail().sendKeys('lol@ek.pl');
      registerModule.getPassword().sendKeys('Rodorodo!');
      registerModule.getRepeatPasswourd().sendKeys('Brakrodo!');
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma wszystkie pola poprawnie wypełnione, klikamy utwórz konto a następnie usuwamy ' +
    'jedno pole i znów klikamy na przycisk', function () {
    it('znika potwierdzenie utworzenia konta', function () {
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getMail().sendKeys('lol@ek.pl');
      registerModule.getPassword().sendKeys('Rodorodo!');
      registerModule.getRepeatPasswourd().sendKeys('Rodorodo!');
      registerModule.getRegisterButton().click();
      registerModule.getName().clear();
      expect(registerModule.getValidationText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma wszystkie pola poprawnie wypełnione', function () {
    it('wyświetla się potwierdzenie utworzenia konta', function () {
      //browser.sleep(5000);
      registerModule.getName().sendKeys('Adam');
      registerModule.getSurname().sendKeys('Waski');
      registerModule.getMail().sendKeys('lol@ek.pl');
      registerModule.getPassword().sendKeys('Rodorodo!');
      registerModule.getRepeatPasswourd().sendKeys('Rodorodo!');
      registerModule.getRegisterButton().click();
      expect(registerModule.getValidationText().isPresent()).toBe(true);
    })
  });

});
