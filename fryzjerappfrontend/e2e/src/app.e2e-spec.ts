import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('Wyświetla napis Zaloguj się na stronie głównej', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Zaloguj się!!!');
  });

  it('Wyświetla przycisk Home', () => {
    page.navigateTo();
    expect(page.getHomeButton().getText()).toEqual('Home');
  });

  it('Po naciśnięciu przycisku Home wyświetla stronę główną ', () => {
    page.navigateTo();
    page.getHomeButton().click();
    expect(browser.getCurrentUrl()).toEqual("http://localhost:4200/");
  });

  it('Wyświetla przycisk Login', () => {
    page.navigateTo();
    expect(page.getLoginButton().getText()).toEqual('Login');
  });

  it('Po naciśnięciu przycisku Login wyświetla stonę logowania', () => {
    page.navigateTo();
    page.getLoginButton().click();
    expect(browser.getCurrentUrl()).toEqual("http://localhost:4200/login");
  });

  it('Wyświetla przycisk Register', () => {
    page.navigateTo();
    expect(page.getRegisterButton().getText()).toEqual('Register');
  });

  it('Po naciśnięciu przycisku Register wyświetla stronę rejestracji', () => {
    page.navigateTo();
    page.getRegisterButton().click();
    expect(browser.getCurrentUrl()).toEqual("http://localhost:4200/register");
  });

  it('Wyświetla stronę Register - napis Zarejestruj się', () => {
    page.navigateTo();
    page.getRegisterButton().click();
    expect(page.getRegisterName().getText()).toEqual('Zarejestruj się');
  });


  it('Wyświetla przycisk Cennik', () => {
    page.navigateTo();
    expect(page.getPriceButton().getText()).toEqual('Cennik');
  });

  it('Po naciśnięciu przycisku Cennik wyświetla usługi fryzjerskie', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect(browser.getCurrentUrl()).toEqual("http://localhost:4200/priceList");
  });

  it('Wyświetla stronę z cennikiem - napis Nasze usługi fryzjerskie', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect(page.getPriceListName().getText()).toEqual('Nasze usługi fryzjerskie');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Strzyżenie męskie', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList1().getText()).toEqual('Strzyżenie męskie');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Strzyżenie damskie', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList2().getText()).toEqual('Strzyżenie damskie');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Farbowanie włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList3().getText()).toEqual('Farbowanie włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Klasyczna koloryzacja włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList4().getText()).toEqual('Klasyczne koloryzacja włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Balayage', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList5().getText()).toEqual('Balayage');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Dekoloryzacja włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList6().getText()).toEqual('Dekoloryzacja włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Strzyżenie grzywki', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList7().getText()).toEqual('Strzyżenie grzywki');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Modelowanie włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList8().getText()).toEqual('Modelowanie włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Pielęgnacja włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList9().getText()).toEqual('Pielęgnacja włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Przedłuzanie włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList10().getText()).toEqual('Przedłużanie włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Zagęszczanie włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList11().getText()).toEqual('Zagęszczanie włosów');
  });

  it('Wyświetla stronę z cennikiem - tabela z usługą Doczepianie włosów', () => {
    page.navigateTo();
    page.getPriceButton().click();
    expect (page.getPriceList12().getText()).toEqual('Doczepianie włosów');
  });

  it('Wyświetla przycisk Zaloguj - okno logowania', () => {
    page.navigateTo();
    expect(page.getLogin2Button().getText()).toEqual('Zaloguj');
  });

  it('Wyświetla przycisk Załóż konto - okno logowania', () => {
    page.navigateTo();
    expect(page.getCreateAccountButton().getText()).toEqual('Załóż konto');
  });

  it('Wyświetla link Zapomniałem hasła', () => {
    page.navigateTo();
    expect(page.getForgettenPasswordLink().getText()).toEqual('Zapomniałem hasła');
  });

});
