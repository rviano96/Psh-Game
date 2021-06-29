import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-picture',
  templateUrl: './picture.component.html',
  styleUrls: ['./picture.component.scss']
})
export class PictureComponent implements OnInit {
  @Input() url: String;
  constructor() {
    this.url="assets/img/user.svg"
   }

  ngOnInit(): void {
  }

}
