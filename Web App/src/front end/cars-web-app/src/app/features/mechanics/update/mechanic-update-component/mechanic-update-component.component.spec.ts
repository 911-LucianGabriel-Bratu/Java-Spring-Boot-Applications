import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicUpdateComponentComponent } from './mechanic-update-component.component';

describe('MechanicUpdateComponentComponent', () => {
  let component: MechanicUpdateComponentComponent;
  let fixture: ComponentFixture<MechanicUpdateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicUpdateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicUpdateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
