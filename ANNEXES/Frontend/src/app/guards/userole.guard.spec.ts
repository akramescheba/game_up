import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { useroleGuard } from './userole.guard';

describe('useroleGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => useroleGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
