import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsDeleteComponentComponent } from './cars-delete-component.component';

describe('CarsDeleteComponentComponent', () => {
  let component: CarsDeleteComponentComponent;
  let fixture: ComponentFixture<CarsDeleteComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarsDeleteComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsDeleteComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
