import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { SupportHub } from './pages/support/support-hub/support-hub';
import { CompassSupport } from './pages/support/compass/compass';
import { CompassSoftware } from './pages/support/compass-software/compass-software';
import { SmoothShotSupport } from './pages/support/smooth-shot/smooth-shot';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'support', component: SupportHub },
  { path: 'support/compass', component: CompassSupport },
  { path: 'support/compass/software', component: CompassSoftware },
  { path: 'support/smooth-shot', component: SmoothShotSupport },
];
