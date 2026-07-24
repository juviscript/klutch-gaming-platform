import { Component } from '@angular/core';
import { Icon } from '../icon/icon';
import { ScrollHint } from '../scroll-hint/scroll-hint';

interface Product {
  index: string;
  name: string;
  description: string;
  image: string;
  url: string;
}

const ETSY_SHOP_URL =
  'https://www.etsy.com/shop/KlutchGamingStore?plkey=EuEOunJrWz4jipzD0uOav3taTWc0%3ALTaacbc7299845a1c8375f315c8ff90eb0844e2763';

@Component({
  selector: 'app-collection',
  imports: [Icon, ScrollHint],
  templateUrl: './collection.html',
})
export class Collection {
  readonly products: Product[] = [
    {
      index: '01',
      name: 'Smooth Shot',
      description: 'FPS Precision.\nWrist Support.\nZero Distraction.',
      image: '/images/smoothshot/smoothshot-product-image-center.png',
      url: `${ETSY_SHOP_URL}&section_id=54387079`,
    },
    {
      index: '02',
      name: 'Compass',
      description: 'Analog Movement.\nDigital Precision.\nTotal Control.',
      image: '/images/compass/compass-product-image-left.png',
      url: ETSY_SHOP_URL,
    },
  ];
}
