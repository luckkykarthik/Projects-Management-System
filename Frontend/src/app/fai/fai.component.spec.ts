import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FaiComponent } from './fai.component';

describe('FaiComponent', () => {
  let component: FaiComponent;
  let fixture: ComponentFixture<FaiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FaiComponent]
    });
    fixture = TestBed.createComponent(FaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
