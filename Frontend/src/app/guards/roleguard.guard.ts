import { CanActivateFn,Router} from '@angular/router';
import { inject } from '@angular/core';
import { AuthserviceService } from '../service/authservice.service';
export const roleguardGuard: CanActivateFn = (route, state) => {
  const router=inject(Router);
  const authservice=inject(AuthserviceService)
  if(authservice.getToken()!==null){
    const expectedRole = route.data['role'];
    if(authservice.roleMatch(expectedRole)){
      return true;
    }
    // if (expectedRole === 'student') {
    //   router.navigate(['/dashboard']);
    // } else if (expectedRole === 'teacher') {
    //   router.navigate(['/faculty']);
    // } else {
    //   router.navigate(['/admin']);
    // }
    const currentRole = authservice.getRole();
    if (currentRole === 'student') {
      router.navigate(['/dashboard']);
    } else if (currentRole === 'teacher') {
      router.navigate(['/faculty']);
    } else {
      router.navigate(['/admin']);
    }
    // router.navigate(['']);
    return false; 
  }
  router.navigate(['/login']);
  return false;
};
