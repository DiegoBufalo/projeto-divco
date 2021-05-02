import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioDetailsComponent } from './usuario-details.component';

describe('UsuarioDetailsComponent', () => {
  let component: UsuarioDetailsComponent;
  let fixture: ComponentFixture<UsuarioDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
