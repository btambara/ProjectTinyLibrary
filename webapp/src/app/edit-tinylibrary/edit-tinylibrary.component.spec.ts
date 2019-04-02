import{async, ComponentFixture, TestBed}from '@angular/core/testing';

import {EditTinylibraryComponent} from './edit-tinylibrary.component';

describe('EditTinylibraryComponent', () => {
  let component: EditTinylibraryComponent;
  let fixture: ComponentFixture<EditTinylibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTinylibraryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTinylibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
