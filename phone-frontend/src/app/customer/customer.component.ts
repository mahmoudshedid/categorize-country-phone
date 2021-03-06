import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { map, takeUntil } from 'rxjs/operators';
import { Subject, Subscription } from 'rxjs';
import { CustomerService } from './services/customer.service';
import { RequestPageCustomer } from './models/request.page.customer';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ICustomer } from './models/customer.interface';
import { MatTableDataSource } from '@angular/material/table';
import { ICountry } from './models/country.interface';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})

export class CustomerComponent implements OnInit, OnDestroy {

  @ViewChild(MatPaginator) paginator = {} as MatPaginator;
  @ViewChild(MatSort) sort = {} as MatSort;

  displayedColumns: string[] = ['id', 'name', 'phone', 'phoneValid'];

  countries: ICountry[] = [
    {id: 0, country: 'Cameroon', code: '237'},
    {id: 1, country: 'Ethiopia', code: '251'},
    {id: 2, country: 'Morocco', code: '212'},
    {id: 3, country: 'Mozambique', code: '258'},
    {id: 4, country: 'Uganda', code: '256'},
  ];

  destroyed$ = new Subject<void>();
  subscription = {} as Subscription;
  requestData = {} as RequestPageCustomer;
  dataSource!: MatTableDataSource<ICustomer>;

  resultsLength = 0;
  isLoadingResults = true;
  defaultSelectedOption = 0;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.requestData.code = this.countries[0].code;
    this.requestData.country = this.countries[0].country;
    this.requestData.page = 0;
    this.requestData.size = 5;
    this.requestData.sortDir = 'asc';
    this.requestData.sort = 'name';

    this.getCustomers();
  }

  private getCustomers(): void  {
    this.customerService.list(this.requestData).pipe(
      map(values => {
        this.isLoadingResults = false;
        this.dataSource = new MatTableDataSource<ICustomer>(values);
        this.dataSource.paginator = this.paginator;
        this.setPageData();
      }),
      takeUntil(this.destroyed$)
    ).subscribe();
  }

  private setPageData(): void {
    console.log(this.customerService.pageResponse);
  }

  countryOnChange(value: number): void {
    this.requestData.code = this.countries[value].code;
    this.requestData.country = this.countries[value].country;
    this.isLoadingResults = true;
    this.getCustomers();
  }

  ngOnDestroy(): void {
    this.destroyed$.unsubscribe;
  }

}
