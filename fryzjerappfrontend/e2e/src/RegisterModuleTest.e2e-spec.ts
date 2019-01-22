import {RegisterComponents} from './RegisterModuleTest.po';
import {browser} from 'protractor';

describe('--Przypadki testowe modułu rejestracji--', function () {

  let registerModule: RegisterComponents;

  beforeEach(() => {
    browser.get('/register');
    registerModule = new RegisterComponents();
  });

  describe('Kiedy formularz jest pusty', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta - zostajemy na stronie', function () {
      registerModule.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    })
  });

  describe('Kiedy formularz ma niepoprawny format maila (cos@cos.cos)', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta - zostajemy na stronie', function () {
      registerModule.getRegisterNameField().sendKeys('Name');
      registerModule.getRegisterLastNameField().sendKeys('LastName');
      registerModule.getRegisterMailField().sendKeys('mail');
      registerModule.getRegisterPasswordField().sendKeys('Password1234');
      registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
      registerModule.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    })
  });

  describe('Kiedy w formularzu brakuje jednego wypełnionego pola', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta - zostajemy na stronie', function () {
      registerModule.getRegisterNameField().sendKeys('Name');
      registerModule.getRegisterLastNameField().sendKeys('LastName');
      registerModule.getRegisterPasswordField().sendKeys('Password1234');
      registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
      registerModule.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    })
  });

  describe('Kiedy formularz ma krótkie hasło', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta - zostajemy na stronie', function () {
      registerModule.getRegisterNameField().sendKeys('Name');
      registerModule.getRegisterLastNameField().sendKeys('LastName');
      registerModule.getRegisterMailField().sendKeys('mail@mail.mail');
      registerModule.getRegisterPasswordField().sendKeys('Pass');
      registerModule.getRegisterRepeatPasswourdField().sendKeys('Pass');
      registerModule.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    })
  });

  describe('Kiedy w formularzu pozycja hasło i powtórz hasło są inne', function () {
    it('nie powinniśmy dostać potwierdzenia utworzenia konta - zostajemy na stronie', function () {
      registerModule.getRegisterNameField().sendKeys('Name');
      registerModule.getRegisterLastNameField().sendKeys('LastName');
      registerModule.getRegisterMailField().sendKeys('mail@mail.mail');
      registerModule.getRegisterPasswordField().sendKeys('Password1234');
      registerModule.getRegisterRepeatPasswourdField().sendKeys('Password12345');
      registerModule.getRegisterButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
    })
  });

  describe('Kiedy tworzymy konto a następnie próbujemy utworzyć konto o tym samym mailu', function () {
    describe('pierwsze konto', function () {
      it('zostaje utworzone i przechodzimy na strone glowna', function () {
        registerModule.getRegisterNameField().sendKeys('Name');
        registerModule.getRegisterLastNameField().sendKeys('LastName');
        registerModule.getRegisterMailField().sendKeys('mail@mail.mail');
        registerModule.getRegisterPasswordField().sendKeys('Password1234');
        registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
        registerModule.getRegisterButton().click();
        browser.sleep(5000);
        browser.switchTo().alert().accept();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
      })
    });
    describe('drugie konto', function () {
      it('nie zostaje utworzone - zostajemy na stronie', function () {
        browser.get('/register');
        registerModule.getRegisterNameField().sendKeys('Name');
        registerModule.getRegisterLastNameField().sendKeys('LastName');
        registerModule.getRegisterMailField().sendKeys('mail@mail.mail');
        registerModule.getRegisterPasswordField().sendKeys('Password1234');
        registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
        registerModule.getRegisterButton().click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
      })
    })
  });

  describe('Kiedy formularz ma wszystkie pola poprawnie wypełnione', function () {
    it('wyświetla się potwierdzenie utworzenia konta i przechodzimy na strone glowna', function () {
      registerModule.getRegisterNameField().sendKeys('Name');
      registerModule.getRegisterLastNameField().sendKeys('LastName');
      registerModule.getRegisterMailField().sendKeys('nowymail@mail.mail');
      registerModule.getRegisterPasswordField().sendKeys('Password1234');
      registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
      registerModule.getRegisterButton().click();
      browser.sleep(5000);
      browser.switchTo().alert().accept();
      browser.sleep(5000);
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    })
  });

});
