import { Component, input } from '@angular/core';

export type IconName =
  | 'crosshair'
  | 'person'
  | 'box'
  | 'map-pin'
  | 'user'
  | 'cart'
  | 'arrow-right'
  | 'mouse'
  | 'layers'
  | 'shield-check';

@Component({
  selector: 'app-icon',
  templateUrl: './icon.html',
})
export class Icon {
  readonly name = input.required<IconName>();
  readonly iconClass = input<string>('w-6 h-6');
}
