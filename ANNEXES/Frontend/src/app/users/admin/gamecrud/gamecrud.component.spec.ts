import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GamecrudComponent } from './gamecrud.component';

describe('GamecrudComponent', () => {
  let component: GamecrudComponent;
  let fixture: ComponentFixture<GamecrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GamecrudComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GamecrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
