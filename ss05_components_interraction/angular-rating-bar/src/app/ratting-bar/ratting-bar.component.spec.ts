import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RattingBarComponent } from './ratting-bar.component';

describe('RattingBarComponent', () => {
  let component: RattingBarComponent;
  let fixture: ComponentFixture<RattingBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RattingBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RattingBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
