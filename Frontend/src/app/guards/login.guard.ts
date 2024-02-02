import { CanActivateFn ,Router} from '@angular/router';
import { inject } from '@angular/core';
 
export const loginGuard: CanActivateFn = (route, state) => {
  const token=localStorage.getItem("token");
  const router=inject(Router);
  if (token) {
    router.navigate(['/profile']); // Update to the desired route for the homepage
    return false;
  }
  return true;
};
