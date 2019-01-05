import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import {RouterModule, Routes} from "@angular/router";
import { RegisterComponent } from './components/register/register.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HomePageComponent } from './components/homepage/homepage.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { FooterComponent } from './components/footer/footer.component';
import { PriceListComponent } from './components/price-list/price-list.component';
import { ReminderComponent } from './components/reminder/reminder.component';
import {UserService} from "./services/user.service";
import {HttpClientModule} from "@angular/common/http";
import {UtilityService} from "./services/utility.service";
import { ReservationComponent } from './components/reservation/reservation.component';
import { ReservationSidebarComponent } from './components/reservation/reservation-sidebar/reservation-sidebar.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'priceList', component: PriceListComponent},
  { path: 'reminder', component: ReminderComponent},
  { path: 'reservation', component: ReservationComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomePageComponent,
    HeaderComponent,
    MenuComponent,
    CarouselComponent,
    FooterComponent,
    PriceListComponent,
    ReminderComponent,
    ReservationComponent,
    ReservationSidebarComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    UserService,
    UtilityService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
