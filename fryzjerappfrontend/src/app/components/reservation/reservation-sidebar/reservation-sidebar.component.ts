import { Component, OnInit } from '@angular/core';
import {Serv} from "../../price-list/services";
import {UtilityService} from "../../../services/utility.service";

@Component({
  selector: 'app-reservation-sidebar',
  templateUrl: './reservation-sidebar.component.html',
  styleUrls: ['./reservation-sidebar.component.css']
})
export class ReservationSidebarComponent implements OnInit {

  public chosenService: Serv;
  public services: Serv[];

  constructor(private utilityService: UtilityService) { }

  private fetchServices(): void {
    this.utilityService.getServices().subscribe(
      (respons: Serv[]) => {
        this.services = respons;
      }
    )
  }

  public serviceSelect(): void {
    console.log(this.chosenService);
  }

  ngOnInit() {
    this.fetchServices();
  }

}
