import {RegisterComponents} from './RegisterModuleTest.po';
import {browser} from 'protractor';

describe('--Przypadki testowe modułu rejestracji--', function () {

  let registerModule: RegisterComponents;

  beforeEach(() => {
    browser.get('/register');
    registerModule = new RegisterComponents();
  });

  describe('Kiedy formularz jest pusty', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma niepoprawny format maila (cos@cos.cos)', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Tony');
      registerModule.getLastName().sendKeys('Montana');
      registerModule.getMail().sendKeys('al.pacino');
      registerModule.getPassword().sendKeys('Scarface83');
      registerModule.getRepeatPasswourd().sendKeys('Scarface83');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy w formularzu brakuje jednego wypełnionego pola', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Vincent');
      registerModule.getLastName().sendKeys('Vega');
      registerModule.getPassword().sendKeys('Pulpfiction');
      registerModule.getRepeatPasswourd().sendKeys('Pulpfiction');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma krótkie hasło', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('James');
      registerModule.getLastName().sendKeys('Volverine');
      registerModule.getMail().sendKeys('x@m.en');
      registerModule.getPassword().sendKeys('xmen');
      registerModule.getRepeatPasswourd().sendKeys('xmen');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy w formularzu pozycja hasło i powtórz hasło są inne', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Don');
      registerModule.getLastName().sendKeys('Vito');
      registerModule.getMail().sendKeys('cor@leo.ne');
      registerModule.getPassword().sendKeys('Godfather');
      registerModule.getRepeatPasswourd().sendKeys('Ojciecchrzesny');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy tworzymy konto a następnie próbujemy utworzyć konto o tym samym mailu', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Lord');
      registerModule.getLastName().sendKeys('Vader');
      registerModule.getMail().sendKeys('star@wa.rs');
      registerModule.getPassword().sendKeys('Powrotjedi');
      registerModule.getRepeatPasswourd().sendKeys('Powrotjedi');
      registerModule.getRegisterButton().click();
      registerModule.getName().clear();
      registerModule.getLastName().clear();
      registerModule.getMail().clear();
      registerModule.getPassword().clear();
      registerModule.getRepeatPasswourd().clear();
      registerModule.getName().sendKeys('Han');
      registerModule.getLastName().sendKeys('Solo');
      registerModule.getMail().sendKeys('star@wa.rs');
      registerModule.getPassword().sendKeys('Atakklonow');
      registerModule.getRepeatPasswourd().sendKeys('Atakklonow');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(false);
    })
  });

  describe('Kiedy formularz ma wszystkie pola poprawnie wypełnione', function () {
    it('wyświetla się potwierdzenie utworzenia konta', function () {
      //browser.sleep(5000);
      registerModule.getName().sendKeys('Jack');
      registerModule.getLastName().sendKeys('Sparrow');
      registerModule.getMail().sendKeys('kap@it.an');
      registerModule.getPassword().sendKeys('Piracizkaraibow');
      registerModule.getRepeatPasswourd().sendKeys('Piracizkaraibow');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

});
