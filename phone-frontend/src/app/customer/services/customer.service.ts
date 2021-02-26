import { CustomerSerializer } from '../models/response.customer.serializer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICustomer } from '../models/customer.interface';
import { ResourceService } from '../../common/services/resource.service';
import { environment } from '../../../environments/environment';
import { ResponsePageCustomerSerializer } from '../models/response.page.customer.serializer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService extends ResourceService<ICustomer> {

  constructor(httpClient: HttpClient) {
    super(
      httpClient,
      environment.BASE_URL,
      environment.CUSTOMER_ENDPOINT,
      new CustomerSerializer(),
      new ResponsePageCustomerSerializer,
      'Request Customer'
    );
  }
}