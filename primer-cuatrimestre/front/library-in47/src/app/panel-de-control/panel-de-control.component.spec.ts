import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelDeControlComponent } from './panel-de-control.component';

describe('PanelDeControlComponent', () => {
  let component: PanelDeControlComponent;
  let fixture: ComponentFixture<PanelDeControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelDeControlComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PanelDeControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
