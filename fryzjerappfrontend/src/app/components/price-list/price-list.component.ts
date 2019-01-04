import { Component, OnInit } from '@angular/core';
import { SERV} from "./services";
import  {Serv} from "./services";

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.scss']
})
export class PriceListComponent implements OnInit {

  services = SERV;

  selectedServ: Serv;
  onSelect(serv: Serv):void {
    this.selectedServ = serv;
  }

  constructor() { }

  ngOnInit() {
  }

}
