import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicDeleteComponentComponent } from './mechanic-delete-component.component';

describe('MechanicDeleteComponentComponent', () => {
  let component: MechanicDeleteComponentComponent;
  let fixture: ComponentFixture<MechanicDeleteComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicDeleteComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicDeleteComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
