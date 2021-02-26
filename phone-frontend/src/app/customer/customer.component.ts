import { Component, OnInit, OnDestroy } from '@angular/core';
import { map, takeUntil } from 'rxjs/operators';
import { Subject, Subscription } from 'rxjs';
import { CustomerService } from './services/customer.service';
import { RequestPageCustomer } from './models/request.page.customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit, OnDestroy {

  destroyed$ = new Subject<void>();
  subscription = {} as Subscription;
  requestData = {} as RequestPageCustomer;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.requestData.code = '237';
    this.requestData.country = 'Cameroon';
    this.requestData.page = 0;
    this.requestData.size = 5;
    this.requestData.sortDir = 'asc';
    this.requestData.sort = 'name';

    this.initCustomers();
  }

  private initCustomers(): void {
    this.customerService.list(this.requestData).pipe(
      map(values => {
        console.log(this.customerService.pageResponse);
        console.log(values);
      }),
      takeUntil(this.destroyed$)
    ).subscribe();
  }

  ngOnDestroy(): void {
    this.destroyed$.unsubscribe;
  }

}
