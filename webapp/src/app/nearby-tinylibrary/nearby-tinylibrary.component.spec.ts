import{async, ComponentFixture, TestBed}from '@angular/core/testing';

import {NearbyTinylibraryComponent} from './nearby-tinylibrary.component';

describe('NearbyTinylibraryComponent', () => {
  let component: NearbyTinylibraryComponent;
  let fixture: ComponentFixture<NearbyTinylibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NearbyTinylibraryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NearbyTinylibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
