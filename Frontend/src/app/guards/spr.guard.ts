import { CanActivateFn,Router } from '@angular/router';
import { inject } from '@angular/core';
import { AuthserviceService } from '../service/authservice.service';

export const sprGuard: CanActivateFn = (route, state) => {
  const router=inject(Router);
  const authservice=inject(AuthserviceService)
  const userRole = authservice.getRole();
  if (userRole === 'student') {
    return true; 
  } else {
    router.navigate(['']);
    return false;
  }
}
