import { RequestCustomerSerializer } from '../models/request.customer.serializer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IRequestCustomer } from '../models/request.customer';
import { ResourceService } from '../../common/services/resource.service';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService extends ResourceService<IRequestCustomer> {

  constructor(httpClient: HttpClient) {
    super(
      httpClient,
      environment.BASE_URL,
      environment.CUSTOMER_ENDPOINT,
      new RequestCustomerSerializer(),
      'Request Customer'
    );
  }
}