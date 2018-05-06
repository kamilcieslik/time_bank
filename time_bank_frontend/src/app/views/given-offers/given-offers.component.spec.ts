import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GivenOffersComponent } from './given-offers.component';

describe('GivenOffersComponent', () => {
  let component: GivenOffersComponent;
  let fixture: ComponentFixture<GivenOffersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GivenOffersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GivenOffersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
