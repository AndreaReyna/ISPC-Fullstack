import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavBarControlPanelComponent } from './nav-bar-control-panel.component';

describe('NavBarControlPanelComponent', () => {
  let component: NavBarControlPanelComponent;
  let fixture: ComponentFixture<NavBarControlPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavBarControlPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavBarControlPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
