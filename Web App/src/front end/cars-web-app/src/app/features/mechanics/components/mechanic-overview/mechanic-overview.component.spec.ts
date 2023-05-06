import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicOverviewComponent } from './mechanic-overview.component';

describe('MechanicOverviewComponent', () => {
  let component: MechanicOverviewComponent;
  let fixture: ComponentFixture<MechanicOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
