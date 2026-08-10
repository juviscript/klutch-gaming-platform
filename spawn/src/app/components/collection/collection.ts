import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon } from '../icon/icon';
import { ScrollHint } from '../scroll-hint/scroll-hint';

interface Product {
  id: string;
  index: string;
  name: string;
  description: string;
  image: string;
  link: string;
}

@Component({
  selector: 'app-collection',
  imports: [Icon, ScrollHint, RouterLink],
  templateUrl: './collection.html',
})
export class Collection {
  readonly products: Product[] = [
    {
      id: 'smooth-shot',
      index: '01',
      name: 'Smooth Shot',
      description: 'FPS Precision.\nWrist Support.\nZero Distraction.',
      image: '/images/smoothshot/smoothshot-product-image-right.png',
      link: '/products/smooth-shot',
    },
    {
      id: 'compass',
      index: '02',
      name: 'Compass',
      description: 'Analog Movement.\nDigital Precision.\nTotal Control.',
      image: '/images/compass/compass-product-image-left.png',
      link: '/products/compass',
    },
  ];
}
