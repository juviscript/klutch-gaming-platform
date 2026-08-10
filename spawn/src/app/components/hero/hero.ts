import { Component } from '@angular/core';
import { Icon } from '../icon/icon';
import { FeatureStrip } from '../feature-strip/feature-strip';
import { ScrollHint } from '../scroll-hint/scroll-hint';

@Component({
  selector: 'app-hero',
  imports: [Icon, FeatureStrip, ScrollHint],
  templateUrl: './hero.html',
})
export class Hero {}
