import{TestBed}from'@angular/core/testing';

import {TinyLibraryService}from './tinylibrary.service';

describe('TinylibraryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TinyLibraryService = TestBed.get(TinyLibraryService);
    expect(service).toBeTruthy();
  });
});
