import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioQueueComponent } from './usuario-queue.component';

describe('UsuarioQueueComponent', () => {
  let component: UsuarioQueueComponent;
  let fixture: ComponentFixture<UsuarioQueueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioQueueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioQueueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
