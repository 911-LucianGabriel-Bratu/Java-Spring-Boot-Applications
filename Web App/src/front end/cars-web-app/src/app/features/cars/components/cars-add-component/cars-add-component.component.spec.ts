import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsAddComponentComponent } from './cars-add-component.component';

describe('CarsAddComponentComponent', () => {
  let component: CarsAddComponentComponent;
  let fixture: ComponentFixture<CarsAddComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarsAddComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsAddComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
