import { TestBed } from '@angular/core/testing';

import { MechanicsServiceService } from './mechanics-service.service';

describe('MechanicsServiceService', () => {
  let service: MechanicsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MechanicsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
