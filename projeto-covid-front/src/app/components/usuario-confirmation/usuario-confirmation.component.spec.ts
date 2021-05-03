import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioConfirmationComponent } from './usuario-confirmation.component';

describe('UsuarioConfirmationComponent', () => {
  let component: UsuarioConfirmationComponent;
  let fixture: ComponentFixture<UsuarioConfirmationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioConfirmationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioConfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
