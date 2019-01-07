import {Component, OnInit} from '@angular/core';
import {Service} from './services';
import {UtilityService} from '../../services/utility.service';

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.scss']
})
export class PriceListComponent implements OnInit {

  services: Service[];
  selectedService: Service;

  constructor(private utilityService: UtilityService) {
  }

  onSelect(serv: Service): void {
    this.selectedService = serv;
  }

  private fetchServices(): void {
    this.utilityService.getServices().subscribe(
      (resp: Service[]) => {
        this.services = resp;
      }
    );
  }


  ngOnInit() {
    this.fetchServices();
  }
}
