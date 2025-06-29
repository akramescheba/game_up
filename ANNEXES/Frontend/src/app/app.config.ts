import { ApplicationConfig, importProvidersFrom ,provideZoneChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { providePrimeNG } from 'primeng/config';
import { provideToastr } from 'ngx-toastr';
import { provideRouter } from '@angular/router';
import { ToastModule } from 'primeng/toast'

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    importProvidersFrom(ToastModule),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideAnimations(),
    provideToastr(),
    provideHttpClient(),
    provideAnimationsAsync(),
    providePrimeNG({ ripple: true }),
  ],
};
