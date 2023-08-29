import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterControlPanelComponent } from './footer-control-panel.component';

describe('FooterControlPanelComponent', () => {
  let component: FooterControlPanelComponent;
  let fixture: ComponentFixture<FooterControlPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FooterControlPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FooterControlPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
