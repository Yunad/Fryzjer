import {Component, OnInit} from '@angular/core';
import {ListemployeeService} from "../../services/listemployee.service";
import {Employee} from "./employe";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})


export class EmployeeComponent implements OnInit {

  employee: Employee[];

  constructor(private listEmployeeService: ListemployeeService) {
  }

  private fetchEmployee(): void {
    this.listEmployeeService.getEmploye().subscribe(
      (resp: Employee[]) => {
        this.employee = resp;
      }
    );
  }

  ngOnInit() {

    this.fetchEmployee();
  }

}
