import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiveOfferComponent } from './receive-offer.component';

describe('ReceiveOfferComponent', () => {
  let component: ReceiveOfferComponent;
  let fixture: ComponentFixture<ReceiveOfferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiveOfferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiveOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
