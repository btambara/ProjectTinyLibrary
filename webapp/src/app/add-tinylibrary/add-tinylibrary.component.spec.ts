import{async, ComponentFixture, TestBed}from '@angular/core/testing';

import {AddTinylibraryComponent} from './add-tinylibrary.component';

describe('AddTinylibraryComponent', () => {
  let component: AddTinylibraryComponent;
  let fixture: ComponentFixture<AddTinylibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTinylibraryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTinylibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
