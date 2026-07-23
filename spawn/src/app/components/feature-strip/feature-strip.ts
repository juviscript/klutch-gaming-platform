import { Component } from '@angular/core';
import { Icon, IconName } from '../icon/icon';

interface Feature {
  icon: IconName;
  title: string;
  description: string;
}

@Component({
  selector: 'app-feature-strip',
  imports: [Icon],
  templateUrl: './feature-strip.html',
})
export class FeatureStrip {
  readonly features: Feature[] = [
    { icon: 'crosshair', title: 'Precision Control', description: 'Smooth, responsive movement you can trust.' },
    { icon: 'person', title: 'Ergonomic Design', description: 'Built for comfort during long gaming sessions.' },
    { icon: 'box', title: 'Built to Last', description: 'Premium materials. Rigorously tested.' },
    { icon: 'map-pin', title: 'Designed in Florida', description: 'Proudly designed and made in the USA.' },
  ];
}
