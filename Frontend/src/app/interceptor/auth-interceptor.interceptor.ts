import { Injectable } from '@angular/core';
import {HttpErrorResponse ,HttpRequest ,HttpHandler ,HttpEvent ,HttpInterceptor} from '@angular/common/http';
import { Observable, catchError, throwError  } from 'rxjs';
import { AuthserviceService } from '../service/authservice.service';


@Injectable()
export class AuthInterceptorInterceptor implements HttpInterceptor {

  constructor(private user:AuthserviceService) {}

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.url.includes('/create')) {
      return next.handle(req);
    }
    if (req.url.includes('/login')) {
      return next.handle(req);
    }
    if (req.url.includes('/update/')) {
      return next.handle(req);
    }
    let token=this.user.getToken();
    let tokenheader=req.clone({
      setHeaders:{Authorization:`Bearer ${token}`}
    });
    return next.handle(tokenheader)
    .pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401 || error.status === 403 || error.status === 500) {
          this.user.logout(); // Call the logout method when the token is expired or invalid
        }
        return throwError(error);
      })
    );
  }
}
