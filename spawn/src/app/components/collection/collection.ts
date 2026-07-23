import { Component } from '@angular/core';
import { Icon } from '../icon/icon';

interface Product {
  index: string;
  name: string;
  description: string;
  image: string;
}

@Component({
  selector: 'app-collection',
  imports: [Icon],
  templateUrl: './collection.html',
})
export class Collection {
  readonly products: Product[] = [
    {
      index: '01',
      name: 'Smooth Shot',
      description: 'FPS Precision.\nWrist Support.\nZero Distraction.',
      image: '/images/smoothshot/smoothshot-product-image-center.png',
    },
    {
      index: '02',
      name: 'Compass',
      description: 'Analog Movement.\nDigital Precision.\nTotal Control.',
      image: '/images/compass/compass-product-image-left.png',
    },
  ];
}
