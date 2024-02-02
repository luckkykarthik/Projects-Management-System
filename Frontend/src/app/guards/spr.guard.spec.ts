import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { sprGuard } from './spr.guard';

describe('sprGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => sprGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
