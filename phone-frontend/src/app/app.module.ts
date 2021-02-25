import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ErrorHandler } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomErrorHandler } from './common/errors/custom-error.handler'
import { CustomerComponent } from './customer/customer.component';
import { CustomerService } from './customer/services/customer.service';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,
    HttpClientModule
  ],
  providers: [
    Title,
    CustomerService,
    {provide: ErrorHandler, useClass: CustomErrorHandler}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
