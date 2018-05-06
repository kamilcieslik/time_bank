import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TakenOffersComponent } from './taken-offers.component';

describe('TakenOffersComponent', () => {
  let component: TakenOffersComponent;
  let fixture: ComponentFixture<TakenOffersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TakenOffersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TakenOffersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
