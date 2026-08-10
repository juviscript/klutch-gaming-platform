import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon } from '../../../components/icon/icon';

interface Faq {
  question: string;
  answer: string;
}

const ETSY_SHOP_URL =
  'https://www.etsy.com/shop/KlutchGamingStore?plkey=EuEOunJrWz4jipzD0uOav3taTWc0%3ALTaacbc7299845a1c8375f315c8ff90eb0844e2763';

@Component({
  selector: 'app-product-compass',
  imports: [Icon, RouterLink],
  templateUrl: './compass.html',
})
export class ProductCompass {
  readonly shopUrl = ETSY_SHOP_URL;

  readonly faqs: Faq[] = [
    {
      question: 'When will Compass be available?',
      answer: "Compass is launching soon. Check the shop or follow along for the release announcement.",
    },
    {
      question: 'Will there be a companion app?',
      answer: 'Yes — Meridian, our configuration app for remapping keys, tuning sensitivity, and managing profiles.',
    },
    {
      question: 'What does Compass do?',
      answer:
        'It maps four analog directions plus a click into keyboard keypresses, giving you precise, remappable control for any game.',
    },
  ];
}
