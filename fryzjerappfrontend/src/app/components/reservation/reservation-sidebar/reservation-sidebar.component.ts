import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Service} from '../../price-list/services';
import {Permission} from "./permissions";
import {UtilityService} from '../../../services/utility.service';
import { PermissionService} from "../../../services/permission.service";
import {IMyDpOptions, IMyDate, IMyDateModel} from 'mydatepicker';
import * as moment from 'moment';
import {Moment} from 'moment';

@Component({
  selector: 'app-reservation-sidebar',
  templateUrl: './reservation-sidebar.component.html',
  styleUrls: ['./reservation-sidebar.component.css']
})
export class ReservationSidebarComponent implements OnInit {

  @Input() test;
  @Output() selectedService: EventEmitter<Service> = new EventEmitter<Service>();
  @Output() selectedDay: EventEmitter<IMyDateModel> = new EventEmitter<IMyDateModel>();

  public today: Moment = moment();
  public disableUntilDate = moment().add(-2, "days");
  public initialDate: IMyDate = {year: this.today.year(), month: this.today.month() + 1, day: this.today.day()};

  public myDatePickerOptions: IMyDpOptions = {
    showInputField: false,
    inline: true,
    disableUntil: {
      year: this.disableUntilDate.year(),
      month: this.disableUntilDate.month() + 1,
      day: this.disableUntilDate.day()
    },
    dateFormat: 'dd.mm.yyyy',
  };

  public selectedDate: any = {date: this.initialDate};

  public chosenService: Service;
  public services: Service[];
  public permission: Permission[];

  constructor(private utilityService: UtilityService, private permissionsService: PermissionService) {
  }

  private fetchServices(): void {
    this.utilityService.getServices().subscribe(
      (respons: Service[]) => {
        this.services = respons;
      }
    )
  }

  private fetchPermissions(): void {
    this.permissionsService.getPermissions().subscribe(
      (resp: Permission[]) => {
        this.permission = resp;
      }
    )
  }
  public serviceSelect(): void {
    this.selectedService.emit(this.chosenService);
  }

  onDateChanged(event: IMyDateModel) {
    this.selectedDay.emit(event);
  }

  ngOnInit() {
    this.fetchServices();
    this.fetchPermissions();
    console.log(this.today);
    console.log(this.disableUntilDate);
  }

}
