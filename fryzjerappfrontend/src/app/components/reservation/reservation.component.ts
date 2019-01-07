import { Component, OnInit } from '@angular/core';
import {Serv} from "../price-list/services";
import {IMyDateModel} from 'mydatepicker';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  public service: Serv;
  public date: IMyDateModel;

  constructor() { }

  public onServiceSelect(service: Serv): void {
    this.service = service;
    this.fetchAppointments();
  }

  public onDaySelect(date: IMyDateModel): void {
    this.date = date;
    this.fetchAppointments()
  }

  public fetchAppointments(): void {
    // fetch appointments
  }

  ngOnInit() {
  }

}
