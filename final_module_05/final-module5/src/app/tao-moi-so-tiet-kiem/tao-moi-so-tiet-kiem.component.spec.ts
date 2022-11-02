import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaoMoiSoTietKiemComponent } from './tao-moi-so-tiet-kiem.component';

describe('TaoMoiSoTietKiemComponent', () => {
  let component: TaoMoiSoTietKiemComponent;
  let fixture: ComponentFixture<TaoMoiSoTietKiemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaoMoiSoTietKiemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaoMoiSoTietKiemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
