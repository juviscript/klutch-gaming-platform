import { Component, input, signal } from '@angular/core';
import { Icon } from '../icon/icon';

@Component({
  selector: 'app-carousel',
  imports: [Icon],
  templateUrl: './carousel.html',
})
export class Carousel {
  readonly images = input.required<string[]>();
  readonly alt = input<string>('');

  readonly activeIndex = signal(0);

  next(): void {
    const count = this.images().length;
    this.activeIndex.update((i) => (i + 1) % count);
  }

  previous(): void {
    const count = this.images().length;
    this.activeIndex.update((i) => (i - 1 + count) % count);
  }

  goTo(index: number): void {
    this.activeIndex.set(index);
  }
}
