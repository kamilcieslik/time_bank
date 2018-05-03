import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListElemEventComponent } from './list-elem-event.component';

describe('ListElemEventComponent', () => {
  let component: ListElemEventComponent;
  let fixture: ComponentFixture<ListElemEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListElemEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListElemEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
