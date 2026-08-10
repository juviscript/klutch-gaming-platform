import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { SupportHub } from './pages/support/support-hub/support-hub';
import { CompassSoftware } from './pages/support/compass-software/compass-software';
import { SmoothShotSupport } from './pages/support/smooth-shot/smooth-shot';
import { ProductCompass } from './pages/products/compass/compass';
import { ProductSmoothShot } from './pages/products/smooth-shot/smooth-shot';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'products/compass', component: ProductCompass },
  { path: 'products/smooth-shot', component: ProductSmoothShot },
  { path: 'support', component: SupportHub },
  { path: 'support/compass/software', component: CompassSoftware },
  { path: 'support/smooth-shot', component: SmoothShotSupport },
];
