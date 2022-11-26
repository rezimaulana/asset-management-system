import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRouting } from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FilterTokenInterceptor } from './filter/filter-token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule, FormsModule, AppRouting,
    ToastrModule.forRoot(), BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    {provide : HTTP_INTERCEPTORS, useClass : FilterTokenInterceptor, multi : true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
