import { Component } from '@angular/core';
import { Icon } from '../icon/icon';
import { FeatureStrip } from '../feature-strip/feature-strip';

@Component({
  selector: 'app-hero',
  imports: [Icon, FeatureStrip],
  templateUrl: './hero.html',
})
export class Hero {}
