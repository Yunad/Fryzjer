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
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

  describe('Kiedy formularz ma niepoprawny format maila (cos@cos.cos)', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Name');
      registerModule.getLastName().sendKeys('LastName');
      registerModule.getMail().sendKeys('mail');
      registerModule.getPassword().sendKeys('Password1234');
      registerModule.getRepeatPasswourd().sendKeys('Password1234');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

  describe('Kiedy w formularzu brakuje jednego wypełnionego pola', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Name');
      registerModule.getLastName().sendKeys('LastName');
      registerModule.getPassword().sendKeys('Password1234');
      registerModule.getRepeatPasswourd().sendKeys('Password1234');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

  describe('Kiedy formularz ma krótkie hasło', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Name');
      registerModule.getLastName().sendKeys('LastName');
      registerModule.getMail().sendKeys('mail@mail.mail');
      registerModule.getPassword().sendKeys('Pass');
      registerModule.getRepeatPasswourd().sendKeys('Pass');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

  describe('Kiedy w formularzu pozycja hasło i powtórz hasło są inne', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta', function () {
      registerModule.getName().sendKeys('Name');
      registerModule.getLastName().sendKeys('LastName');
      registerModule.getMail().sendKeys('mail@mail.mail');
      registerModule.getPassword().sendKeys('Password1234');
      registerModule.getRepeatPasswourd().sendKeys('Password12345');
      registerModule.getRegisterButton().click();
      expect(registerModule.getRegistrationConfirmText().isPresent()).toBe(true);
    })
  });

//TODO: dopisz przypadek utworzenia dwóch takich samych kont oraz przypadek poprawnego wypełnienia formularza

});
