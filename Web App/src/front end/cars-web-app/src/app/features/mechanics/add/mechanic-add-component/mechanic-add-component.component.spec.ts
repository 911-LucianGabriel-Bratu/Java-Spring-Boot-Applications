import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicAddComponentComponent } from './mechanic-add-component.component';

describe('MechanicAddComponentComponent', () => {
  let component: MechanicAddComponentComponent;
  let fixture: ComponentFixture<MechanicAddComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicAddComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicAddComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
