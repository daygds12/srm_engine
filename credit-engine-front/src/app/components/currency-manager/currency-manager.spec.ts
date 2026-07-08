import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrencyManager } from './currency-manager';

describe('CurrencyManager', () => {
  let component: CurrencyManager;
  let fixture: ComponentFixture<CurrencyManager>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurrencyManager],
    }).compileComponents();

    fixture = TestBed.createComponent(CurrencyManager);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
