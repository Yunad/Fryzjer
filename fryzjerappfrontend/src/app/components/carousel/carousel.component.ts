import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  images = [
    "/assets/img/img1.jpg",
    "/assets/img/img2.jpg",
  ];

  constructor() { }

  ngOnInit() {
  }

}
