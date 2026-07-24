import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon } from '../../../components/icon/icon';

interface ProductCard {
  name: string;
  blurb: string;
  image: string;
  link: string;
}

@Component({
  selector: 'app-support-hub',
  imports: [Icon, RouterLink],
  templateUrl: './support-hub.html',
})
export class SupportHub {
  readonly products: ProductCard[] = [
    {
      name: 'Compass',
      blurb: 'Setup, the Meridian software, firmware updates, and troubleshooting.',
      image: '/images/compass/compass-product-image-left.png',
      link: '/support/compass',
    },
    {
      name: 'Smooth Shot',
      blurb: 'Care instructions, general troubleshooting, and warranty info.',
      image: '/images/smoothshot/smoothshot-product-image-center.png',
      link: '/support/smooth-shot',
    },
  ];
}
