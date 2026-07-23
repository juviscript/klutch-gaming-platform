import { Component } from '@angular/core';
import { Icon, IconName } from '../icon/icon';

interface Stat {
  icon: IconName;
  label: string;
  value: string;
}

@Component({
  selector: 'app-promise',
  imports: [Icon],
  templateUrl: './promise.html',
})
export class PromiseSection {
  readonly stats: Stat[] = [
    { icon: 'map-pin', label: 'Designed in', value: 'Florida' },
    { icon: 'layers', label: 'Small Batch', value: 'Production' },
    { icon: 'shield-check', label: 'Tested by', value: 'Real Players' },
  ];
}
