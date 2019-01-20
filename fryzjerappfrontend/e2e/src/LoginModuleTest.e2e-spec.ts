import {LoginComponents} from './LoginModuleTest.po';
import {RegisterComponents} from "./RegisterModuleTest.po";
import {browser} from 'protractor';


describe('W celu pomocniczym', function () {

  let registerModule = new RegisterComponents();

  beforeEach(() => {
    registerModule = new RegisterComponents();
    browser.get('/register');
  });

  it('tworzymy konto w bazie', function () {
    registerModule.getRegisterNameField().sendKeys('Name');
    registerModule.getRegisterLastNameField().sendKeys('LastName');
    registerModule.getRegisterMailField().sendKeys('mail@mail.mail');
    registerModule.getRegisterPasswordField().sendKeys('Password1234');
    registerModule.getRegisterRepeatPasswourdField().sendKeys('Password1234');
    registerModule.getRegisterButton().click();
    browser.sleep(5000);
    browser.switchTo().alert().accept();
    browser.sleep(2000);
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
  })
});

describe('--Przypadki testowe modułu logowania--', function () {

  let loginModule: LoginComponents;

  beforeEach(() => {
    loginModule = new LoginComponents();
    browser.get('/');
  });
  describe('Kiedy wpiszemy tylko maila', function () {
    it('nie powinniśmy się zalogować - zostajemy na stronie', function () {
      loginModule.getLoginMailField().sendKeys('mail@mail.mail');
      loginModule.getLoginButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    })
  });

  describe('Kiedy wpiszemy złe hasło', function () {
    it('nie powinniśmy się zalogować - zostajemy na stronie', function () {
      loginModule.getLoginMailField().sendKeys('mail@mail.mail');
      loginModule.getLoginPasswordField().sendKeys('Password7890');
      loginModule.getLoginButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    })
  });

  describe('Kiedy wpiszemy zły mail', function () {
    it('nie powinniśmy się zalogować - zostajemy na stronie', function () {
      loginModule.getLoginMailField().sendKeys('mail@mail.pl');
      loginModule.getLoginPasswordField().sendKeys('Password7890');
      loginModule.getLoginButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    })
  });

  describe('Kiedy zostawimy puste pola', function () {
    it('nie powinniśmy się zalogować - zostajemy na stronie', function () {
      loginModule.getLoginButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/');
    })
  });

  describe('Kiedy wpiszemy poprawne dane', function () {
    it('powinniśmy się zalogować - zostajemy przekierowani na inną stronę', function () {
      loginModule.getLoginMailField().sendKeys('mail@mail.mail');
      loginModule.getLoginPasswordField().sendKeys('Password1234');
      loginModule.getLoginButton().click();
      expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/priceList');
    })
  });

});


