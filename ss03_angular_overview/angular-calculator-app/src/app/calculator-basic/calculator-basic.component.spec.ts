import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatorBasicComponent } from './calculator-basic.component';

describe('CalculatorBasicComponent', () => {
  let component: CalculatorBasicComponent;
  let fixture: ComponentFixture<CalculatorBasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalculatorBasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
