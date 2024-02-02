import { NgModule, CUSTOM_ELEMENTS_SCHEMA, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FaiComponent } from './fai/fai.component';
import { GuidelinesComponent } from './guidelines/guidelines.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SprComponent } from './spr/spr.component';
import { AllusersComponent } from './allusers/allusers.component';
import { LoggedComponent } from './logged/logged.component';
import { AfpComponent } from './afp/afp.component';
import { ProfileComponent } from './profile/profile.component';
import { authGuard } from './guards/auth.guard';
import { loginGuard } from './guards/login.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FacultyComponent } from './faculty/faculty.component';
import { AdminComponent } from './admin/admin.component';
import { roleguardGuard } from './guards/roleguard.guard';
import { AuthInterceptorInterceptor } from './interceptor/auth-interceptor.interceptor';
import { sprGuard } from './guards/spr.guard';
import { ProjectsComponent } from './projects/projects.component';
import { MatCardModule } from '@angular/material/card'
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    FaiComponent,
    GuidelinesComponent,
    SprComponent,
    AllusersComponent,
    LoggedComponent,
    AfpComponent,
    ProfileComponent,
    DashboardComponent,
    FacultyComponent,
    AdminComponent,
    ProjectsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    FormsModule,
    MatCardModule,
    RouterModule.forRoot([
      {path:"",component:HomeComponent},
      {path:"login",component:LoginComponent,canActivate:[loginGuard]},
      {path:"signup",component:RegisterComponent,canActivate:[loginGuard]},
      {path:"fai",component:FaiComponent},
      {path:"guidelines",component:GuidelinesComponent},
      {path:"spr",component:SprComponent,canActivate:[sprGuard]},
      {path:"allusers",component:AllusersComponent,canActivate:[authGuard]},
      // {path:"logged",component:LoggedComponent},
      {path:"afp",component:AfpComponent,canActivate:[authGuard] },
      {path:"profile",component:ProfileComponent,canActivate:[authGuard]},
      {path:"dashboard",component:DashboardComponent,canActivate:[roleguardGuard],data:{role:'student'}},
      {path:"faculty",component:FacultyComponent,canActivate:[roleguardGuard],data:{role:'teacher'}},
      {path:"admin",component:AdminComponent,canActivate:[roleguardGuard],data:{role:'admin'}},
      {path:"projects",component:ProjectsComponent,canActivate:[roleguardGuard],data:{role:'teacher'}}
    ])
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptorInterceptor,multi:true}],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
