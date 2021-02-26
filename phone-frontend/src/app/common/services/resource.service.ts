import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UnknownError } from '../errors/unknown.error';
import { NotFoundError } from '../errors/not-found.error';
import { BadRequestError } from '../errors/bad-request.error';
import { Resource } from '../models/resource';
import { map, retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { BaseSerializer } from '../models/base.serializer';
import { BasePageRequest } from '../models/base.page.request';
import { BaseResponse } from '../models/base.response';

@Injectable({
  providedIn: 'root'
})
export abstract class ResourceService<T extends Resource> {

  pageResponse= {} as BaseResponse;

  constructor(private httpClient: HttpClient,
    @Inject(String) private url: string,
    @Inject(String) private endpoint: string,
    @Inject(String) private serializer: BaseSerializer,
    @Inject(String) private pageSerializer: BaseSerializer,
    @Inject(String) private resourceName: string) { }

  /**
   * Get generic object list from API by ID.
   */
  list(requestData: BasePageRequest): Observable<T[]> {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      })
    };

    return this.httpClient
      .post(`${this.url}/${this.endpoint}/get/all`, requestData, httpOptions)
      .pipe(
        map((data: any) => {
          this.pageResponse = this.pageSerializer.fromJson(data);
          return this.convertData(data.dataPage.content)
        }),
        retry(1),
        catchError(this.handleError),
      );
  }

  getPageResponse() {
    return this.pageResponse;
  }

  /**
   * Convert object to serialize.
   * @param data any
   */
  private convertData(data: any): T[] {
    return data.map((item: any) => this.serializer.fromJson(item));
  }

  /**
   * Handle errors from API calling.
   * @param error handleError
   */
  private handleError(error: Response): Observable<T[]> {
    if (error.status === 404) {
      return throwError(new NotFoundError(error, this.resourceName));
    }

    if (error.status === 400) {
      return throwError(new BadRequestError(error, this.resourceName));
    }

    return throwError(new UnknownError(error));
  }
}