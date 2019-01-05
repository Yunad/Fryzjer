import {Component, OnInit} from '@angular/core';
import {SERV} from "./services";
import {Serv} from "./services";
import {UtilityService} from "../../services/utility.service";

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.scss']
})
export class PriceListComponent implements OnInit {

  services: Serv[];
  selectedServ: Serv;

  constructor(private utilityService: UtilityService) {
  }

  onSelect(serv: Serv): void {
    this.selectedServ = serv;
  }

  private fetchServices(): void {
    this.utilityService.getServices().subscribe(
      (resp: Serv[]) => {
        this.services = resp;
      }
    );
  }


  ngOnInit() {
    this.fetchServices();
  }
}
