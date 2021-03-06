import { AppError } from './app.error';

export class NotFoundError extends AppError {
  constructor(error?: any, resourceName?: string) {
    super(error, resourceName);

    this.description = `The ${resourceName} you are looking at not exist...`;
    this.errorNumber = 404;
  }
}