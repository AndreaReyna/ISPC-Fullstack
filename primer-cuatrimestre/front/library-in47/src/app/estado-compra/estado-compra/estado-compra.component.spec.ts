import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoCompraComponent } from './estado-compra.component';

describe('EstadoCompraComponent', () => {
  let component: EstadoCompraComponent;
  let fixture: ComponentFixture<EstadoCompraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstadoCompraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstadoCompraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
