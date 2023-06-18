import { Component, OnInit } from '@angular/core';
import { trigger, state, transition, style, animate} from '@angular/animations'
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  animations: [
    trigger('fadeInModal', [
      state('void', style({
        opacity: 0
      })),
      state('*', style({
        opacity: 1
      })),
      transition('void <=> *', animate('300ms ease-in-out'))
    ])
  ]
})
export class UserComponent{
  constructor() { }

}
