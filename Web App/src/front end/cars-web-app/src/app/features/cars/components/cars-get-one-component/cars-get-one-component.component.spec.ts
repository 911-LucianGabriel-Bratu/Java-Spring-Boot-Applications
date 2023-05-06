import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsGetOneComponentComponent } from './cars-get-one-component.component';

describe('CarsGetOneComponentComponent', () => {
  let component: CarsGetOneComponentComponent;
  let fixture: ComponentFixture<CarsGetOneComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarsGetOneComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsGetOneComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
