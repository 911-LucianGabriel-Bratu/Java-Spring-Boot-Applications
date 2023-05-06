import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicGetOneComponentComponent } from './mechanic-get-one-component.component';

describe('MechanicGetOneComponentComponent', () => {
  let component: MechanicGetOneComponentComponent;
  let fixture: ComponentFixture<MechanicGetOneComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicGetOneComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicGetOneComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
