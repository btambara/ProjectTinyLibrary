import{async, ComponentFixture, TestBed}from '@angular/core/testing';

import {TinylibraryComponent} from './tinylibrary.component';

describe('TinylibraryComponent', () => {
  let component: TinylibraryComponent;
  let fixture: ComponentFixture<TinylibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TinylibraryComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TinylibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
